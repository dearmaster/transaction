package com.master.transaction.jdbc;

public interface UserDao {
	
	void deposit(User user, double amount);
	
	void withdraw(User user, double amount);
	
	Double getBalance(User user);

}