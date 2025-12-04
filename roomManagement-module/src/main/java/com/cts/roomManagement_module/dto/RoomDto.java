package com.cts.roomManagement_module.dto;

import com.cts.roomManagement_module.enums.RoomType;

import java.util.UUID;

public class RoomDto {
    private Integer room_no;
    private Boolean isAvailable = true;
    private RoomType type;
    private Integer price;
    private UUID hotelId;

    public Integer getRoom_no() {
        return room_no;
    }

    public void setRoom_no(Integer room_no) {
        this.room_no = room_no;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public UUID getHotelId() {
        return hotelId;
    }

    public void setHotelId(UUID hotelId) {
        this.hotelId = hotelId;
    }

    public RoomDto(Integer room_no, Boolean isAvailable, RoomType type, Integer price, UUID hotelId) {
        this.isAvailable = isAvailable;
        this.room_no = room_no;
        this.type = type;
        this.price = price;
        this.hotelId = hotelId;
    }
}
