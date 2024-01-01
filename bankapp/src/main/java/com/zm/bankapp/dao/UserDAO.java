package com.zm.bankapp.dao;

import com.zm.bankapp.dto.Account;
import com.zm.bankapp.dto.Customer;

public interface UserDAO<User,Customer> {
	boolean getByUserNameAndPassword(User user);
	int saveCustomer(Customer customer);
	int createAccount(Customer customer);
	int saveUserCredentials(User user, Integer custId);
	int getCustomerIdByName(String name);
	int deposit(Account account, Integer amount);
	int withdraw(Account account, Integer amount);
	int saveTransaction(Account account, Integer amount, String txType);
	boolean transferAmount(Account sender, Account receiver, Integer amount);
}