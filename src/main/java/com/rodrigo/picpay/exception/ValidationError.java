package com.rodrigo.picpay.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ValidationError {

    private String title;
    private int status;
    private List<String> errors;
}
