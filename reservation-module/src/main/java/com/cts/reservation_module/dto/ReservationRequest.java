package com.cts.reservation_module.dto;

import java.util.UUID;

public class ReservationRequest {
    UUID customerId;
    UUID roomId;
    String fromDate;
    String toDate;
    Integer forNoOfDays;

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerID(UUID customerId) {
        this.customerId = customerId;
    }

//    public UUID getHotelId() {
//        return hotelId;
//    }
//
//    public void setHotelId(UUID hotelId) {
//        this.hotelId = hotelId;
//    }

    public UUID getRoomId() {
        return roomId;
    }

    public void setRoomId(UUID roomId) {
        this.roomId = roomId;
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

    public ReservationRequest(UUID customerId, UUID roomId, String fromDate, String toDate, Integer forNoOfDays) {
        this.customerId = customerId;
//        this.hotelId = hotelId;
        this.roomId = roomId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.forNoOfDays = forNoOfDays;
    }

    public ReservationRequest(){

    }
}
