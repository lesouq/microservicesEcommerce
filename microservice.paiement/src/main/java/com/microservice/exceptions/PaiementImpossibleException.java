package com.microservice.exceptions;

public class PaiementImpossibleException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PaiementImpossibleException(String message) {
		super(message);
	}
}
