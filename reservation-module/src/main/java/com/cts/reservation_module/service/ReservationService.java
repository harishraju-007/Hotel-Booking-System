package com.cts.reservation_module.service;

import com.cts.reservation_module.Repository.ReservationRepository;
import com.cts.reservation_module.dto.*;
import com.cts.reservation_module.entity.Reservation;
import com.cts.reservation_module.enums.Role;
import com.cts.reservation_module.exception.RoleShouldbeCustomerForBookingException;
import com.cts.reservation_module.exception.RoomNotAvailableException;
import com.cts.reservation_module.feign.HotelInterface;
import com.cts.reservation_module.feign.RoomInterface;
import com.cts.reservation_module.feign.UserInterface;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.UUID;

@Service
public class ReservationService {

    @Lazy
    @Autowired
    RoomInterface roomInterface;

    @Lazy
    @Autowired
    UserInterface userInterface;

    @Lazy
    @Autowired
    HotelInterface hotelInterface;

    @Autowired
    ReservationRepository reservationRepository;

    @Transactional
    public Reservation bookRoom(UUID customerId, UUID roomId, String fromDate, String toDate, Integer forNoOfDays) {
        UserDto userDto = new UserDto(customerId);

        ResponseEntity<Response<UserResponse>> userResponseEntity = userInterface.userDetails(userDto);
        if (userResponseEntity == null || userResponseEntity.getBody() == null || userResponseEntity.getBody().getData() == null) {
            throw new RuntimeException("User details not found or response is invalid");
        }
        UserResponse userResponse = (UserResponse) userResponseEntity.getBody().getData();

        if(userResponse.getRole()== Role.CUSTOMER) {
            //this is for converting id->dto
            RoomRequest roomRequest = new RoomRequest(roomId);
            //for finding the room, with the help of dto
            ResponseEntity<Response<RoomResponse>> roomResponseEntity = roomInterface.findRoom(roomRequest);
            Response<RoomResponse> response = roomResponseEntity.getBody();
            if (response == null || response.getData() == null) {
                throw new RuntimeException("Room not found or response is invalid");
            }
            RoomResponse roomResponse = response.getData();
            ResponseEntity<Response<HotelResponse>> hotelResponseEntity = hotelInterface.findHotelByRoomId(roomRequest);
            if(hotelResponseEntity==null || hotelResponseEntity.getBody()==null || hotelResponseEntity.getBody().getData()==null){
                throw new NullPointerException("Hote response not found");
            }
            HotelResponse hotelResponse = hotelResponseEntity.getBody().getData();
            if (roomResponse.getAvailable() == true) {
                Integer totalPrice = roomResponse.getPrice() * forNoOfDays;
                Reservation reservation = new Reservation(fromDate, toDate, forNoOfDays, hotelResponse.getHotelId(), roomId, customerId, totalPrice);
                roomInterface.updateAvailability(roomRequest);
                return reservationRepository.save(reservation);
            } else {
                throw new RoomNotAvailableException("Room Not Available");
            }
        }else{
            throw new RoleShouldbeCustomerForBookingException("Role should be customer for booking the room");
        }
    }

    public Reservation reservationDetails(UUID reservationId) {
        return reservationRepository.findById(reservationId).orElseThrow();
    }
}
