package com.rodrigo.picpay.validator;

import com.rodrigo.picpay.exception.InvalidUserDataDomainException;
import lombok.experimental.UtilityClass;

import java.util.Optional;
import java.util.function.Supplier;

@UtilityClass
public class UserValidator {

    public static void verificarSeJaExiste(Supplier<Optional<?>> supplier, String mensagemErro) {
        supplier.get().ifPresent(
                result -> { throw new InvalidUserDataDomainException(mensagemErro);
        });
    }







}
