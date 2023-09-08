package com.rodrigo.picpay.domain.dto;

import java.math.BigDecimal;

public record TransferRequest (BigDecimal value, Long payer, Long payee) {
}
