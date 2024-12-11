package com.example;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Field;
import java.util.*;

public class BankAccountManagementSystem {
    public static void main(String[] args){
        BankAccountManagementSystem bams1 = new BankAccountManagementSystem();
        boolean createAC = bams1.createAccount(1, 1000.00);
        double deposit = bams1.deposit(1,20.00);
        double withdraw=bams1.withdraw(1,30.00);
        System.out.println("line 10: createAC = " + createAC);
        System.out.println("line 11: deposit = " + deposit);
        System.out.println("line 12: withdraw = " + withdraw + " Note: -1.0 =) amount <= 0, -2.0 =) amount>=balance, -3.0 amount==0 || balance==0");
        double balanceInstance = bams1.getAccountBalance(1);

        System.out.println("line 14: balanceInstance = " + balanceInstance);
        
        boolean createAC2 = bams1.createAccount(2, 100.00);
        boolean transfer = bams1.transfer(1,2,50.00);
        
    }
    private Map<Integer, Double> accounts;
    public BankAccountManagementSystem() {
        this.accounts = new HashMap<>();
    }
    public boolean createAccount(int accountNumber, double initialBalance) {
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
        } else  if (amount >= balance) {
            return -2.0;
        } else if (amount == 0 || balance == 0){
            return -3.0;
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
    		System.out.println("Insufficient funds for transfer.");
    		return false;
    	}
    	double balanceFrom = this.withdraw(accountFrom, amount);
    	double balanceTo = this.deposit(accountTo, amount);
    	System.out.println("€ " + amount + " transferred from account number: " + accountFrom + " to account number: " + accountTo);
    	return true;
    }
}
