package com.cts.reservation_module.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID reservationId;
    @Column(nullable = false)
    String fromDate;
    @Column(nullable = false)
    String toDate;
    @Column(nullable = false)
    Integer forNoOfDays;

    UUID customerId;
    UUID hotelId;
    UUID roomId;
    Integer price;



    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerID(UUID customerId) {
        this.customerId = customerId;
    }

    public UUID getReservationId() {
        return reservationId;
    }

    public void setReservationId(UUID reservationId) {
        this.reservationId = reservationId;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public Integer getForNoOfDays() {
        return forNoOfDays;
    }

    public void setForNoOfDays(Integer forNoOfDays) {
        this.forNoOfDays = forNoOfDays;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Reservation(String fromDate, String toDate, Integer forNoOfDays, UUID hotelId, UUID roomId, UUID customerId, Integer price) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.forNoOfDays = forNoOfDays;
        this.hotelId = hotelId;
        this.roomId = roomId;
        this.customerId = customerId;
        this.price = price;
    }

    public Reservation(){

    }
}
