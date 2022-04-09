package org.shulgin.api.exception_handlers;

import org.shulgin.api.exception.IncorrectUserData;
import org.shulgin.api.exception.NoSuchUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler
    public ResponseEntity<IncorrectUserData> exceptionHandler(
            NoSuchUserException exception) {
        IncorrectUserData incorrectUserData = new IncorrectUserData();
        incorrectUserData.setInfo(exception.getMessage());
        return new ResponseEntity<>(incorrectUserData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectUserData> exceptionHandler(
            Exception exception) {
        IncorrectUserData incorrectUserData = new IncorrectUserData();
        incorrectUserData.setInfo(exception.getMessage());
        return new ResponseEntity<>(incorrectUserData, HttpStatus.NOT_FOUND);
    }
}
