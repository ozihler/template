package com.zihler.translatorassignment.presentation;

import com.zihler.translatorassignment.applicationservice.IllegalImpersonationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Wrong input");
    }

    @ExceptionHandler(AssignmentCommandInvalidException.class)
    public ResponseEntity<AssignmentCommandInvalidException> handleAssignmentCommandInvalidException(AssignmentCommandInvalidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex);
    }

    @ExceptionHandler(IllegalImpersonationException.class)
    public ResponseEntity<IllegalImpersonationException> handleIllegalImpersonationException(IllegalImpersonationException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(ex);
    }
}
