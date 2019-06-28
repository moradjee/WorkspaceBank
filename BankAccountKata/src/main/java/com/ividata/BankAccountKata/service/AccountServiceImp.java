package com.ividata.BankAccountKata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ividata.BankAccountKata.Constants.Constants;
import com.ividata.BankAccountKata.Entity.BankAccountDTO;
import com.ividata.BankAccountKata.Persistence.IAccountDAO;
import com.ividata.BankAccountKata.exception.BusinessException;
import com.ividata.BankAccountKata.exception.InvalidTransactionException;

/**
 * @author Morad MELSAOUI
 *
 */

@Service
@Transactional(rollbackFor = InvalidTransactionException.class)
public class AccountServiceImp implements IAccountService {
	
	@Autowired
	IAccountDAO accountDAO;
	
	@Override
	public BankAccountDTO getAccount(int Account_id) throws BusinessException
	{
		BankAccountDTO bankAccountdto = accountDAO.getListAccount().get(Account_id);
		if(bankAccountdto == null)
		{
			throw new BusinessException(Constants.MSG_ACCOUNT_NOT_FOUND_EXCEPTION);
		}
		return accountDAO.getListAccount().get(Account_id);
	}
	
	@Override
	public void saveAmont(int Account_id,double newAmont) throws InvalidTransactionException
	{
		BankAccountDTO bankAccountdto = accountDAO.getListAccount().get(Account_id);
		if(bankAccountdto == null)
		{
			throw new InvalidTransactionException(Constants.MSG_ACCOUNT_NOT_FOUND_EXCEPTION);
		}
		bankAccountdto.setAmount(newAmont);
		accountDAO.saveAccount(bankAccountdto);
	}
	
}
