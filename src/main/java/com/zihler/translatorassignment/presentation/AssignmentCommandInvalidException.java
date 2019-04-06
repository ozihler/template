package com.zihler.translatorassignment.presentation;

import com.zihler.translatorassignment.applicationservice.AssignTranslatorRequest;

public class AssignmentCommandInvalidException extends RuntimeException {
    public AssignmentCommandInvalidException(AssignTranslatorRequest command) {
        super(String.format("Command was invalid. All fields need to be set! %s", command));
    }
}
