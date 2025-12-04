package com.cts.reservation_module.exception;

public class RoleShouldbeCustomerForBookingException extends RuntimeException{
    String message;
    public RoleShouldbeCustomerForBookingException(String message){
        this.message = message;
    }
}
