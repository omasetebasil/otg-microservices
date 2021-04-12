package com.edureka.onthegoapp.models;

import lombok.Data;

@Data
public class PaymentResponse {
    private String message;
    private boolean success;
    private long paymentId;
}
