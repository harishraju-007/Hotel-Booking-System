package com.cts.roomManagement_module.service;

import com.cts.roomManagement_module.entity.Hotel;
import com.cts.roomManagement_module.entity.Room;
import com.cts.roomManagement_module.enums.RoomType;
import com.cts.roomManagement_module.repository.HotelRepository;
import com.cts.roomManagement_module.repository.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    HotelRepository hotelRepository;

    @Transactional
    public Room createRoom(Integer roomNo, Boolean isAvailable, RoomType type, Integer price, UUID hotelId) {
        Hotel currHotel = hotelRepository.findById(hotelId).orElseThrow();
        Room room = new Room(roomNo, isAvailable, type, price, currHotel);

        currHotel.setNoOfRooms(currHotel.getNoOfRooms() + 1);
        if (room.getType() == RoomType.AC) {
            currHotel.setNoOfACRooms(currHotel.getNoOfACRooms() + 1);
        } else {
            currHotel.setNoOfNonACRooms(currHotel.getNoOfNonACRooms() + 1);
        }

        roomRepository.save(room);

        int availableRoomCount = 0;
        for (Room i : roomRepository.findAll()) {
            if (i.getHotel().getHotelId().equals(currHotel.getHotelId()) && i.getAvailable()) {
                availableRoomCount++;
            }
        }
        currHotel.setAvailableRooms(availableRoomCount);

        return room;
    }


    public Room updateAvailability(UUID roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow();
        if(room == null){
            throw new NullPointerException();
        }else {
            Hotel currHotel = room.getHotel();
            currHotel.setAvailableRooms(currHotel.getAvailableRooms()-1);
            room.setAvailable(!(room.getAvailable()));
            roomRepository.save(room);

            return room;
        }
    }

    public List<Room> getAllRooms(UUID hotelId){
        return roomRepository.findByHotel_HotelId(hotelId);
    }

    public Room findRoom(UUID roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow();
        return room;
    }
}
