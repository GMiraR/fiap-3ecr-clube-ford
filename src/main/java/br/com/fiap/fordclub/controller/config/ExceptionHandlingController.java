package br.com.fiap.fordclub.controller.config;

import br.com.fiap.fordclub.service.exception.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler({ServiceException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleServiceException(final ServiceException se) {
        return ErrorResponse.builder()
                .message(se.getMessage())
                .build();
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleGenericError(Exception e) {
        return ErrorResponse.builder()
                .message("Ocorreu um erro sistêmico, verificaremos o mais rápido possĩvel!")
                .build();
    }
}
