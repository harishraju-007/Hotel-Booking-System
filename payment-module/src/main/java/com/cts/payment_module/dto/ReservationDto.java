package com.cts.payment_module.dto;

import java.util.UUID;

public class ReservationDto {
    UUID reservationId;

    public UUID getReservationId() {
        return reservationId;
    }

    public void setReservationId(UUID reservationId) {
        this.reservationId = reservationId;
    }

    ReservationDto(){

    }

    public ReservationDto(UUID reservationId) {
        this.reservationId = reservationId;
    }
}
