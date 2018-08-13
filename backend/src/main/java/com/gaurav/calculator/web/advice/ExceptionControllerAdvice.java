package com.gaurav.calculator.web.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.gaurav.calculator.common.APILogger;
import com.gaurav.calculator.exception.InvalidEntryException;
import com.gaurav.calculator.model.integration.ErrorResponse;

@ControllerAdvice
public class ExceptionControllerAdvice {
    private static final Logger LOG = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @Autowired
    private APILogger logger;

    @ExceptionHandler({InvalidEntryException.class})
    public ResponseEntity<ErrorResponse>
    invalidEntryHandler(Exception exception) {
        return handleException(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse>
    genericErrorHandler(Exception exception) {
        return handleException(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    private ResponseEntity<ErrorResponse> handleException(Exception exception, HttpStatus status) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(status.value());
        error.setMessage(exception.getMessage());
        logger.errorResponse(LOG, exception, error);
        return new ResponseEntity<>(error, status);
    }
}
