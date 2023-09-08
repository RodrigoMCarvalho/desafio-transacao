package com.rodrigo.picpay.exception;

public class NotAvailableBalanceException extends RuntimeException{
    public NotAvailableBalanceException(String message) {
        super(message);
    }

}
