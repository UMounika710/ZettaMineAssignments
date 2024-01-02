package com.zm.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.logging.Logger;

import com.zm.bankapp.dto.Account;
import com.zm.bankapp.dto.Customer;
import com.zm.bankapp.dto.User;
import com.zm.bankapp.service.UserService;
import com.zm.bankapp.service.UserServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
	//private static final Logger logger = Logger.getLogger(AdminController.class.getName());
	private static UserService<User, Customer> service = new UserServiceImpl();
	private static String action = null;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward="";
		action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		if (action.equalsIgnoreCase("create")) {
			String name = request.getParameter("name");
			LocalDate dob = LocalDate.parse(request.getParameter("dob"));
			String gender = request.getParameter("gender");
			String mobile = request.getParameter("mobile");
			String email = request.getParameter("email");
			String aadhaar = request.getParameter("aadhaar");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String address = request.getParameter("address");

			Customer customer = new Customer(name, dob, gender, mobile, email, aadhaar, address);
			User user = new User(username, password);
			int rowsInserted = service.createAccountAndCust(customer, user);
			if (rowsInserted != 0) {
				response.setContentType("text/html");
				out.print("<h2>Account is created for Mr./Mrs. " + name + "</h2>");
				out.print("<h2>Account Number is " + service.getAccountNoByCustId(customer) + "</h2>");
			}
		}

		if (action.equalsIgnoreCase("deposit")) {
			String accountNo = request.getParameter("accountNumber");
			String amount = request.getParameter("depositAmount");
			Account account = new Account();
			account.setAccountNo(Integer.parseInt(accountNo));
			int rows = service.deposit(account, Integer.parseInt(amount));
			String balance = account.getBalance().toString();
			//request.setAttribute(balance, balance);
			if (rows != 0) {
				response.setContentType("text/html");
				out.print("<h2>Account Number: " + accountNo + "</h2>");
				out.print("<h2>Amount credited: " + amount + "</h2>");
				out.print("<h2>Balance Amount: " + balance + "</h2>");
				out.print("<button type=submit>Done</button>");
				forward = "admin-dashboard.jsp";
				//request.getRequestDispatcher(forward).forward(request, response);
				
			}

		}

		if (action.equalsIgnoreCase("withdraw")) {
			String accountNo = request.getParameter("accountNumber");
			String amount = request.getParameter("withdrawAmount");
			Account account = new Account();
			account.setAccountNo(Integer.parseInt(accountNo));
			int rows = service.withdraw(account, Integer.parseInt(amount));
			String balance = account.getBalance().toString();
			if (rows != 0) {
				response.setContentType("text/html");
				out.print("<h2>Account Number: " + accountNo + "</h2>");
				out.print("<h2>Amount debited: " + amount + "</h2>");
				out.print("<h2>Balance Amount: " + balance + "</h2>");
				out.print("<button type=submit>Done</button>");
				forward = "admin-dashboard.jsp";
				//request.getRequestDispatcher(forward).forward(request, response);
				
			}

		}
		
		if (action.equalsIgnoreCase("transfer")) {
			String senderAccountNo = request.getParameter("senderAccountNo");
			String receiverAccountNo = request.getParameter("receiverAccountNo");
			String amount = request.getParameter("transferAmount");
			Account sender = new Account();
			sender.setAccountNo(Integer.parseInt(senderAccountNo));
			System.out.println(sender.getAccountNo()); 
			Account receiver = new Account();
			receiver.setAccountNo(Integer.parseInt(receiverAccountNo));
			System.out.println(receiver.getAccountNo()); 
			boolean transfer = service.transferAmount(sender, receiver, Integer.parseInt(amount));
			if(transfer) {
				response.setContentType("text/html");
				out.print("<h2>Sender Account Number: " + senderAccountNo + "</h2>");
				out.print("<h2>Receiver Account Number: " + receiverAccountNo + "</h2>");
				out.print("<h2>Amount debited: " + amount + "</h2>");
				
				RequestDispatcher rd = request.getRequestDispatcher("transfer.jsp");
				rd.include(request, response);
				
			}
		}
	}
}