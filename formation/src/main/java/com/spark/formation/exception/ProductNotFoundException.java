package com.spark.formation.exception;

/**
 * Product Not Found Exception
 */
public class ProductNotFoundException extends DataNotFoundException {

	/**
	 * generated serial ID
	 */
	private static final long serialVersionUID = -585393677381609541L;
	
	/**
	 * Exception code
	 */
	private static final String code = "ERROR_NF_001";
	
	/**
	 * Exception message
	 */
	private static final String message = "Product not found";
	
	/**
	 * 
	 * @param code
	 * @param message
	 */
	public ProductNotFoundException() {
		super(code, message);
	}
	
}
