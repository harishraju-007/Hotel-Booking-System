package com.cts.user_module.service;

import com.cts.user_module.dto.HotelDto;
import com.cts.user_module.entity.User;
//import com.cts.user_module.entity.UserPrinciple;
import com.cts.user_module.enums.Role;
import com.cts.user_module.feign.HotelInterface;
import com.cts.user_module.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Lazy
    @Autowired
    private HotelInterface hotelInterface;


    @Transactional
    public User register(String name, String email, String password, Role role, Long phoneNumber, String address){
        User newUser = new User(name, email, password, role, phoneNumber, address);
        userRepository.save(newUser);
        //for Integrating with Room Management module
        try{
            if(role==Role.OWNER){
                HotelDto hotelDto = new HotelDto(newUser.getUserId(), newUser.getName(), 0, 0, 0);
                hotelInterface.createHotel(hotelDto);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return newUser;
    }

    public User login(String email, String password, Role role){
        User user = userRepository.findByEmail(email);
        if(user.getRole() == role && Objects.equals(user.getPassword(), password)){
            return user;
        }
        return new User();
    }

    public User userDetails(UUID userId) {
        User currUser = userRepository.findById(userId).orElseThrow();
        return currUser;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(username);
//        if(user==null){
//            throw new RuntimeException();
//        }
//        return new UserPrinciple(user);
//    }
}