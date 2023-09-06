package com.rodrigo.picpay.domain.enums;

import com.rodrigo.picpay.exception.InvalidUserDataDomainException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum UserType {

    COMMON,
    MERCHANT;

    public static UserType getUserType(String tipo) {
        return Arrays.stream(UserType.values())
                .filter(f -> f.name().equals(tipo))
                .findAny()
                .orElseThrow(() -> new InvalidUserDataDomainException("Tipo do usuário informado é inválido"));
    }

}
