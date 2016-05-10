package com.test.util.mail;

public enum MailTemplate {

	FORGOT_PASSWORD("velocity/mailForgotPassword.vm");

	private final String value;

	MailTemplate(String value){ 
		this.value = value; 
	}

	public String getValue() {
		return value;
	}

}
