package com.cts.roomManagement_module.entity;

import com.cts.roomManagement_module.enums.RoomType;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="hotels")
public class Hotel {
    @Id
    @Column(nullable = false, unique = true)
    private UUID hotelId;
    @Column(nullable = false)
    private String hotelName;
    @Column(nullable = false)
    private Integer noOfRooms;
    @Column(nullable = false)
    private Integer noOfACRooms;
    @Column(nullable = false)
    private Integer noOfNonACRooms;
    private Integer availableRooms;
    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;

    public UUID getHotelId(){
        return hotelId;
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

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Integer getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(Integer availableRooms) {
        this.availableRooms = availableRooms;
    }

    public Hotel(UUID hotelId, String hotelName, Integer noOfRooms, Integer noOfACRooms, Integer noOfNonACRooms, Integer availableRooms) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.noOfRooms = noOfRooms;
        this.noOfACRooms = noOfACRooms;
        this.noOfNonACRooms = noOfNonACRooms;
        this.availableRooms = availableRooms;
    }

    public Hotel(){

    }
}
