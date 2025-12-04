package com.cts.user_module.controller;

import com.cts.user_module.dto.LoginDto;
import com.cts.user_module.dto.RegisterDto;
import com.cts.user_module.dto.Response;
import com.cts.user_module.dto.UserDto;
import com.cts.user_module.entity.User;
import com.cts.user_module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{

    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @PostMapping("/register")
    public ResponseEntity<Response<?>> register(@RequestBody RegisterDto registerCredentials){
        User user = userService.register(registerCredentials.getName(), registerCredentials.getEmail(), registerCredentials.getPassword(), registerCredentials.getRole(), registerCredentials.getPhoneNumber(), registerCredentials.getAddress());
        Response<User> response = new Response<>(true, HttpStatus.OK, user, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Response<?>> login(@RequestBody LoginDto loginCredentials){
        User user = userService.login(loginCredentials.getEmail(), loginCredentials.getPassword(), loginCredentials.getRole());
        Response<User> response = new Response<>(true, HttpStatus.OK, user, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/userDetails")
    public ResponseEntity<Response<?>> userDetails(@RequestBody UserDto userDto){
        User user = userService.userDetails(userDto.getUserId());
        Response<User> response = new Response<>(true, HttpStatus.OK, user, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}