package com.ividata.BankAccountKata.Persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ividata.BankAccountKata.Constants.Constants;
import com.ividata.BankAccountKata.Entity.AccountTransactionDTO;

/**
 * @author Morad MELSAOUI
 *
 */
@Repository
public class AccountTransactionDAO implements IAccountTransactionDAO {
	
static List<AccountTransactionDTO> listAccountTransaction = new ArrayList<AccountTransactionDTO>();
	
	/*
	 * 
	 *@param AccountID
	 *@param date
	 *@param typeTransaction
	 * Simulation pour alimenter l'historique des transactions
	 */
	@Override
	public List<AccountTransactionDTO> getTransactionByAccountByDateByType(int AccountID,LocalDate date, String typeTransaction) {
		// TODO Auto-generated method stub
		
		// simuler deux transactions courantes au même jour
		LocalDate currentTime = LocalDateTime.now().toLocalDate();
		AccountTransactionDTO accountTransactionDTO = new AccountTransactionDTO();
		accountTransactionDTO.setAmount(100);
		accountTransactionDTO.setType(typeTransaction);
		accountTransactionDTO.setDate(currentTime);
		accountTransactionDTO.setCustomerID(1);
		accountTransactionDTO.setAccountId(1);
		listAccountTransaction.add(accountTransactionDTO);
		accountTransactionDTO.setAmount(300);
		listAccountTransaction.add(accountTransactionDTO);
		
		return listAccountTransaction;
	}

	@Override
	public List<AccountTransactionDTO> getTransactionByAccountByDate(
			int AccountID) {
		// TODO Auto-generated method stub
		
		/*traitement qui va etre alimenter pour récuperer de la 
		*BDD la liste des transaction
		*/
		LocalDate currentTime = LocalDateTime.now().toLocalDate();
		AccountTransactionDTO accountTransactionDTO = new AccountTransactionDTO();
		accountTransactionDTO.setId((long) 1);
		accountTransactionDTO.setAmount(100);
		accountTransactionDTO.setType(Constants.TRANSACTION_DEPOSIT_TYPE);
		accountTransactionDTO.setDate(currentTime);
		accountTransactionDTO.setCustomerID(1);
		accountTransactionDTO.setAccountId(1);
		listAccountTransaction.add(accountTransactionDTO);
		
		accountTransactionDTO = new AccountTransactionDTO();
		accountTransactionDTO.setId((long) 2);
		accountTransactionDTO.setAmount(300);
		accountTransactionDTO.setType(Constants.TRANSACTION_DEPOSIT_TYPE);
		accountTransactionDTO.setDate(currentTime);
		accountTransactionDTO.setCustomerID(1);
		accountTransactionDTO.setAccountId(1);
		
		listAccountTransaction.add(accountTransactionDTO);
		return listAccountTransaction;
	}

}
