package com.rodrigo.picpay.validator;

import com.rodrigo.picpay.domain.dto.TransferRequest;
import com.rodrigo.picpay.domain.entity.User;
import com.rodrigo.picpay.domain.enums.UserType;
import com.rodrigo.picpay.exception.BusinessException;
import com.rodrigo.picpay.exception.NotAvailableBalanceException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TransferValidator {

    public static void validateBalance(TransferRequest request, User payer) {
        if(payer.getBalance().getValue().compareTo(request.value()) < 0) {
            throw new NotAvailableBalanceException("Sem saldo disponível");
        }
    }

    public static void validateUserTypeForTransfer(User payer) {
        if(payer.getUserType().equals(UserType.MERCHANT)) {
            throw new BusinessException("Lojistas não podem realizar transferências.");
        }
    }
}
