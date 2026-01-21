package dk.cbs.cinema_booking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dk.cbs.cinema_booking.dto.payload.ErrorData;
import dk.cbs.cinema_booking.dto.payload.ErrorPayload;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorPayload> handleNotFound(IllegalArgumentException e) {
        ErrorPayload ep =
                new ErrorPayload(new ErrorData("NOT_FOUND", e.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ep);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorPayload> handleConflict(IllegalStateException ex) {
        ErrorPayload payload =
                new ErrorPayload(new ErrorData("CONFLICT", ex.getMessage()));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(payload);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorPayload> handleValidation(MethodArgumentNotValidException ex) {

        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .findFirst()
                .map(error -> error.getField() + " " + error.getDefaultMessage())
                .orElse("Validation error");

        ErrorPayload payload =
                new ErrorPayload(new ErrorData("VALIDATION_ERROR", message));

        return ResponseEntity.badRequest().body(payload);
    }
}

