package com.cts.user_module.dto;

import java.util.UUID;

public class UserDto {
    UUID userId;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
