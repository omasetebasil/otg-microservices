package com.edureka.onthegoapp.models;


import lombok.*;



@Data
public class PaymentRequest {
   // @ApiModelProperty(value = "The birthdate", example = "1985-12-07", format= "yyyy-MM-dd")
 //  @JsonProperty("curId")
    private long  curId;
    private long pymtAmt;
    private String pymtReason;
    private long tripId;
}
