package com.cts.reservation_module.exception;

public class RoomNotAvailableException extends RuntimeException {

    String message;
    public RoomNotAvailableException(String message){
        this.message = message;
    }
}
