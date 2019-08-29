package com.capgemini.service;

import java.util.List;

import com.capgemini.bean.Account;
import com.capgemini.bean.Transaction;
import com.capgemini.exception.BSPException;

public interface IService {
	public long addAccount(Account account);

	public double showBalance(long accountNo);

	public boolean withdraw(long accountNo);

	public List<Account> showAllAccounts();

	public boolean deposit(long accountNo);

	public boolean fundTransfer(long senderAccNo, double amount, long receiverAccNo);

	public List<Transaction> showAllTransactions();

	public boolean validateName(String firstName) throws BSPException;

	public boolean validateMobile(Long mobile) throws BSPException;

	public boolean validateGender(String gender) throws BSPException;

}
