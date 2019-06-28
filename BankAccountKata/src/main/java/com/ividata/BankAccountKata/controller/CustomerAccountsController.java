package com.ividata.BankAccountKata.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ividata.BankAccountKata.Constants.Constants;
import com.ividata.BankAccountKata.Entity.AccountTransactionDTO;
import com.ividata.BankAccountKata.Entity.BankAccountDTO;
import com.ividata.BankAccountKata.Shared.IJsonResponse;
import com.ividata.BankAccountKata.Shared.JsonResponseImpl;
import com.ividata.BankAccountKata.exception.BusinessException;
import com.ividata.BankAccountKata.service.IAccountService;
import com.ividata.BankAccountKata.service.IAccountTransactionService;


/**
 * @author Morad MELSAOUI
 *
 */

@RestController
public class CustomerAccountsController {
	
	@Autowired
	IAccountService accountService;
	
	@Autowired
	IAccountTransactionService accountTransactionService;

	
	/** Logger for class. */
	private static final Logger logger = LoggerFactory.getLogger(CustomerAccountsController.class);
	
	
	@RequestMapping(value ="/withdrawMoney")
	@ResponseBody
	public IJsonResponse withdrawMoney(@RequestParam("amount") BigDecimal amount,@RequestParam("Account_id") int Account_id) throws BusinessException
	{
			IJsonResponse jsonResponse = new JsonResponseImpl();
		try{
			
			BankAccountDTO account = accountService.getAccount(Account_id);
			LocalDate currentdate = LocalDateTime.now().toLocalDate();
				
			// Verification du montant saisie
			if(amount == null || amount.doubleValue() <= Constants.MIN_WITHDRAWAL_PER_DAY)
			{
				jsonResponse.setSuccess(false, "Error", Constants.MSG_EXCEPTION_MIN_WITHDRAWAL_PER_DAY);
				jsonResponse.setHttpResponseCode(HttpStatus.NOT_ACCEPTABLE);
				return jsonResponse;
			}else
			{
				double balance = account.getAmount();
				if (amount.doubleValue() > balance) {
					jsonResponse.setSuccess(false, "Error", Constants.MSG_EXCEPTION_FONDS_INSUFFISANTS);
					jsonResponse.setHttpResponseCode(HttpStatus.NOT_ACCEPTABLE);
					return jsonResponse;
				}
				
				// check maximum limit withdrawal for the day has been reached
				double sommeAmont = accountTransactionService.getSumTransactionByAccoutByDateByType(Account_id, currentdate,Constants.TRANSACTION_RETRAIT_TYPE);
				
				if (sommeAmont > 0 && sommeAmont + amount.doubleValue() > Constants.MAX_WITHDRAWAL_PER_DAY) {
					jsonResponse.setSuccess(false, "Error", Constants.MSG_EXCEPTION_LIMIT_RETRAIT+Constants.MAX_WITHDRAWAL_PER_DAY);
					jsonResponse.setHttpResponseCode(HttpStatus.NOT_ACCEPTABLE);
					return jsonResponse;
				}
				
				// Mise à jour le montant sur le compte du client
				double newBalance = account.getAmount() - amount.doubleValue();
				account.setAmount(newBalance);
				accountService.saveAmont(Account_id, newBalance);
				jsonResponse.setSuccess(true, "", Constants.MSG_SECCUS_DEPOT);
	            jsonResponse.setHttpResponseCode(HttpStatus.OK);
				
				return jsonResponse;
				}
			} catch (Exception e) {
	            logger.error("exception");
	            jsonResponse.setSuccess(false, Constants.MSG_TITLE_VALUE, Constants.MSG_NAME_VALUE);
	            jsonResponse.setHttpResponseCode(HttpStatus.INTERNAL_SERVER_ERROR);
	            return jsonResponse;
	        }
		}
	
	
	 	@RequestMapping(value="/DepositMoney", method = RequestMethod.GET)
		@ResponseBody
	    public IJsonResponse DepositMoney(@RequestParam("amount") BigDecimal amount,@RequestParam("Account_id") int Account_id) throws BusinessException {
	        
	 		IJsonResponse jsonResponse = new JsonResponseImpl();
	        
	        LocalDate currentdate = LocalDateTime.now().toLocalDate();
	        
	        BankAccountDTO account = accountService.getAccount(Account_id);
	        
	        try {
	        	// Vérifer si le seuil maximum de dépot a été atteint par jour
	            double sommeAmont = accountTransactionService.getSumTransactionByAccoutByDateByType(Account_id, currentdate,Constants.TRANSACTION_RETRAIT_TYPE);
	            
	            if (amount.doubleValue() > 0) {
	               
	                if (sommeAmont  + amount.doubleValue() > Constants.MAX_DEPOSIT_PER_DAY) {
	                    jsonResponse.setSuccess(false, "Error", Constants.MSG_MAX_DEPOSIT_PER_DAY);
	                    jsonResponse.setHttpResponseCode(HttpStatus.NOT_ACCEPTABLE);
	                    return jsonResponse;
	                }
	            }
	            
	            // Vérifer si le depot par transaction dépasse la limite 
	            if(amount.doubleValue() > Constants.MAX_DEPOSIT_PER_TRANSACTION) {                
	                jsonResponse.setSuccess(false, "Error", Constants.MSG_MAX_DEPOSIT_PER_TRANSACTION);
	                jsonResponse.setHttpResponseCode(HttpStatus.NOT_ACCEPTABLE);
	                return jsonResponse;
	            }
	            
	            	// Mise à jour le montant sur le compte du client
	                double newBalance = sommeAmont  + amount.doubleValue();
	                account.setAmount(newBalance);
					accountService.saveAmont(Account_id, newBalance);
	                jsonResponse.setSuccess(true, "", Constants.MSG_SECCUS_DEPOT);
	                jsonResponse.setHttpResponseCode(HttpStatus.OK);
	                
	                return jsonResponse;
	                
	            
	        } catch (Exception e) {
	            logger.error("exception");
	            jsonResponse.setSuccess(false, Constants.MSG_TITLE_VALUE, Constants.MSG_NAME_VALUE);
	            jsonResponse.setHttpResponseCode(HttpStatus.INTERNAL_SERVER_ERROR);
	            return jsonResponse;
	        }
	        
	    }
		
	 	@RequestMapping(value="/HistoryMoney", method = RequestMethod.GET)
	    public @ResponseBody IJsonResponse getBalance(@RequestParam("Account_id") int Account_id) throws BusinessException {
	        
	 		IJsonResponse jsonResponse = new JsonResponseImpl();
	        HashMap<String, Object> responseData = new HashMap<>();
	        
	        try {
	        	BankAccountDTO account = accountService.getAccount(Account_id);
	        	List<AccountTransactionDTO> listHistoryTransaction = accountTransactionService.getHistoryTransactionByAccoutByDate(Account_id);
	            
	        	
	            if (account != null) {
	                responseData.put("balance", "$"+ account.getAmount());
	                for(AccountTransactionDTO historyTransaction : listHistoryTransaction)
	                {
	                responseData.put("L'Historique des transaction "+historyTransaction.getId()+" : ", historyTransaction.getType() + " "+historyTransaction.getDate()+ " "+ historyTransaction.getAmount());
	                }
	                jsonResponse.setSuccess(true);
	                jsonResponse.setData(responseData);
	                jsonResponse.setHttpResponseCode(HttpStatus.OK);
	            } else {
	                jsonResponse.setSuccess(false, "Resource not found", Constants.NOT_FOUND_MSG);
	                jsonResponse.setHttpResponseCode(HttpStatus.NO_CONTENT);
	            }
	            
	        } catch (Exception e) {
	            logger.error("exception", e);
	            jsonResponse.setSuccess(false, Constants.MSG_TITLE_VALUE, Constants.MSG_NAME_VALUE);
	            jsonResponse.setHttpResponseCode(HttpStatus.INTERNAL_SERVER_ERROR);
	            return jsonResponse;
	        }
	        
	        return jsonResponse;
	    }

}
