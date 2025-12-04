package com.cts.roomManagement_module.entity;

import com.cts.roomManagement_module.enums.RoomType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID roomId;
    @Column(nullable = false)
    private Integer roomNo;
    @Column(nullable = false)
    private Boolean isAvailable;
    @Enumerated(EnumType.STRING)
    private RoomType type;
    @Column(nullable = false)
    private Integer price;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="hotelId", nullable = false)
    private Hotel hotel;


    public UUID getRoomId() {
        return roomId;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoom_no(Integer roomNo) {
        this.roomNo = roomNo;
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

    public Integer getPrice(){
        return price;
    }

    public void setPrice(Integer price){
        this.price = price;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }


    public void setRoomId(UUID roomId) {
        this.roomId = roomId;
    }

    public Room(Integer roomNo, Boolean isAvailable, RoomType type, Integer price, Hotel hotel) {
        this.roomNo = roomNo;
        this.isAvailable = isAvailable;
        this.type = type;
        this.price = price;
        this.hotel = hotel;
    }

    public Room(){

    }
}
