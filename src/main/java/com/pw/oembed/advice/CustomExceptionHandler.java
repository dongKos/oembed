package com.pw.oembed.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pw.oembed.util.exception.BusinessException;

@SuppressWarnings({"rawtypes", "unchecked"})
@RestControllerAdvice(annotations = {Controller.class, RestController.class})
public class CustomExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	protected ResponseEntity handleBusinessException(HttpServletRequest request, HttpServletResponse response, Exception e) {
		e.printStackTrace();
		return new ResponseEntity(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity handleException(HttpServletRequest request, HttpServletResponse response, Exception e) {
		e.printStackTrace();
		return new ResponseEntity(e.getMessage(), null, response.getStatus());
	}
	
    
}
