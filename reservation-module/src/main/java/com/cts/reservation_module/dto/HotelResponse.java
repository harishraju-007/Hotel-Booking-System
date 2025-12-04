package com.cts.reservation_module.dto;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

public class HotelResponse {
    private UUID hotelId;
    private String hotelName;
    private Integer noOfRooms;
    private Integer noOfACRooms;
    private Integer noOfNonACRooms;
    private Integer availableRooms;

    public UUID getHotelId() {
        return hotelId;
    }

    public void setHotelId(UUID hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Integer getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public Integer getNoOfACRooms() {
        return noOfACRooms;
    }

    public void setNoOfACRooms(Integer noOfACRooms) {
        this.noOfACRooms = noOfACRooms;
    }

    public Integer getNoOfNonACRooms() {
        return noOfNonACRooms;
    }

    public void setNoOfNonACRooms(Integer noOfNonACRooms) {
        this.noOfNonACRooms = noOfNonACRooms;
    }

    public Integer getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(Integer availableRooms) {
        this.availableRooms = availableRooms;
    }
}

