package com.example.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Global exception handler for the application
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ModelAndView handleEmployeeNotFound(EmployeeNotFoundException ex, HttpServletRequest request) {
        logger.warn("Employee not found: {} for request: {}", ex.getMessage(), request.getRequestURL());

        ModelAndView mav = new ModelAndView("error/employee-not-found");
        mav.addObject("errorMessage", ex.getMessage());
        mav.addObject("timestamp", LocalDateTime.now());
        return mav;
    }

    @ExceptionHandler(ValidationException.class)
    public ModelAndView handleValidationError(ValidationException ex) {
        logger.error("Validation error: {}", ex.getMessage());

        ModelAndView mav = new ModelAndView("error/validation-error");
        mav.addObject("errors", ex.getErrors());
        return mav;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handleValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<String> errorMessages = result.getFieldErrors()
                .stream()
                .map(this::buildErrorMessage)
                .collect(Collectors.toList());

        logger.error("Validation errors: {}", errorMessages);

        ModelAndView mav = new ModelAndView("error/validation-error");
        mav.addObject("errors", errorMessages);
        return mav;
    }

    private String buildErrorMessage(FieldError error) {
        return error.getField() + ": " + error.getDefaultMessage();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleAllUncaughtException(Exception ex, HttpServletRequest request) {
        logger.error("Unknown error occurred: {} for request: {}", ex.getMessage(), request.getRequestURL(), ex);

        ModelAndView mav = new ModelAndView("error/general-error");
        mav.addObject("errorMessage", "An unexpected error occurred. Please contact support.");
        mav.addObject("timestamp", LocalDateTime.now());
        return mav;
    }
}
