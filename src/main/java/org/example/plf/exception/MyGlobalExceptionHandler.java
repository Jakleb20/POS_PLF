package org.example.plf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class MyGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {LocationNotFoundException.class, UserNotFoundException.class, ProductNotFoundException.class})
    public ResponseEntity<ErrorMessage> handleNotFound(RuntimeException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage();

        errorMessage.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorMessage.setTimestamp(LocalDateTime.now());
        errorMessage.setMessage(ex.getMessage());
        errorMessage.setDescription(request.getDescription(false));

        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }


}
