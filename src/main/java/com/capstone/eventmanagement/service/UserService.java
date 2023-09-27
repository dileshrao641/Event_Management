package com.capstone.eventmanagement.service;

import org.springframework.stereotype.Repository;

import com.capstone.eventmanagement.model.TransactionDetails;


@Repository
public interface UserService {
	public int loginValidation(String emailId,String password);
	public TransactionDetails createTransaction(Double amount);
}
