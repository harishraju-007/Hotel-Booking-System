package com.cts.payment_module.dto;

import java.util.UUID;

public class PaymentDto {
    UUID paymentId;

    public UUID getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(UUID paymentId) {
        this.paymentId = paymentId;
    }
}
