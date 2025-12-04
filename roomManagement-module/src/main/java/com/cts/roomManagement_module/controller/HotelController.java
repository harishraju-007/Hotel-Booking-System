package com.cts.roomManagement_module.controller;

import com.cts.roomManagement_module.dto.HotelDto;
import com.cts.roomManagement_module.dto.Response;
import com.cts.roomManagement_module.dto.RoomDto;
import com.cts.roomManagement_module.dto.RoomRequest;
import com.cts.roomManagement_module.entity.Hotel;
import com.cts.roomManagement_module.entity.Room;
import com.cts.roomManagement_module.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping("/createHotel")
    public ResponseEntity<Response<?>> createHotel(@RequestBody HotelDto hotelDto){
        Hotel hotel = hotelService.createHotel(hotelDto.getHoteId(), hotelDto.getHotelName(), hotelDto.getNoOfRooms(), hotelDto.getNoOfACRooms(), hotelDto.getNoOfNonACRooms(), hotelDto.getAvailableRooms());
        Response<Hotel> response = new Response<>(true, HttpStatus.OK, hotel, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/addRoom")
    public ResponseEntity<Response<?>> addRoom(@RequestBody RoomDto roomDto){
        Room room = hotelService.addRoom(roomDto.getRoom_no(), roomDto.getAvailable(), roomDto.getType(), roomDto.getPrice(), roomDto.getHotelId());
        Response<Room> response = new Response<>(true, HttpStatus.OK, room, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getAllHotels")
    public ResponseEntity<Response<?>> getAllHotels(){
        List<Hotel> hotels = hotelService.getAllHotels();
        Response<List<Hotel>> response = new Response<>(true, HttpStatus.OK, hotels, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/findHotelByRoomId")
    public ResponseEntity<Response<?>> findHotelByRoomId(@RequestBody RoomRequest roomRequest){
        Hotel hotel = hotelService.findHotelByRoomId(roomRequest.getRoomId());
        Response<Hotel> response = new Response<>(true, HttpStatus.OK, hotel, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
