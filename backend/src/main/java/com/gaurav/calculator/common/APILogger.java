package com.gaurav.calculator.common;


import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import com.gaurav.calculator.model.integration.ErrorResponse;

@Component
public class APILogger {


    private static final String DEFAULT_LOG_STIRNG = "## CALCULATOR_API ##  ";

    public APILogger() {
    }

    public void info(Logger logger, String msg) {
        logger.info(DEFAULT_LOG_STIRNG + msg);
    }

    public void info(Logger logger, String msg, Object obj) {
        logger.info(DEFAULT_LOG_STIRNG + msg, obj);
    }

    public void errorWithException(Logger logger, Exception e, String msg) {
        logger.error(DEFAULT_LOG_STIRNG + msg + "\n", e);
    }

    public void errorResponse(Logger logger, Exception e, ErrorResponse errorResponse) {
        StringBuilder sb = new StringBuilder(DEFAULT_LOG_STIRNG);
        sb.append("HTTP-").append(errorResponse.getErrorCode()).append(" - ").append(errorResponse.getMessage());
        logger.error(sb.toString(), e);
    }

    public void error(Logger logger, String msg) {
        logger.error(DEFAULT_LOG_STIRNG + msg);
    }

    public void error(Logger logger, String msg, Object obj) {
        logger.error(DEFAULT_LOG_STIRNG + msg, obj);
    }

    public void debug(Logger logger, String msg) {
        logger.debug(DEFAULT_LOG_STIRNG + msg);
    }


    public void warn(Logger logger, String msg) {
        logger.warn(DEFAULT_LOG_STIRNG + msg);
    }

    public void warn(Logger logger, Exception exception, String msg) {
        logger.warn(DEFAULT_LOG_STIRNG + msg, exception);
    }
}