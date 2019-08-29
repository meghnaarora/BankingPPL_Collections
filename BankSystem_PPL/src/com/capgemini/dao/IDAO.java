package com.capgemini.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.bean.Account;
import com.capgemini.bean.Transaction;

public interface IDAO {
	Map<Long, Account> accountMap = new HashMap<>();
	Map<Long, Transaction> transactionMap = new HashMap<>();

	public long addToAccount(Account account);

	public double showBalance(long accountNo);

	public boolean withdraw(long accountNo, double amount);

	public List<Account> showAllAccounts();

	public boolean deposit(long accountNo, double amount);

	public boolean fundTransfer(long senderAccNo, double amount, long receiverAccNo);

	public List<Transaction> showAllTransactions();

}
