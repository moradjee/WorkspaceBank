package com.ividata.BankAccountKata.Entity;

import java.time.LocalDate;

/**
 * @author Morad MELSAOUI
 * 
 * Classe DTO mappée sur la table Account Transaction pour tracer les transactions
 * (si nous souhaitons persister les données)
 * 
 */

public class AccountTransactionDTO {
	
	private Long id;
	private int CustomerID;
	private int AccountId;
	private String type;
	private double amount;
	private LocalDate date;
	
	public AccountTransactionDTO() {}
	
	/**
	 * Constructor.
	 * 
	 * @param CustomerID int
	 * @param AccountId int
	 * @param type String
	 * @param amount double
	 * @param date LocalDate
	 */
	public AccountTransactionDTO(int CustomerID, int AccountId, String type,double amount, LocalDate date) {
		this.CustomerID = CustomerID;
		this.AccountId = AccountId;
		this.type = type;
		this.amount = amount;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}

	public int getAccountId() {
		return AccountId;
	}

	public void setAccountId(int accountId) {
		AccountId = accountId;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
