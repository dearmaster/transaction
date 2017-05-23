package com.master.transaction.jdbc;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
	public void test2Transfer() {
		userService.transfer(from, to, 100);
	}
	
	@Test
	public void test1GetBalanceBeforeTransfer() {
		System.out.println("------- Before transfer -------");
		printBalance();
		System.out.println("-------------------------------");
	}

	@Test
	public void test3GetBalanceAfterTransfer() {
		System.out.println("------- After transfer -------");
		printBalance();
		System.out.println("-------------------------------");
	}

	public void printBalance() {
		Double balanceA = userService.getBalance(from);
		Double balanceB = userService.getBalance(to);
		System.out.println(from.getUsername() + " has balance of " + balanceA);
		System.out.println(to.getUsername() + " has balance of " + balanceB);
	}

}
