package com.spark.formation.exception;

import org.springframework.http.HttpStatus;

/**
 * Data not found exception. It will return the Not found HTTP status code
 */
public class DataNotFoundException extends SparkException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2718684463143771498L;

	/**
	 * 
	 * @param code
	 * @param message
	 */
	public DataNotFoundException(String code, String message) {
	super(HttpStatus.NOT_FOUND, code, message);
    }

}
