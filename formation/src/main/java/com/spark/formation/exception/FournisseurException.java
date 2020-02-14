package com.spark.formation.exception;

public class FournisseurException  extends DataNotFoundException  {

	public FournisseurException(String code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
private static final String code = "ERROR_NF_001";
	
	/**
	 * Exception message
	 */
	private static final String message = "Fornisseur not found";
	
	/**
	 * 
	 * @param code
	 * @param message
	 */
	
	
}


