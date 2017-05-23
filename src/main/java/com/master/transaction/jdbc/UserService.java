package com.master.transaction.jdbc;

public interface UserService {
	
	void transfer(User from, User to, double amount);
	
	Double getBalance(User user);

}