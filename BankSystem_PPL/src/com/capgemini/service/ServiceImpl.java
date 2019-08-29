package com.capgemini.service;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.capgemini.bean.Account;
import com.capgemini.bean.Transaction;
import com.capgemini.dao.DAOImpl;
import com.capgemini.dao.IDAO;
import com.capgemini.exception.BSPException;

public class ServiceImpl implements IService {

	IDAO dao = new DAOImpl();
	Scanner scanner = new Scanner(System.in);

	public long addAccount(Account account) {

		long accountNo = (long) (Math.random() * 10000000000L);
		account.setAccountNo(accountNo);
		return dao.addToAccount(account);
	}

	@Override
	public double showBalance(long accountNo) {
		return dao.showBalance(accountNo);
	}

	@Override
	public boolean withdraw(long accountNo) {
		boolean status = false;
		// check if accountNo exist in dao

		if (accountNo != 0) {
			System.out.print("Enter amount to be withdrawn:\t");
			double amount = scanner.nextDouble();
			if (dao.withdraw(accountNo, amount))
				status = true;
		}
		return status;
	}

	@Override
	public boolean deposit(long accountNo) {
		boolean status = false;
		// check if accountNo exist in dao

		if (accountNo != 0) {
			System.out.print("Enter amount to be deposit:\t");
			double amount = scanner.nextDouble();
			if (dao.deposit(accountNo, amount))
				status = true;
		}
		return status;
	}

	@Override
	public List<Account> showAllAccounts() {
		return dao.showAllAccounts();
	}

	@Override
	public boolean fundTransfer(long senderAccNo, double amount, long receiverAccNo) {
		return dao.fundTransfer(senderAccNo, amount, receiverAccNo);
	}

	@Override
	public List<Transaction> showAllTransactions() {
		return dao.showAllTransactions();
	}

	@Override
	public boolean validateName(String vehicleName) throws BSPException {
		/*String ptn = "[A-Z]{1}[a-zA-Z] {1,}";
		boolean status = false;
		if (!Pattern.matches(ptn, firstName))
			throw new BSPException();
		else
			status = true;
		return status;*/
		
		boolean resultFlag = false;
		String nameRegEx = "[A-Z]{1}[a-zA-Z ]{1,}";

		if (!Pattern.matches(nameRegEx, vehicleName)) {
			throw new BSPException("first letter should be capital and min length 2");
		} else {
			resultFlag = true;
		}
		return resultFlag;
	}

	@Override
	public boolean validateMobile(Long mobile) throws BSPException {
		String sMobile=Long.toString(mobile);
		boolean resultFlag = false;
		String nameRegEx = "^[0-9 ]{10}$";

		if (!Pattern.matches(nameRegEx, sMobile)) {
			throw new BSPException("Enter 10 digits");
		} else {
			resultFlag = true;
		}
		return resultFlag;
	}

	@Override
	public boolean validateGender(String gender) throws BSPException {
		boolean status=false;
		if(gender.equalsIgnoreCase("m") ||gender.equalsIgnoreCase("f")) {
			status=true;
		}
		else {
			throw new BSPException("Enter m/f");
		}

		return status;
	}

}
