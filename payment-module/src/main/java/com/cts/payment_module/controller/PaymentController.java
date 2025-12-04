package com.cts.payment_module.controller;

import com.cts.payment_module.dto.PaymentDto;
import com.cts.payment_module.dto.ReservationDto;
import com.cts.payment_module.dto.UserDto;
import com.cts.payment_module.dto.Response;
import com.cts.payment_module.entity.Payment;
import com.cts.payment_module.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity<Response<?>> addPayment(@RequestBody ReservationDto reservationDto){
        Payment payment = paymentService.addPayment(reservationDto.getReservationId());
        Response<Payment> response = new Response<>(true, HttpStatus.OK, payment, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/paymentByCustomerId")
    public ResponseEntity<Response<?>> paymentByCustomerId(@RequestBody UserDto userDto){
        Payment payment =  paymentService.paymentByCustomerId(userDto.getCustomerId());
        Response<Payment> response = new Response<>(true, HttpStatus.OK, payment, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/completePayment")
    public ResponseEntity<Response<?>> completePayment(@RequestBody PaymentDto paymentDto){
        Payment payment = paymentService.completePayment(paymentDto.getPaymentId());
        Response<Payment> response = new Response<>(true, HttpStatus.OK, payment, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
