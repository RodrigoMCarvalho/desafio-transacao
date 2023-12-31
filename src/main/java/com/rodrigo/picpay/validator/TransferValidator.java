package com.rodrigo.picpay.validator;

import com.rodrigo.picpay.domain.dto.AuthorizerMockResponse;
import com.rodrigo.picpay.domain.dto.TransferRequest;
import com.rodrigo.picpay.domain.entity.User;
import com.rodrigo.picpay.domain.enums.UserType;
import com.rodrigo.picpay.exception.BusinessException;
import com.rodrigo.picpay.exception.NotAuthorizedException;
import com.rodrigo.picpay.exception.NotAvailableBalanceException;
import lombok.experimental.UtilityClass;

import java.util.Objects;

@UtilityClass
public class TransferValidator {

    public static void validateBalance(TransferRequest request, User payer) {
        if(payer.getBalance().getValue().compareTo(request.value()) < 0) {
            throw new NotAvailableBalanceException("Saldo insuficiente.");
        }
    }

    public static void validateUserTypeForTransfer(User payer) {
        if(payer.getUserType().equals(UserType.MERCHANT)) {
            throw new BusinessException("Lojistas não podem realizar transferências.");
        }
    }

    public static void checkAuthorization(AuthorizerMockResponse authorizerMockResponse) {
        if(!Objects.equals(authorizerMockResponse.message(), "Autorizado")) {
            throw new NotAuthorizedException("Não autorizado.");
        }
    }
}
