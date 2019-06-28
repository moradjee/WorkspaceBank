package com.ividata.BankAccountKata.service;

import com.ividata.BankAccountKata.Entity.BankAccountDTO;
import com.ividata.BankAccountKata.exception.BusinessException;
import com.ividata.BankAccountKata.exception.InvalidTransactionException;

public interface IAccountService {
	
	public BankAccountDTO getAccount(int Account_id) throws BusinessException;
	
	/**
	 * @param Account_id
	 * @param newAmont
	 *  methode pour mettre à jour le nouveau montant
	 */
	public void saveAmont(int Account_id,double newAmont) throws InvalidTransactionException;

}
