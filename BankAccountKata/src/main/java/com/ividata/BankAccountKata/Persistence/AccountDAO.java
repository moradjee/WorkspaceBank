package com.ividata.BankAccountKata.Persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ividata.BankAccountKata.Entity.BankAccountDTO;

/**
 * @author Morad MELSAOUI
 *
 */
@Repository
public class AccountDAO implements IAccountDAO  {
	
	public static List<BankAccountDTO> listAccount = new ArrayList<BankAccountDTO>(); 
	
	
	public void Init()
	{
		listAccount.add(new BankAccountDTO((long) 1, 2000));
		listAccount.add(new BankAccountDTO((long) 2, 5000));
		listAccount.add(new BankAccountDTO((long) 3, 1000));
	}

	@Override
	public List<BankAccountDTO> getListAccount() {
		// TODO Auto-generated method stub
		return listAccount;
	}
	
	@Override
	public void saveAccount(BankAccountDTO bankAccountDTO){
//		listAccount.get(bankAccountDTO.getId()
		listAccount.add(bankAccountDTO);
	}
	
	 
}
