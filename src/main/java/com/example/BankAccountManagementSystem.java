package com.example;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Field;
import java.util.*;

public class BankAccountManagementSystem {
    public static void main(String[] args){
        int intData;  
        char charData; 
        intData=1;
        charData = "a".charAt(0);
        String str ="abc";

        BankAccountManagementSystem bams1 = new BankAccountManagementSystem();
        boolean createAC = bams1.createAccount(1, 1000.00);
        double deposit = bams1.deposit(1,20.00);
        double withdraw=bams1.withdraw(1,30.00);
        System.out.println("line 10: createAC = " + createAC);
        System.out.println("line 11: deposit = " + deposit);
        System.out.println("line 12: withdraw = " + withdraw + " Note: -1.0 =) amount <= 0, -2.0 =) amount>=balance, -3.0 amount==0 || balance==0");
        double balanceInstance = bams1.getAccountBalance(1);
        //Field field = BankAccountManagementSystem.class.getField("balance");
        //bams1.balance.getField("balance");
        //System.out.println((Object)intData).getClass().getSimpleName());
        System.out.println(intData + " is of type " + ((Object)intData).getClass().getSimpleName());  
        System.out.println(charData + " is of type " + ((Object)charData).getClass().getSimpleName());  
        System.out.println(str + " is of type " + str.getClass().getSimpleName());  



        System.out.println("line 14: balanceInstance = " + balanceInstance);
        // Field nameField = BankAccountManagementSystem.class.getField("balance");  

        BankAccountManagementSystem ft = new BankAccountManagementSystem();
		Class ftClass = ft.getClass();

		Field[] fields = ftClass.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println("declared field: " + fields[i]);
		}


    }
    private Map<Integer, Double> accounts;
    public BankAccountManagementSystem() {
        this.accounts = new HashMap<>();
    }
    public boolean createAccount(int accountNumber, double initialBalance) {
        if(accounts.containsKey(accountNumber) || initialBalance < 0 ) {
            return false;
        }
        System.out.println("line 24: intialBalance from inside createAccount method : " + initialBalance);
        accounts.put(accountNumber, initialBalance);
        return true;
    }
    public double deposit(int accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            return -1.0;
        }
        System.out.println("line 32: amount : from inside deposit method : " + amount);
        System.out.println("line 33: accounts.get(accountNumber) from inside deposit method = " + accounts.get(accountNumber));
        double balance = accounts.get(accountNumber);
        balance += amount;
        accounts.put(accountNumber, balance);
        return balance;
    }
    public double withdraw(int accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            return 0.0;
        }
        System.out.println("line 43: accounts.get(accountNumber) from inside withdraw function : " + accounts.get(accountNumber));
        System.out.println("line 44: accounts from inside withdraw function : " + accounts);
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
        System.out.println("in progress");
        System.out.println("line 60 : balance in getAccountBalance method is : " + balance);
        return balance;
    }
}
