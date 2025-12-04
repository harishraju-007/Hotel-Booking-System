package com.cts.reservation_module.dto;

import java.util.UUID;

public class RoomRequest {
    UUID roomId;

    public UUID getRoomId() {
        return roomId;
    }

    public void setRoomId(UUID roomId) {
        this.roomId = roomId;
    }

    public RoomRequest(UUID roomId) {
        this.roomId = roomId;
    }
}
