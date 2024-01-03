package com.zm.bankapp.dao;

import java.util.List;

import com.zm.bankapp.dto.Account;
import com.zm.bankapp.dto.BankTransaction;
import com.zm.bankapp.dto.Customer;
import com.zm.bankapp.dto.User;

public interface UserDAO<T extends User,C extends Customer> {
	boolean getByUserNameAndPassword(T user);
	int saveCustomer(C customer);
	int createAccount(C customer);
	int saveUserCredentials(User user, Integer custId);
	int getCustomerIdByAadhaar(String aadhaar);
	int getAccountNoByCustomerId(Integer id);
	int deposit(Account account, Integer amount);
	int withdraw(Account account, Integer amount);
	int saveTransaction(Account account, Integer amount, String txType);
	boolean transferAmount(Account sender, Account receiver, Integer amount);
	int saveTxFlow(Integer senderTxId, Integer receiverTxId);
	boolean validateAccountNo(Account account);
	double getAmount(Account account);
	C getCustomerByAccountNumber(Integer accountNumber);
	int checkBalance(Integer accountNo);
	List<BankTransaction> getTransactionHistory(Integer accountNum);
}