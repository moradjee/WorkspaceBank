package com.ividata.BankAccountKata.Persistence;

import java.util.List;

import com.ividata.BankAccountKata.Entity.BankAccountDTO;

public interface IAccountDAO {
	
	public List<BankAccountDTO> getListAccount();
	
	public void saveAccount(BankAccountDTO bankAccountDTO);

}
