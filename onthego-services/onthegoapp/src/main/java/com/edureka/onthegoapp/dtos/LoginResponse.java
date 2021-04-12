package com.edureka.onthegoapp.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder =  true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponse {
    private String accessToken;
    private String tokenType;
    private String refreshToken;
    private String expires;
    private String scope;
    private String jti;
    private Boolean success;
    private Long code;
    private String error;
    private String errorDescription;
}
