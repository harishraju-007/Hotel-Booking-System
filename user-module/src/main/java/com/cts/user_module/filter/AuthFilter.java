//package com.cts.user_module.filter;
//
//import com.cts.user_module.enums.Role;
//import com.cts.user_module.service.AuthService;
//import com.cts.user_module.service.UserService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.List;
//
//@Component
//public class AuthFilter extends OncePerRequestFilter {
//
//
//    AuthService authService;
//    UserService userService;
//
//    AuthFilter(AuthService authService, UserService userService){
//        this.authService = authService;
//        this.userService = userService;
//    }
//
//
//    private static final List<String> EXCLUDED_PATHS = List.of("/login", "/register", "/h2-console");
//
//    @Override
//    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
//        String path = request.getRequestURI();
//        return EXCLUDED_PATHS.contains(path);
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String header = request.getHeader("AUTHORIZATION");
//        String token = "";
//        String email = "";
//        String userId = "";
//        String role = "";
//
//        if(header!=null && header.startsWith("Bearer ")){
//            token = header.substring(7);
//            email = authService.extractEmail(token);
//            userId = authService.extractUserId(token);
//            role = authService.extractRole(token);
//        }
//
//        if(email!=null && SecurityContextHolder.getContext().getAuthentication()==null){
//            UserDetails userDetails = userService.loadUserByUsername(email);
//            if(authService.validateToken(token, userDetails)){
//                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authToken);
//            }
//        }
//        request.setAttribute("userId", userId);
//        request.setAttribute("role", role);
//        filterChain.doFilter(request, response);
//    }
//
//}
