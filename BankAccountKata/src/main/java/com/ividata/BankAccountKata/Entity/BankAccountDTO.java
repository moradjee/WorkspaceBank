package com.ividata.BankAccountKata.Entity;

/**
 * @author Morad MELSAOUI
 * 
 * Classe DTO mappée sur la table Account (si nous souhaitons persister les données)
 * 
 */

public class BankAccountDTO {
	
	private Long id;
	private double amount;
	
	public BankAccountDTO() {}
	
	/**
	 * Constructor.
	 * 
	 * @param id int
	 * @param amount int
	 */
	public BankAccountDTO(Long id ,double amount) {
		this.id = id;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
