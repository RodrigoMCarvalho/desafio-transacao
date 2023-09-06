package com.rodrigo.picpay.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ResponseError{

    private String title;
    private int status;
    private String message;

}