package com.masai.mail.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MasaiEmailException.class)
    public ResponseEntity<MyErrorDetails> myStudentExceptionHandler(MasaiEmailException me, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(me.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyErrorDetails> myInvalidDataHandler(MethodArgumentNotValidException e, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(e.getBindingResult().getFieldError().getDefaultMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> myAnyExceptionHandler(Exception e, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(e.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MyErrorDetails> myNotFoundExceptionHandler(NoHandlerFoundException e, WebRequest req) {

        MyErrorDetails err = new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(e.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

}
