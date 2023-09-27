package com.capstone.eventmanagement.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import com.capstone.eventmanagement.dbutil.DBUtil;
import com.capstone.eventmanagement.model.TransactionDetails;
import com.razorpay.Order;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class UserServiceImpl implements UserService{
Connection connection;
private static final String KEY="rzp_test_hBsMngC6O0DVkY";

private static final String KEY_SECRET="3PHDKAzhgG8yZaII9H8jearS";
private static final String CURRENCY="INR";

public UserServiceImpl() throws SQLException {
	connection=DBUtil.getConnection();
}
@Override
public int loginValidation(String emailId,String password) {
	int flag=0;
	try {
		PreparedStatement statement = connection.prepareStatement("select * from users where email='"+emailId+"'");
		//statement.setString(1, emailId);
		ResultSet rs=statement.executeQuery();
		System.out.println(rs);
		while(rs.next()) {
			if(rs.getString(3).equals(emailId)&& rs.getString(5).equals(password)) {
				flag=1;
			}else {
				System.out.println("INVALID USER");
				flag=0;
			}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return flag;
}
public TransactionDetails createTransaction(Double amount) {
	try {
		JSONObject jsonobject=new JSONObject();
		jsonobject.put("amount", (amount*100));
		jsonobject.put("currency", CURRENCY);
		RazorpayClient razorpayclient=new RazorpayClient(KEY,KEY_SECRET);
		Order order =razorpayclient.orders.create(jsonobject);
		System.out.println(order);
		TransactionDetails transactiondetails= prepareTransactionDetails(order);
		return transactiondetails;
	} catch (RazorpayException e) {
		e.printStackTrace();
	}
	return null;
}

private TransactionDetails prepareTransactionDetails(Order order) {
	String orderId=order.get("id");
	String currency=order.get("currency");
	Integer amount=order.get("amount");
	TransactionDetails transactiondetails=new TransactionDetails(orderId,currency,amount,KEY);
	return transactiondetails;
}
}
