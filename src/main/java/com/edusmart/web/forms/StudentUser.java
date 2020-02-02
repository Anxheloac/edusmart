package com.edusmart.web.forms;

public class StudentUser extends User{
	private String cardNumber;
	private String cardExpiration;
	public String getCardExpiration() {
		return cardExpiration;
	}
	
	public void setCardExpiration(String cardExpiration) {
		this.cardExpiration = cardExpiration;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
}
