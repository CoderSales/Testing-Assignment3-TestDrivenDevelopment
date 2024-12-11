package com.example;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.mockito.Mockito.*;

class TestSetup {
	// Map<Integer, Double> mockedList = mock(Map.class);

	//BankAccountManagementSystem bankAccountManagmentSystem = new BankAccountManagementSystem();
	@Test
	void test() {
		BankAccountManagementSystem bankAccountManagementSystem = new BankAccountManagementSystem();
		boolean expected = true;
		boolean actual = bankAccountManagementSystem.createAccount(1, 20.00);
		assertEquals(expected, actual);
	}
	
	@Test
	void test2() {
		BankAccountManagementSystem bankAccountManagementSystem2 = new BankAccountManagementSystem();
		double expected2 = -1.0;
		double actual2 = bankAccountManagementSystem2.deposit(1, 20.00);
		assertEquals(expected2, actual2);
	}
	
	@Test
	void test3() {
		BankAccountManagementSystem bankAccountManagementSystem3 = new BankAccountManagementSystem();
		double expected3 = 0.0;
		double actual3 = bankAccountManagementSystem3.withdraw(1, 1.00);
		assertEquals(expected3, actual3);
	}
	
	@Test
	void test4() {
		BankAccountManagementSystem bankAccountManagementSystem4 = new BankAccountManagementSystem();
		bankAccountManagementSystem4.createAccount(1, 1000.00);
		bankAccountManagementSystem4.deposit(1,20.00);
		bankAccountManagementSystem4.withdraw(1,30.00);
		double expected4 = 990.0;
		System.out.println(bankAccountManagementSystem4.getAccountBalance(1));
		double actual4 = bankAccountManagementSystem4.getAccountBalance(1);
		assertEquals(expected4, actual4);
	}
	
}