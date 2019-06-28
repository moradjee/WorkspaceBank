package com.ividata.BankAccountKata.exception;

public class BusinessException extends Exception {
	
	/**
	 * Author Morad MELSAOUI
	 * Classe exception pour les traitements service
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException(String message) {
	      super(message);
	  }

}
