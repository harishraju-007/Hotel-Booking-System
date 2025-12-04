package com.cts.reservation_module.feign;

import com.cts.reservation_module.dto.Response;
import com.cts.reservation_module.dto.UserDto;
import com.cts.reservation_module.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("USER-MODULE")
public interface UserInterface {

    @PostMapping("/userDetails")
    public ResponseEntity<Response<UserResponse>> userDetails(@RequestBody UserDto userDto);

}
