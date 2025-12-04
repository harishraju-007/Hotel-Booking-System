package com.cts.roomManagement_module.controller;

import com.cts.roomManagement_module.dto.HotelRequest;
import com.cts.roomManagement_module.dto.Response;
import com.cts.roomManagement_module.dto.RoomDto;
import com.cts.roomManagement_module.dto.RoomRequest;
import com.cts.roomManagement_module.entity.Hotel;
import com.cts.roomManagement_module.entity.Room;
import com.cts.roomManagement_module.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class RoomController {

    @Autowired
    RoomService roomService;

    @PostMapping("/toggleAvailable")
    public ResponseEntity<Response<?>> updateAvailability(@RequestBody RoomRequest roomRequest){
        Room room = roomService.updateAvailability(roomRequest.getRoomId());
        Response<Room> response = new Response<>(true, HttpStatus.OK, room, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/getAllRooms")
    public ResponseEntity<Response<?>> getAllRooms(@RequestBody HotelRequest hotelRequest){
        List<Room> rooms = roomService.getAllRooms(hotelRequest.getHotelId());
        Response<List<Room>> response = new Response<>(true, HttpStatus.OK, rooms, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/findRoom")
    public ResponseEntity<Response<?>> findRoom(@RequestBody RoomRequest roomRequest){
        Room room = roomService.findRoom(roomRequest.getRoomId());
        Response<Room> response = new Response<>(true, HttpStatus.OK, room, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
