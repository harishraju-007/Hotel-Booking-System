package com.cts.reservation_module.controller;

import com.cts.reservation_module.dto.ReservationDto;
import com.cts.reservation_module.dto.ReservationRequest;
import com.cts.reservation_module.dto.Response;
import com.cts.reservation_module.entity.Reservation;
import com.cts.reservation_module.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping("/bookRoom")
    public ResponseEntity<Response<?>> bookRoom(@RequestBody ReservationRequest reservationRequest){
        Reservation reservation = reservationService.bookRoom(reservationRequest.getCustomerId(), reservationRequest.getRoomId(), reservationRequest.getFromDate(), reservationRequest.getToDate(), reservationRequest.getForNoOfDays());
        Response<Reservation> response = new Response<>(true, HttpStatus.OK, reservation, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/reservationDetails")
    public ResponseEntity<Response<?>> reservationDetails(@RequestBody ReservationDto reservationDto){
        Reservation reservation = reservationService.reservationDetails(reservationDto.getReservationId());
        Response<Reservation> response = new Response<>(true, HttpStatus.OK, reservation, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
