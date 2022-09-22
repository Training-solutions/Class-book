package com.eschool.classbook.exception;

import com.eschool.openapi.v1.model.ErrorView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class ClassBookExceptionResolver {
    @ExceptionHandler(ClassBookException.class)
    public ResponseEntity<ErrorView> handleException(ClassBookException e) {
        ErrorView errorView = new ErrorView();
        errorView.setMessage(e.getMessage());
        errorView.setStatus(500);
        errorView.setTimestamp(OffsetDateTime.now());
        return new ResponseEntity<>(errorView, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
