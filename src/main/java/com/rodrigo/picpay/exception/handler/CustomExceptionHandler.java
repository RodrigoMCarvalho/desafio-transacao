package com.rodrigo.picpay.exception.handler;

import com.rodrigo.picpay.exception.BusinessException;
import com.rodrigo.picpay.exception.InvalidUserDataDomainException;
import com.rodrigo.picpay.exception.NotAvailableBalanceException;
import com.rodrigo.picpay.exception.NotFoundException;
import com.rodrigo.picpay.exception.dto.ResponseError;
import com.rodrigo.picpay.exception.dto.ValidationError;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomExceptionHandler {

    @ExceptionHandler(InvalidUserDataDomainException.class)
    public ResponseEntity<?> handleInvalidUserDataDomainException (InvalidUserDataDomainException ex) {
        log.error("[handleInvalidUserDataDomainException]",ex);
        ResponseError responseError = ResponseError.builder().status(HttpStatus.BAD_REQUEST.value())
                .title("[handleInvalidUserDataDomainException]")
                .message(ex.getMessage())
                .build();
        return ResponseEntity.badRequest().body(responseError);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleBusinessException (Exception ex) {
        log.error("[handleBusinessException]",ex);
        ResponseError responseError = ResponseError.builder().status(HttpStatus.BAD_REQUEST.value())
                .title("[handleBusinessException]")
                .message(ex.getMessage())
                .build();
        return ResponseEntity.badRequest().body(responseError);
    }

    @ExceptionHandler(NotAvailableBalanceException.class)
    public ResponseEntity<?> handleNotAvailableBalanceException (Exception ex) {
        log.error("[handleNotAvailableBalanceException]",ex);
        ResponseError responseError = ResponseError.builder().status(HttpStatus.BAD_REQUEST.value())
                .title("[handleNotAvailableBalanceException]")
                .message(ex.getMessage())
                .build();
        return ResponseEntity.badRequest().body(responseError);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException (Exception ex) {
        log.error("[handleNotFoundException]",ex);
        ResponseError responseError = ResponseError.builder().status(HttpStatus.NOT_FOUND.value())
                .title("[handleNotFoundException]")
                .message(ex.getMessage())
                .build();
        return ResponseEntity.badRequest().body(responseError);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleValidationException (ConstraintViolationException ex) {
        log.error("[handleValidationException]",ex);
        ValidationError validationError = ValidationError.builder().status(HttpStatus.BAD_REQUEST.value())
                .title("[handleValidationException]")
                .errors(ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList())
                .build();
        return ResponseEntity.badRequest().body(validationError);
    }
}
