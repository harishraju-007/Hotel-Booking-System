package com.cts.payment_module.entity;

import com.cts.payment_module.enums.PaymentStatus;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID paymentId;
    @Column(nullable = false)
    UUID customerId;
    @Column(nullable = false)
    UUID hotelId;
    @Column(nullable = false)
    UUID roomId;
    @Column(nullable = false)
    UUID reservationId;
    Integer Amount;
    @Enumerated(EnumType.STRING)
    PaymentStatus paymentStatus = PaymentStatus.PENDING;

    public UUID getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(UUID paymentId) {
        this.paymentId = paymentId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public UUID getHotelId() {
        return hotelId;
    }

    public void setHotelId(UUID hotelId) {
        this.hotelId = hotelId;
    }

    public UUID getRoomId() {
        return roomId;
    }

    public void setRoomId(UUID roomId) {
        this.roomId = roomId;
    }

    public UUID getReservationId() {
        return reservationId;
    }

    public void setReservationId(UUID reservationId) {
        this.reservationId = reservationId;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Payment(UUID customerId, UUID hotelId, UUID roomId, UUID reservationId, Integer amount) {
        this.customerId = customerId;
        this.hotelId = hotelId;
        this.roomId = roomId;
        this.reservationId = reservationId;
        Amount = amount;
    }
}
