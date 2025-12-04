package com.cts.user_module.feign;

import com.cts.user_module.dto.HotelDto;
import com.cts.user_module.dto.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("ROOMMANAGEMENT-MODULE")
public interface HotelInterface {

    @PostMapping("/createHotel")
    public ResponseEntity<Response<?>> createHotel(@RequestBody HotelDto hotelDto);


}
