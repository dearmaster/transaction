package com.master.transaction.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
//@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Transactional(propagation = Propagation.NEVER)
	//@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	@Override
	public void transfer(User userFrom, User userTo, double amount) {
		withdraw(userFrom, amount);
		deposit(userTo, amount);
	}
	
	private void withdraw(User user, double amount) {
		userDao.withdraw(user, amount);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = {Exception.class})
//	@Transactional(propagation = Propagation.REQUIRES_NEW, noRollbackFor = {Exception.class})
	//@Transactional(propagation = Propagation.NOT_SUPPORTED)
	private void deposit(User user, double amount) {
		userDao.deposit(user, amount);
		System.out.println(1/0);
	}

	@Override
	public Double getBalance(User user) {
		return userDao.getBalance(user);
	}

}