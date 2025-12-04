package com.cts.payment_module.service;

import com.cts.payment_module.Repository.PaymentRepository;
import com.cts.payment_module.dto.ReservationDto;
import com.cts.payment_module.dto.ReservationResponse;
import com.cts.payment_module.dto.Response;
import com.cts.payment_module.entity.Payment;
import com.cts.payment_module.enums.PaymentStatus;
import com.cts.payment_module.feign.ReservationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Lazy
    @Autowired
    ReservationInterface reservationInterface;

    public Payment addPayment(UUID reservationId) {
        ReservationDto reservationDto = new ReservationDto(reservationId);
        ResponseEntity<Response<ReservationResponse>> reservationResponseEntity = reservationInterface.reservationDetails(reservationDto);

        if(reservationResponseEntity == null || reservationResponseEntity.getBody() == null || reservationResponseEntity.getBody().getData() == null){
            throw new NullPointerException("Reservation response not found");
        }
        ReservationResponse reservationResponse = reservationResponseEntity.getBody().getData();
        Payment payment = new Payment(reservationResponse.getCustomerId(), reservationResponse.getHotelId(), reservationResponse.getRoomId(), reservationId, reservationResponse.getPrice());
        return paymentRepository.save(payment);
    }

    public Payment paymentByCustomerId(UUID customerId) {
        return paymentRepository.findPaymentByCustomerId(customerId);
    }


    public Payment completePayment(UUID paymentId) {
        Payment payment = paymentRepository.findById(paymentId).orElseThrow();
        payment.setPaymentStatus(PaymentStatus.COMPLETED);
        return payment;
    }
}
