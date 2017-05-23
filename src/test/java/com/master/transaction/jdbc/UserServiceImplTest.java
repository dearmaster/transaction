package com.master.transaction.jdbc;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class UserServiceImplTest {
	
	@Autowired
	private UserService userService;
	
	private static User from;
	private static User to;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		from = new User("张三");
		to = new User("李四");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTransfer() {
		userService.transfer(from, to, 100);
	}
	
	@Test
	public void testGetBalance() {
		Double balanceA = userService.getBalance(from);
		Double balanceB = userService.getBalance(to);
		System.out.println(balanceA);
		System.out.println(balanceB);
	}

}
