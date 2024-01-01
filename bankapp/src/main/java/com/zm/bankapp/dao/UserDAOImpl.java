package com.zm.bankapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.zm.bankapp.config.ConnectionFactory;
import com.zm.bankapp.dto.Account;
import com.zm.bankapp.dto.BankTransaction;
import com.zm.bankapp.dto.Customer;
import com.zm.bankapp.dto.User;

public class UserDAOImpl implements UserDAO<User, Customer> {

	public static Connection con = null;
	public static PreparedStatement pst = null;

	public UserDAOImpl() {
		try {
			con = ConnectionFactory.getDBConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean getByUserNameAndPassword(User user) {
		String query = "select * from bank_app.user where user_id = ? and password = ?";
		boolean validate = false;
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, user.getUserId().toUpperCase());
			pst.setString(2, user.getPassword().toUpperCase());
			ResultSet rs = pst.executeQuery();
			if (rs.next())
				validate = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return validate;
	}

	@Override
	public int saveCustomer(Customer customer) {
		int rows = 0;
		String query = "INSERT INTO bank_app.customer(" + "cust_name, gender, mobile, email, aadhaar_no, address, dob)"
				+ "	VALUES ( ?, ?, ?, ?, ?, ?, ?);";
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, customer.getCustName().toUpperCase());
			pst.setString(2, customer.getGender().toUpperCase());
			pst.setString(3, customer.getMobile());
			pst.setString(4, customer.getEmail().toUpperCase());
			pst.setString(5, customer.getAadhaarNo());
			pst.setString(6, customer.getAddress().toUpperCase());
			pst.setDate(7, Date.valueOf(customer.getDob()));

			rows = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int saveUserCredentials(User user, Integer custId) {
		int rows = 0;
		String query = "INSERT INTO bank_app.user(" + "user_id, password, user_type, cust_id)"
				+ "	VALUES ( ?, ?, ?, ?)";
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, user.getUserId().toUpperCase());
			pst.setString(2, user.getPassword().toUpperCase());
			pst.setString(3, "CUSTOMER");
			pst.setInt(4, custId);
			rows = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int getCustomerIdByName(String name) {
		int id = 0;
		String query = "select cust_id from customer where cust_name=?";
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, name.toUpperCase());
			ResultSet rs = pst.executeQuery();
			if (rs.next())
				id = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public int createAccount(Customer customer) {
		int rows = 0;
		String query = "INSERT INTO account(" + " created_on,balance, cust_id)" + "	VALUES ( ?, ?, ?)";
		try {
			pst = con.prepareStatement(query);
			pst.setDate(1, Date.valueOf(LocalDate.now()));
			pst.setInt(2, 0);
			pst.setInt(3, customer.getCustId());
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int deposit(Account account, Integer amount) {
		int rows = 0;
		String sql = "update bank_app.account set balance = balance + " + amount + " where account_no = "
				+ account.getAccountNo();
		String select = "select * from bank_app.account where account_no = " + account.getAccountNo();
		try {
			pst = con.prepareStatement(sql);
			rows = pst.executeUpdate();
			if (rows != 0) {
				pst = con.prepareStatement(select);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					account.setBalance(rs.getDouble(3));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rows != 0) {
			int txRows = saveTransaction(account, amount, "CREDIT");
		}
		return rows;
	}

	@Override
	public int withdraw(Account account, Integer amount) {
		int rows = 0;
		String sql = "update bank_app.account set balance = balance - " + amount + " where account_no = "
				+ account.getAccountNo();
		String select = "select * from bank_app.account where account_no = " + account.getAccountNo();
		try {
			pst = con.prepareStatement(sql);
			rows = pst.executeUpdate();
			if (rows != 0) {
				pst = con.prepareStatement(select);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					account.setBalance(rs.getDouble(3));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rows != 0) {
			int txRows = saveTransaction(account, amount, "DEBIT");
		}

		return rows;
	}

	@Override
	public boolean transferAmount(Account sender, Account receiver, Integer amount) {
		int senderRow = 0;
		int receiverRow = 0;
		senderRow = withdraw(sender, amount);
		if (senderRow != 0) {
			receiverRow = deposit(receiver, amount);
		}
		return (senderRow == receiverRow);
	}

	@Override
	public int saveTransaction(Account account, Integer amount, String txType) {

		BankTransaction tx = new BankTransaction();
		int txRows = 0;
		String sql = "INSERT INTO bank_app.bank_tx(tx_date, tx_type, amount, account_no, admin_id) "
				+ "VALUES (?, ?, ?, ?, ?)";

		try {
			con.setAutoCommit(false);
			pst = con.prepareStatement(sql);
			pst.setDate(1, Date.valueOf(LocalDate.now()));
			pst.setString(2, txType);
			pst.setInt(3, amount);
			pst.setInt(4, account.getAccountNo());
			pst.setInt(5, 1);
			txRows = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return txRows;
	}

}