package com.mooveit.cars.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage {
    private String message;
    private Integer code;

}
