package com.edureka.onthegoapp.models;

import lombok.Data;

@Data
public class WithdrawalRequest {
    private long curId;
    private long wtlAmt;
    private long drivId;
}
