package ru.itfb.jsonlogging.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.itfb.jsonlogging.exception.JsonDataException;

@ControllerAdvice
public class HandlerJsonLoggingException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {JsonDataException.class})
    public ResponseEntity<?> handleBookNotFoundException(JsonDataException jsonDataException, WebRequest request) {
        return handleExceptionInternal(jsonDataException, jsonDataException.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }


}
