package com.ividata.BankAccountKata.service;

import java.time.LocalDate;
import java.util.List;

import com.ividata.BankAccountKata.Entity.AccountTransactionDTO;

public interface IAccountTransactionService {
	
	
	public double getSumTransactionByAccoutByDateByType(int accountId, LocalDate date, String typeTransaction);
	
	public List<AccountTransactionDTO> getHistoryTransactionByAccoutByDate(int accountId);

	

}
