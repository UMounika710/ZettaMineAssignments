package com.zm.bankapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		double closingBalance = 0;
		String sql = "update bank_app.account set balance = balance + " + amount + " where account_no = "
				+ account.getAccountNo();

		try {
			pst = con.prepareStatement(sql);
			rows = pst.executeUpdate();
			if (rows != 0) {
				closingBalance = getAmount(account);
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
		try {
			double balance = getAmount(account);
			if (balance > amount) {
				pst = con.prepareStatement(sql);
				rows = pst.executeUpdate();
				if (rows != 0) {
					getAmount(account);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (rows != 0) {
			int txId = saveTransaction(account, amount, "DEBIT");

		}

		return rows;
	}

	@Override
	public boolean transferAmount(Account sender, Account receiver, Integer amount) {
		int senderRow = 0;
		int receiverRow = 0;
		try {
			con.setAutoCommit(false);
			System.out.println(sender.getAccountNo());
			System.out.println(receiver.getAccountNo());
			String updateSender = "update bank_app.account set balance = balance - ? where account_no =  ?";
			double balance = getAmount(sender);
			if (balance > amount) {
				pst = con.prepareStatement(updateSender);
				pst.setInt(1, amount);
				pst.setInt(2, sender.getAccountNo());
				senderRow = pst.executeUpdate();
			}
			String updateReceiver = "update bank_app.account set balance = balance + ? where account_no =  ?";
			pst = con.prepareStatement(updateReceiver);
			pst.setInt(1, amount);
			pst.setInt(2, receiver.getAccountNo());
			receiverRow = pst.executeUpdate();
			if ((senderRow > 0) && (receiverRow > 0)) {
				getAmount(sender);
				getAmount(receiver);
				con.commit();
				con.setAutoCommit(true);
				int senderTxId = saveTransaction(sender, amount, "DEBIT");
				int receiverTxId = saveTransaction(receiver, amount, "CREDIT");

				int txFlow = saveTxFlow(senderTxId, receiverTxId);

				return true;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public int saveTransaction(Account account, Integer amount, String txType) {

		BankTransaction tx = new BankTransaction();
		int txRows = 0;
		int txId = 0;
		String sql = "INSERT INTO bank_app.bank_tx(tx_date, tx_type, amount, account_no, closing_bal, admin_id) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		try {
			pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setDate(1, Date.valueOf(LocalDate.now()));
			pst.setString(2, txType);
			pst.setInt(3, amount);
			pst.setInt(4, account.getAccountNo());
			pst.setDouble(5, account.getBalance());
			pst.setInt(6, 1);
			txRows = pst.executeUpdate();
			if (txRows > 0) {
				ResultSet generatedKeys = pst.getGeneratedKeys();
				if (generatedKeys.next()) {
					txId = generatedKeys.getInt(1);
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return txId;
	}

	@Override
	public int saveTxFlow(Integer senderTxId, Integer receiverTxId) {
		String txFlow = "INSERT INTO bank_app.tx_flow(sender_tx, recipient_tx) VALUES (?,?)";
		int rows = 0;
		try {
			pst = con.prepareStatement(txFlow);
			pst.setInt(1, senderTxId);
			pst.setInt(2, receiverTxId);
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public boolean validateAccountNo(Account account) {
		// int rows = 0;
		String sql = "select account_no from bank_app.account where account_no = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, account.getAccountNo());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.err.println("Account Number is not Existed");
		}
		return false;

	}

	@Override
	public double getAmount(Account account) {
		double balance = 0;
		String select = "select balance from bank_app.account where account_no = " + account.getAccountNo();
		try {
			pst = con.prepareStatement(select);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				account.setBalance(rs.getDouble(1));
			}
			balance = account.getBalance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return balance;

	}

}