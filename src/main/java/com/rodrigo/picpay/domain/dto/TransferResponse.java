package com.rodrigo.picpay.domain.dto;


public record TransferResponse(UserResponse payer, UserResponse payee) {
}
