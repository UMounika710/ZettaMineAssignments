package com.zm.bankapp.service;

import com.zm.bankapp.dto.Account;
import com.zm.bankapp.dto.Customer;
import com.zm.bankapp.dto.User;

public interface UserService<User,Customer> {
	
	boolean validateUserNameAndPassword(User user);
	int createAccountAndCust(Customer customer, User user);
	int getAccountNoByCustId(Customer customer);
	int deposit(Account account, Integer amount);
	int withdraw(Account account, Integer amount);
	//int saveTransaction(Account account, Integer amount, String txType);
	boolean transferAmount(Account sender, Account receiver, Integer amount);
}
