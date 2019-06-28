package com.ividata.BankAccountKata.Shared;

import java.util.HashMap;

import org.springframework.http.HttpStatus;

import com.ividata.BankAccountKata.Constants.Constants;

public class JsonResponseImpl implements IJsonResponse {
	
	private boolean success = false;

	private HashMap<String, String> messages;

	private HashMap<String, String> errors;

	private HashMap<String, Object> data;

	private HttpStatus httpResponseCode;

	public JsonResponseImpl() {

		messages = new HashMap<String, String>();
		errors = new HashMap<String, String>();
		data = new HashMap<String, Object>();
	}

	/**
	 * @param success
	 *            the success to set if success is false a default message and title is added
	 */
	@Override
	public void setSuccess(boolean success) {
		this.success = success;
		if (!success) {
			messages.put(Constants.MSG_NAME_FIELD, Constants.MSG_NAME_FIELD);
			messages.put(Constants.MSG_TITLE_FIELD, Constants.MSG_TITLE_FIELD);
		}
	}

	/**
	 * @return the success
	 */
	@Override
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param messages
	 *            the messages to set
	 */
	@Override
	public void setMessages(HashMap<String, String> messages) {
		this.messages = messages;
	}

	/**
	 * @return the messages
	 */
	@Override
	public HashMap<String, String> getMessages() {
		return messages;
	}

	/**
	 * @param errors
	 *            the errors to set
	 */
	@Override
	public void setErrors(HashMap<String, String> errors) {
		this.errors = errors;
	}

	/**
	 * @return the errors
	 */
	@Override
	public HashMap<String, String> getErrors() {
		return errors;
	}

	@Override
	public HashMap<String, Object> getData() {
		return data;
	}

	@Override
	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}

	/**
	 * @param success
	 * @param title
	 *            - message title
	 * @param message
	 *            -message body
	 */
	@Override
	public void setSuccess(boolean success, String title, String message) {
		this.success = success;
		messages.put(Constants.MSG_NAME_FIELD, (message == null || message.isEmpty()) ? "" : message);
		messages.put(Constants.MSG_TITLE_FIELD, (title == null || title.isEmpty()) ? "" : title);
	}

	@Override
	public void setHttpResponseCode(HttpStatus httpStatus) {
		httpResponseCode = httpStatus;
	}

	@Override
	public HttpStatus getHttpResponseCode() {
		return httpResponseCode;
	}
}