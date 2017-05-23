package com.master.transaction.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

public class UserDaoImpl extends AbstractJdbcDaoSupport implements UserDao {
	
	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);
	
	private static final String USER_BALANCE_DEPOSIT_SQL = "update user_balance_tbl set balance = balance + ? where username = ?";
	private static final String USER_BALANCE_WITHDRAW_SQL = "update user_balance_tbl set balance = balance - ? where username = ?";
	private static final String USER_BALANCE_QUERY_SQL = "select * from user_balance_tbl where username = ?";
	
	@Override
	public void deposit(User user, double amount) {
		this.getJdbcTemplate().update(USER_BALANCE_DEPOSIT_SQL, new Object[]{amount, user.getUsername()});
		logger.info("Operation SUCCESS: " + user.getUsername() + " deposit " + amount);
	}

	@Override
	public void withdraw(User user, double amount) {
		this.getJdbcTemplate().update(USER_BALANCE_WITHDRAW_SQL, new Object[]{(Double) amount, user.getUsername()});
		logger.info("Operation SUCCESS: " + user.getUsername() + " withdraw " + amount);
	}

	@Override
	public Double getBalance(User user) {
		
		Double balance = this.getJdbcTemplate().queryForObject(USER_BALANCE_QUERY_SQL, new Object[]{user.getUsername()}, new RowMapper<Double>() {

			@Override
			public Double mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getDouble("balance");
			}
			
		});
		
		return balance;
	}

}
