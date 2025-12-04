package com.cts.user_module.dto;

import java.util.UUID;

public class HotelDto {
    private UUID hoteId;
    private String hotelName;
    private Integer noOfRooms;
    private Integer noOfACRooms;
    private Integer noOfNonACRooms;

    public UUID getHoteId() {
        return hoteId;
    }

    public void setHoteId(UUID hoteId) {
        this.hoteId = hoteId;
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

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setNoOfNonACRooms(Integer noOfNonACRooms) {
        this.noOfNonACRooms = noOfNonACRooms;
    }

    public HotelDto(UUID hoteId, String hotelName, Integer noOfRooms, Integer noOfACRooms, Integer noOfNonACRooms) {
        this.hoteId = hoteId;
        this.hotelName = hotelName;
        this.noOfRooms = noOfRooms;
        this.noOfACRooms = noOfACRooms;
        this.noOfNonACRooms = noOfNonACRooms;
    }

    public HotelDto(){

    }
}
