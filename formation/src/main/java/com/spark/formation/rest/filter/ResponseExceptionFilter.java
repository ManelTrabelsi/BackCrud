package com.spark.formation.rest.filter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.spark.formation.exception.SparkException;
import com.spark.formation.rest.dto.DataExceptionDto;

/**
 * Rest Exception handler
 */
@ControllerAdvice
public class ResponseExceptionFilter extends ResponseEntityExceptionHandler {

	/**
	 * SparkException handler: construct and return <code>DataExceptionDto</code> json response object.
	 * 
	 * @param ex : SparkException
	 * @param request : WebRequest
	 * @return ResponseEntity
	 */
	@ExceptionHandler({ SparkException.class })
	public ResponseEntity<Object> handleWeviooException(SparkException ex, WebRequest request) {
		DataExceptionDto response = new DataExceptionDto(ex.getHttpStatus(), ex.getCode(), ex.getMessage(), ex.getData());
		return new ResponseEntity<Object>(response,	new HttpHeaders(), ex.getHttpStatus());
	}

}
