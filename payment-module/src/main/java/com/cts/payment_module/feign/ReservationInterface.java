package com.cts.payment_module.feign;

import com.cts.payment_module.dto.ReservationDto;
import com.cts.payment_module.dto.ReservationResponse;
import com.cts.payment_module.dto.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("RESERVATION-MODULE")
public interface ReservationInterface {

    @PostMapping("/reservationDetails")
    public ResponseEntity<Response<ReservationResponse>> reservationDetails(@RequestBody ReservationDto reservationDto);
}
