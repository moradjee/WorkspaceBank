package com.ividata.BankAccountKata.Shared;

import java.util.HashMap;

import org.springframework.http.HttpStatus;

/**
 * @author Morad MELSAOUI
 *
 */

public interface IJsonResponse {
	
		
	public void setSuccess(boolean success);

	public void setSuccess(boolean success, String title, String msg);

	/**
	 * @return the success
	 */
	public boolean isSuccess();

	/**
	 * @param messages
	 *            the messages to set
	 */
	public void setMessages(HashMap<String, String> messages);

	/**
	 * @return the messages
	 */
	public HashMap<String, String> getMessages();
	/**
	 * @param errors
	 *            the errors to set
	 */
	public void setErrors(HashMap<String, String> errors);

	/**
	 * @return the errors
	 */
	public HashMap<String, String> getErrors();

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(HashMap<String, Object> data);

	/**
	 * @return the data
	 */
	public HashMap<String, Object> getData();

	/**
	 * @param code
	 *            the http response code
	 */
	public void setHttpResponseCode(HttpStatus httpStatus);

	/**
	 * @return the http response code
	 */
	public HttpStatus getHttpResponseCode();

}
