package com.cts.reservation_module.feign;

import com.cts.reservation_module.dto.HotelResponse;
import com.cts.reservation_module.dto.Response;
import com.cts.reservation_module.dto.RoomRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("ROOMMANAGEMENT-MODULE")
public interface HotelInterface {

    @PostMapping("/findHotelByRoomId")
    public ResponseEntity<Response<HotelResponse>> findHotelByRoomId(@RequestBody RoomRequest roomRequest);
}
