package com.test.auth.util;

public enum MailType {

	FORGOT_PASSWORD("FORGOT_PASSWORD");

	private String item;

	MailType(String item) {
		this.item = item;
	}

	public String getItem() {
		return this.item;
	}
}
