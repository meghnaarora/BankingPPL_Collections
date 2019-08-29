package com.capgemini.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.capgemini.bean.Account;
import com.capgemini.bean.Transaction;

public class DAOImpl implements IDAO {
	Scanner scanner = new Scanner(System.in);

	public List<Account> accountMapToList(Map<Long, Account> accountmap) {
		Collection<Account> collection = accountmap.values();
		List<Account> list = new ArrayList<Account>();
		list.addAll(collection);
		return list;
	}

	public List<Transaction> transactionMapToList(Map<Long, Transaction> transactionmap) {
		Collection<Transaction> collection = transactionmap.values();
		List<Transaction> list = new ArrayList<Transaction>();
		list.addAll(collection);
		return list;
	}

	public long addToAccount(Account account) {
		accountMap.put(account.getAccountNo(), account);
		return account.getAccountNo();
	}

	@Override
	public double showBalance(long accountNo) {
		List<Account> list = accountMapToList(accountMap);

		Iterator<Account> iterator = list.iterator();
		while (iterator.hasNext()) {
			Account a = iterator.next();
			if (a.getAccountNo() == accountNo) {
				return a.getBalance();
			}
		}
		return 0;
	}

	@Override
	public boolean withdraw(long accountNo, double amount) {
		boolean status = false;
		if (accountMap.get(accountNo).getBalance() > amount && amount != 0) {
			double updatedBalance = (accountMap.get(accountNo).getBalance()) - amount;
			accountMap.get(accountNo).setBalance(updatedBalance);
			status = true;
		}
		if (status == true) {
			Date date = Calendar.getInstance().getTime();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String strDate = dateFormat.format(date);

			Transaction transaction = new Transaction(0, "debit", strDate, accountNo, amount);
			long transactionId = (long) (Math.random() * 1000000L);
			transaction.setTransactionId(transactionId);
			transactionMap.put(transactionId, transaction);

			System.out.println("Transaction successful. TransactionId:\t" + transactionId);
		}
		return status;
	}

	@Override
	public boolean deposit(long accountNo, double amount) {
		boolean status = false;
		if (amount != 0) {
			double updatedBalance = (accountMap.get(accountNo).getBalance()) + amount;
			accountMap.get(accountNo).setBalance(updatedBalance);
			status = true;
		}
		if (status == true) {
			Date date = Calendar.getInstance().getTime();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String strDate = dateFormat.format(date);

			Transaction transaction = new Transaction(0, "credit", strDate, accountNo, amount);
			long transactionId = (long) (Math.random() * 1000000L);
			transaction.setTransactionId(transactionId);
			transactionMap.put(transactionId, transaction);

			System.out.println("Transaction successful. TransactionId:\t" + transactionId);
		}
		return status;
	}

	@Override
	public List<Account> showAllAccounts() {
		return accountMapToList(accountMap);
	}

	@Override
	public boolean fundTransfer(long senderAccNo, double amount, long receiverAccNo) {
		boolean status = false;

		if (withdraw(senderAccNo, amount)) {
			status = deposit(receiverAccNo, amount);
		}

		return status;
	}

	@Override
	public List<Transaction> showAllTransactions() {
		return transactionMapToList(transactionMap);
	}
}
