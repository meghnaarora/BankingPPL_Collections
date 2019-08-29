package com.capgemini.utility;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.bean.Account;
import com.capgemini.exception.BSPException;
import com.capgemini.service.IService;
import com.capgemini.service.ServiceImpl;

public class MainUI {
	public static void main(String[] args) {
		IService service = new ServiceImpl();
		long accountNo;
		String toContinue;

		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Select Option:\n" + "0.Exit\n" + "1.Create Account\n" + "2.Withdraw\n" + "3.Deposit\n"
					+ "4.Fund Transfer\n" + "5.Show Balance\n" + "6.Print Transactions\n" + "\n"
					+ "11. Show all accounts");

			int input = scanner.nextInt();
			switch (input) {
			case 0:
				System.exit(0);
			case 1:
				String firstName = "", lastName = "", gender = "";
				long mobileNo = 0;
				boolean fnameFlag = false, lnameFlag = false, mobileFlag = false, genderFlag = false;

				System.out.print("Enter FirstName:\t");
				do {
					scanner = new Scanner(System.in);
					firstName = scanner.nextLine();
					try {
						service.validateName(firstName);
						fnameFlag = true;
					} catch (InputMismatchException e) {
						System.err.println("Enter charachters only");
					} catch (BSPException e) {
						fnameFlag = false;
						System.err.println(e.getMessage());
					}
				} while (!fnameFlag);

				System.out.print("Enter LastName:\t");
				do {
					scanner = new Scanner(System.in);
					lastName = scanner.nextLine();
					try {
						service.validateName(lastName);
						lnameFlag = true;
					} catch (InputMismatchException e) {
						System.err.println("Enter charachters only");
					} catch (BSPException e) {
						lnameFlag = false;
						System.err.println(e.getMessage());
					}
				} while (lnameFlag != true);

				System.out.print("Enter Mobile No:\t");
				do {
					scanner = new Scanner(System.in);
					mobileNo = scanner.nextLong();
					try {
						service.validateMobile(mobileNo);
						mobileFlag = true;
					} catch (InputMismatchException e) {
						System.err.println("Enter numerics only");
					} catch (BSPException e) {
						mobileFlag = false;
						System.err.println(e.getMessage());
					}
				} while (mobileFlag != true);

				System.out.print("Enter Gender:\t");
				do {
					scanner = new Scanner(System.in);
					gender = scanner.next();
					try {
						service.validateGender(gender);
						genderFlag = true;
					}catch(InputMismatchException e) {
						System.err.println("Enter charachter only");
					} catch (BSPException e) {
						genderFlag = false;
						System.err.println(e.getMessage());
					}
				} while (genderFlag != true);

				Account a = new Account(0, firstName, lastName, mobileNo, gender, 0);
				accountNo = service.addAccount(a);
				System.out.print("Account created. AccountNo:\t" + accountNo);
				break;

			case 2:
				System.out.print("Enter accountNo to withdraw amount\t");
				accountNo = scanner.nextLong();
				System.out.print("Amount withdrawn:\t" + service.withdraw(accountNo) + "\nNew balance\t"
						+ service.showBalance(accountNo));
				break;
			case 3:
				System.out.print("Enter accountNo to deposit amount\t");
				accountNo = scanner.nextLong();
				System.out.print("Amount deposited: " + service.deposit(accountNo) + "\nNew balance\t"
						+ service.showBalance(accountNo));
				break;
			case 4:
				System.out.print("Enter sender's accountNo:\t");
				long senderAccNo = scanner.nextLong();
				System.out.print("Enter amount to be sent:\t");
				double amount = scanner.nextDouble();
				System.out.print("Enter receiver's accountNo:\t");
				long receiverAccNo = scanner.nextLong();

				System.out.print("Fund Transfered:\t" + service.fundTransfer(senderAccNo, amount, receiverAccNo));
				break;
			case 5:
				System.out.print("Enter accountno to view balance:\t");
				accountNo = scanner.nextLong();
				System.out.print("Balance=" + service.showBalance(accountNo));
				break;
			case 6:
				System.out.println("View All Transactions:");
				System.out.println(service.showAllTransactions());
				break;
			case 11:
				System.out.println(service.showAllAccounts());
				break;
			default:
				System.out.println("Enter valid Input");
			}
			System.out.println("\nDo you want to continue? y/n");
			toContinue = scanner.next();
		} while (toContinue.equalsIgnoreCase("y") || toContinue.equalsIgnoreCase("yes"));
		scanner.close();
	}
}
