package com.rodrigo.picpay.mapper;

import com.rodrigo.picpay.domain.dto.TransferResponse;
import com.rodrigo.picpay.domain.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TransferMapper {

    public static TransferResponse toTransferResponse(User payee, User payer) {
        return new TransferResponse(UserMapper.toUserResponse(payee), UserMapper.toUserResponse(payer));
   }
}
