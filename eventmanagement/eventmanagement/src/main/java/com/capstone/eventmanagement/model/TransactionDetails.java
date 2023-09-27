package com.capstone.eventmanagement.model;

public class TransactionDetails {

private String OrderId;
private String currency;
private Integer amount;
private String key;
public String getKey() {
	return key;
}
public void setKey(String key) {
	this.key = key;
}
public String getOrderId() {
	return OrderId;
}
public void setOrderId(String orderId) {
	OrderId = orderId;
}
public String getCurrency() {
	return currency;
}
public void setCurrency(String currency) {
	this.currency = currency;
}
public Integer getAmount() {
	return amount;
}
public void setAmount(Integer amount) {
	this.amount = amount;
}
public TransactionDetails(String orderId, String currency, Integer amount, String key) {
	super();
	OrderId = orderId;
	this.currency = currency;
	this.amount = amount;
	this.key = key;
}

}
