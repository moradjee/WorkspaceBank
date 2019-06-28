package com.ividata.BankAccountKata.Persistence;

import java.time.LocalDate;
import java.util.List;

import com.ividata.BankAccountKata.Entity.AccountTransactionDTO;

public interface IAccountTransactionDAO {
	
	public List<AccountTransactionDTO> getTransactionByAccountByDateByType(int AccountID,LocalDate date , String typeTransaction);
	
	public List<AccountTransactionDTO> getTransactionByAccountByDate(int AccountID);
	

}
