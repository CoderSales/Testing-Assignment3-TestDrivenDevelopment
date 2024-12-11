package com.example;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Field;
import java.util.*;

public class BankAccountManagementSystem {
    public static void main(String[] args){
        BankAccountManagementSystem bams1 = new BankAccountManagementSystem();
        boolean createAC = bams1.createAccount(1, 1000.00, "current");
        double deposit = bams1.deposit(1,20.00);
        double withdraw=bams1.withdraw(1,30.00);


        
        double balanceInstance = bams1.getAccountBalance(1);


        
        boolean createAC2 = bams1.createAccount(2, 100.00, "current");
        boolean transfer = bams1.transfer(1,2,50.00);
        
    }
    private Map<Integer, Double> accounts;
    public BankAccountManagementSystem() {
        this.accounts = new HashMap<>();
    }
    public boolean createAccount(int accountNumber, double initialBalance, String accountType) {
    	boolean savingsType;
    	double interest;
    	if(accountType=="savings") {
    		savingsType = true;
    		interest = 0.05;
    	}
        if(accounts.containsKey(accountNumber) || initialBalance < 0 ) {
            return false;
        }
        accounts.put(accountNumber, initialBalance);
        return true;
    }
    public double deposit(int accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            return -1.0;
        }
        double balance = accounts.get(accountNumber);
        balance += amount;
        accounts.put(accountNumber, balance);
        return balance;
    }
    public double withdraw(int accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            return 0.0;
        }
        double balance = accounts.get(accountNumber);


        
        if (amount<=0) {    
            return -1.0;    
        } else  if (amount > balance) {
            return -2.0;
        } else if (amount == 0 || balance == 0){
            return -3.0;
        } else if (amount == balance) {
        	return -4.0;
        }
        balance -= amount;
        accounts.put(accountNumber, balance);
        return balance;
    }
    public double getAccountBalance(int accountNumber) {
        double balance = 0;
    	System.out.println(accounts.get(accountNumber));
        balance = accounts.get(accountNumber);
        return balance;
    }
    public boolean transfer(int accountFrom, int accountTo, double amount) {
    	if(amount>this.getAccountBalance(accountFrom)) {

    		return false;
    	}
    	double balanceFrom = this.withdraw(accountFrom, amount);
    	double balanceTo = this.deposit(accountTo, amount);

    	return true;
    }
    public boolean createSavingsAccount(int accountNumber, double amount, String accountType) {
    	if (accountType=="savings") {
    		this.createAccount(accountNumber,amount,accountType);
    		return true;
    	}
    	return false;
    }
    public boolean createCurrentAccount(int accountNumber, double amount, String accountType) {
    	if (accountType=="current") {
    		this.createAccount(accountNumber, amount, accountType);
    		return true;
    	}
    	return false;
    }
}
