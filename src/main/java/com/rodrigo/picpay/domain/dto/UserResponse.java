package com.rodrigo.picpay.domain.dto;

import com.rodrigo.picpay.domain.enums.UserType;

import java.math.BigDecimal;

public record UserResponse(Long id, String name, String document, String email, UserType userType, BigDecimal balance) {
}
