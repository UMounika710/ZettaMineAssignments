package com.zm.bankapp.service;

import java.util.List;

import com.zm.bankapp.dto.Account;
import com.zm.bankapp.dto.BankTransaction;
import com.zm.bankapp.dto.Customer;
import com.zm.bankapp.dto.User;

public interface UserService<T extends User,C extends Customer> {
	
	boolean validateUserNameAndPassword(T user);
	int createAccountAndCust(C customer, T user);
	int getAccountNoByCustId(Integer id);
	User getUserDetailsById(Integer id);
	int getCustomerIdByAadhaar(String Aadhaar);
	int deposit(Account account, Integer amount);
	int withdraw(Account account, Integer amount);
	int saveTransaction(Account account, Integer amount, String txType);
	boolean transferAmount(Account sender, Account receiver, Integer amount);
	int saveTxFlow(Integer senderTxId, Integer receiverTxId);
	boolean validateAccountNo(Account account);
	C getCustomerDetailsByAccountNumber(Integer accountNumber);
	double getAmount(Account account);
	List<BankTransaction> getTransactionHistoryByAccountNo(Integer accountNum);
}
