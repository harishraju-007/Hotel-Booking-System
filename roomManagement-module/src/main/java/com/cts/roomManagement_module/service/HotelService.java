package com.cts.roomManagement_module.service;

import com.cts.roomManagement_module.controller.RoomController;
import com.cts.roomManagement_module.dto.RoomDto;
import com.cts.roomManagement_module.entity.Hotel;
import com.cts.roomManagement_module.entity.Room;
import com.cts.roomManagement_module.enums.RoomType;
import com.cts.roomManagement_module.repository.HotelRepository;
import com.cts.roomManagement_module.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    RoomService roomService;

    public Hotel createHotel(UUID hotelId, String hotelName, Integer noOfRooms, Integer noOfACRooms, Integer noOfNonACRooms, Integer availableRooms) {
        Hotel hotel = new Hotel(hotelId, hotelName, noOfRooms, noOfACRooms, noOfNonACRooms, 0);
        hotelRepository.save(hotel);
        return hotel;
    }

    public Room addRoom(Integer room_no, Boolean isAvailable, RoomType type, Integer price, UUID hotelId){
        return roomService.createRoom(room_no, isAvailable, type, price, hotelId);
    }

    public List<Hotel> getAllHotels(){
        return hotelRepository.findAll();
    }

    public Hotel findHotelByRoomId(UUID roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow();
        return room.getHotel();
    }
}
