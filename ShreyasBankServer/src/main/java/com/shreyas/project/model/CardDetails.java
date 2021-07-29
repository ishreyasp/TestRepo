package com.shreyas.project.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

/**@Author Shreyas Purkar */

@Entity
@Table(name = "carddetails")
@SecondaryTable(name = "cardtype", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
public class CardDetails {

	@Id
	@Column(name = "id")
	int id;
	@Column(name = "cardnumber")
	BigInteger cardNumber;
	@Column(name = "cardname")
	String cardHolderName;
	@Column(name = "cvv")
	int cvv;
	@Column(name = "expirydate")
	String expiryDate;
	@Column(name = "amountlimit")
	double amountLimit;
	@Column(name = "cardtype", table = "cardtype")
	String cardType;

	public CardDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CardDetails(int id, BigInteger cardNumber, String cardType, String cardHolderName, int cvv,
			double amountLimit, String expiryDate) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.cardHolderName = cardHolderName;
		this.cvv = cvv;
		this.amountLimit = amountLimit;
		this.expiryDate = expiryDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigInteger getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(BigInteger cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public double getAmountLimit() {
		return amountLimit;
	}

	public void setAmountLimit(double amountLimit) {
		this.amountLimit = amountLimit;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
}
