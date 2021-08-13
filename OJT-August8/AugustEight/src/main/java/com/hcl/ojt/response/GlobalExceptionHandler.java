package com.hcl.ojt.response;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hcl.ojt.exception.BusinessLogicException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	@ExceptionHandler(BusinessLogicException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public final ResponseWrapper<ExceptionResponse> handleBusinessLogicException(BusinessLogicException ex) {
		log.info("Error occurred: " + ex.getLocalizedMessage());
		return new ResponseWrapper<>(true, HttpStatus.BAD_REQUEST, new ExceptionResponse(new Date(), ex.getLocalizedMessage()));
	}
}
