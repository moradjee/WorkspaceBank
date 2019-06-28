package com.ividata.BankAccountKata.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ividata.BankAccountKata.Entity.AccountTransactionDTO;
import com.ividata.BankAccountKata.Persistence.IAccountTransactionDAO;

@Service
public class AccountTransactionServiceImpl implements IAccountTransactionService {
	
	@Autowired
	IAccountTransactionDAO accountTransactionDAO;
	
	
	/*
	 * 
	 *@param accountId 
	 *@param date
	 *@param typeTransaction
	 * Simulation pour alimenter l'historique des transactions
	 */
	@Override
	public double getSumTransactionByAccoutByDateByType(int accountId,LocalDate date,String typeTransaction)
	{
		List<AccountTransactionDTO> listaccountTransactionDTO = accountTransactionDAO.getTransactionByAccountByDateByType(accountId, date, typeTransaction);
		return (double) listaccountTransactionDTO.stream().map(line -> line.getAmount()).collect(Collectors.summingInt(Double::intValue));
		
	}
	
	/*
	 * 
	 *@param AccountID
	 *@param date
	 *@param typeTransaction
	 * récuperation de la liste des transaction effectuées par le client
	 */
	@Override
	public List<AccountTransactionDTO> getHistoryTransactionByAccoutByDate(int accountId)
	{
		List<AccountTransactionDTO> listaccountTransactionDTO = accountTransactionDAO.getTransactionByAccountByDate(accountId);
		return listaccountTransactionDTO;
	}


}
