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


	
	@Test
	void test() {
		BankAccountManagementSystem bankAccountManagementSystem = new BankAccountManagementSystem();
		boolean expected = true;
		boolean actual = bankAccountManagementSystem.createAccount(1, 20.00, "current");
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
		bankAccountManagementSystem4.createAccount(1, 1000.00, "current");
		bankAccountManagementSystem4.deposit(1,20.00);
		bankAccountManagementSystem4.withdraw(1,30.00);
		double expected4 = 990.0;

		double actual4 = bankAccountManagementSystem4.getAccountBalance(1);
		assertEquals(expected4, actual4);
	}
	@Test
	void TestTransfer() {
		BankAccountManagementSystem bankAccountManagementSystemTestTransfer = new BankAccountManagementSystem();
		bankAccountManagementSystemTestTransfer.createAccount(1, 1000.00, "current");
		bankAccountManagementSystemTestTransfer.deposit(1,20.00);
		bankAccountManagementSystemTestTransfer.withdraw(1,30.00);

		boolean createAC2 = bankAccountManagementSystemTestTransfer.createAccount(2, 100.00, "current");


		int accountFrom = 1;
		int accountTo = 2;
		double amount = 50.00;
		boolean actualTestTransfer = bankAccountManagementSystemTestTransfer.transfer(accountFrom, accountTo, amount);
		boolean expectedTestTransfer = true;
		assertEquals(expectedTestTransfer, actualTestTransfer);
	}
	
	@Test
	void SavingsAccountCreationTest() {
		BankAccountManagementSystem bankAccountManagementSystemSavingsAccountCreationTest = new BankAccountManagementSystem();
		boolean savingsAccountCreatedActual = bankAccountManagementSystemSavingsAccountCreationTest.createSavingsAccount(4, 300.00, "savings");
		boolean savingsAccountCreatedExpected = true;
		assertEquals(savingsAccountCreatedExpected, savingsAccountCreatedActual);
	}
	
	@Test
	void CurrentAccountCreationTest() {
		BankAccountManagementSystem bankAccountManagementSystemCurrentAccountCreationTest = new BankAccountManagementSystem();
		boolean currentAccountCreatedActual = bankAccountManagementSystemCurrentAccountCreationTest.createCurrentAccount(5, 200.00, "current");
		boolean currentAccountCreatedExpected = true;
		assertEquals(currentAccountCreatedExpected,currentAccountCreatedActual);
	}
	
	@Test
	void withdrawTest2() {
		BankAccountManagementSystem bankAccountManagementSystemDefinitionCoverage1 = new BankAccountManagementSystem();
		
		bankAccountManagementSystemDefinitionCoverage1.createAccount(1, 1000.00, "current");
		bankAccountManagementSystemDefinitionCoverage1.deposit(1,20.00);
		bankAccountManagementSystemDefinitionCoverage1.withdraw(1,30.00);

		
		double bankAccountManagementCover1Actual = bankAccountManagementSystemDefinitionCoverage1.withdraw(1,5000.00);
		double bankAccountManagementCover1Expected = -2.0;
		assertEquals(bankAccountManagementCover1Expected, bankAccountManagementCover1Actual);
	}
	
	@Test
	void withdrawTest3() {
		BankAccountManagementSystem bankAccountManagementSystemDefinitionCoverage2 = new BankAccountManagementSystem();
		
		bankAccountManagementSystemDefinitionCoverage2.createAccount(1, 1000.00, "current");
		bankAccountManagementSystemDefinitionCoverage2.deposit(1,20.00);
		bankAccountManagementSystemDefinitionCoverage2.withdraw(1,30.00);

		
		double bankAccountManagementCover2Actual = bankAccountManagementSystemDefinitionCoverage2.withdraw(2,5000.00);
		double bankAccountManagementCover2Expected = 0.0;
		assertEquals(bankAccountManagementCover2Expected, bankAccountManagementCover2Actual);
	}
	
	@Test
	void withdrawTest4() {
		BankAccountManagementSystem bankAccountManagementSystemDefinitionCoverage3 = new BankAccountManagementSystem();
		
		bankAccountManagementSystemDefinitionCoverage3.createAccount(1, 1000.00, "current");



		
		double bankAccountManagementCover3Actual = bankAccountManagementSystemDefinitionCoverage3.withdraw(1,1000.00);
		double bankAccountManagementCover3Expected = -4.0;
		assertEquals(bankAccountManagementCover3Expected, bankAccountManagementCover3Actual);
	}
	
	@Test
	void depositDUTest1() {
		BankAccountManagementSystem bankAccountManagementSystemDepositDUTest1 = new BankAccountManagementSystem();
		bankAccountManagementSystemDepositDUTest1.createAccount(1, 0.0, "current");
		double expectedDepositDUTest1 = -1.0;
		double actualDepositDUTest1 = bankAccountManagementSystemDepositDUTest1.deposit(-1, 20.00);
		assertEquals(expectedDepositDUTest1, actualDepositDUTest1);
	}
	
	@Test
	void depositDUTest2() {
		BankAccountManagementSystem bankAccountManagementSystemDepositDUTest2 = new BankAccountManagementSystem();
		bankAccountManagementSystemDepositDUTest2.createAccount(1, 0.00, "current");
		double expectedDepositDUTest2 = -1.0;
		double actualDepositDUTest2 = bankAccountManagementSystemDepositDUTest2.deposit(0, -20.00);
		assertEquals(expectedDepositDUTest2, actualDepositDUTest2);
	}
	
	@Test
	void depositDUTest3() {
		BankAccountManagementSystem bankAccountManagementSystemDepositDUTest3 = new BankAccountManagementSystem();
		bankAccountManagementSystemDepositDUTest3.createAccount(1, 0.00, "current");
		double expectedDepositDUTest3 = 0.50;
		double actualDepositDUTest3 = bankAccountManagementSystemDepositDUTest3.deposit(1, 0.50);
		assertEquals(expectedDepositDUTest3, actualDepositDUTest3);
	}
	
	@Test
	void withdrawOverdraftTest1() {
		BankAccountManagementSystem bankAccountManagementSystemWithdrawOverdraftTest1 = new BankAccountManagementSystem();
		bankAccountManagementSystemWithdrawOverdraftTest1.createAccount(1, 0.00, "current");
		double expectedWithdrawOverdraftTest1 = -2.0;
		double actualWithdrawOverdraftTest1 = bankAccountManagementSystemWithdrawOverdraftTest1.withdraw(1, 10.00);
		assertEquals(expectedWithdrawOverdraftTest1, actualWithdrawOverdraftTest1);
	}

}
