package com.cts.payment_module.dto;

import java.util.UUID;

public class UserDto {
    UUID customerId;

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }
}
