package com.pig_auction_service.infra.controllers.errors;

import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<String> handleNullProperty (PropertyValueException ex) {
        String fieldName = ex.getPropertyName();
        String message = "Field '" + fieldName + "' cannot be null.";

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointer( NullPointerException ex) {
        String message = "A required field is missing.";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @ExceptionHandler(NegativeStartingPriceException.class)
    public ResponseEntity<String> handleNegativeStartingprice( NegativeStartingPriceException ex) {

        String message = "Error: " +  ex.getMessage();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument (IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


}
