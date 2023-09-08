package com.rodrigo.picpay.validator;

import com.rodrigo.picpay.exception.InvalidUserDataDomainException;
import lombok.experimental.UtilityClass;

import java.util.Optional;
import java.util.function.Supplier;

@UtilityClass
public class UserValidator {

    public static void checkIfResourceExists(Supplier<Optional<?>> supplier, String errorMsg) {
        supplier.get().ifPresent(
                result -> { throw new InvalidUserDataDomainException(errorMsg);
        });
    }







}
