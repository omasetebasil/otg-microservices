package com.edureka.onthegoapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    SUCCESS(200, "Success"),
    FAILED_REQUEST(422, "Failed Request");

    private int code;

    private String description;
}
