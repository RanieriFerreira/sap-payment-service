package br.com.sap.paymentservice.handler;

import br.com.sap.paymentservice.handler.exception.ErrorMessageResponse;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ErrorMessageResponse> genericError(FeignException ex) {
        ErrorMessageResponse error = new ErrorMessageResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date(),
                ex.getMessage()
        );

        return new ResponseEntity<ErrorMessageResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
