package com.zm.bankapp.service;

import com.zm.bankapp.dao.UserDAO;
import com.zm.bankapp.dao.UserDAOImpl;
import com.zm.bankapp.dto.Account;
import com.zm.bankapp.dto.Customer;
import com.zm.bankapp.dto.User;

public class UserServiceImpl implements UserService<User, Customer> {

	public static UserDAO dao = null;

	public UserServiceImpl() {
		dao = new UserDAOImpl();
	}

	@Override
	public boolean validateUserNameAndPassword(User user) {
		return dao.getByUserNameAndPassword(user);
	}

	@Override
	public int createAccountAndCust(Customer customer, User user) {
		int row1 = dao.saveCustomer(customer);
		int custId = dao.getCustomerIdByName(customer.getCustName());
		customer.setCustId(custId);
		int row2 = dao.createAccount(customer);
		int row3 = dao.saveUserCredentials(user, customer.getCustId());
		return row1 + row2;
	}

	@Override
	public int getAccountNoByCustId(Customer customer) {
		return dao.getCustomerIdByName(customer.getCustName());
	}

	@Override
	public int deposit(Account account, Integer amount) {
		return dao.deposit(account, amount);
	}

	@Override
	public int withdraw(Account account, Integer amount) {
		return dao.withdraw(account, amount);
	}

	@Override
	public int saveTransaction(Account account, Integer amount, String txType) {
		return dao.saveTransaction(account, amount, txType);
	}

	@Override
	public boolean transferAmount(Account sender, Account receiver, Integer amount) {
		return dao.transferAmount(sender, receiver, amount);
	}

	@Override
	public int saveTxFlow(Integer senderTxId, Integer receiverTxId) {
		return dao.saveTxFlow(senderTxId, receiverTxId);
	}

	@Override
	public boolean validateAccountNo(Account account) {
		return dao.validateAccountNo(account);
		
	}

}
