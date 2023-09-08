package com.rodrigo.picpay.service;

import com.rodrigo.picpay.domain.dto.TransferRequest;
import com.rodrigo.picpay.domain.dto.TransferResponse;
import com.rodrigo.picpay.domain.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.rodrigo.picpay.mapper.TransferMapper.toTransferResponse;
import static com.rodrigo.picpay.validator.TransferValidator.*;

@Service
@AllArgsConstructor
public class TransferService {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorizerMockService authorizerMockService;

    public TransferResponse makeTransfer(TransferRequest request) {
        User payee = userService.findById(request.payee());
        User payer = userService.findById(request.payer());

        validateUserTypeForTransfer(payer);
        validateBalance(request, payer);
        checkAuthorization(authorizerMockService.getAuthorizerMock());

        payer.getBalance().setValue(subtractBalanceAmount(request, payer));
        payee.getBalance().setValue(addBalanceAmount(request, payee));

        User payerSalved = userService.saveUser(payer);
        User payeeSalved = userService.saveUser(payee);

        return toTransferResponse(payerSalved, payeeSalved);
    }

    private static BigDecimal addBalanceAmount(TransferRequest request, User payee) {
        return payee.getBalance().getValue().add(request.value());
    }

    private static BigDecimal subtractBalanceAmount(TransferRequest request, User payer) {
        return payer.getBalance().getValue().subtract(request.value());
    }


}
