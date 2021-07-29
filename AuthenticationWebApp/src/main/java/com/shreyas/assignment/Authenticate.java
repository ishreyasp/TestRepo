package com.shreyas.assignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/validate")
public class Authenticate extends HttpServlet {

	MainApp obj = new MainApp();
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out=res.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean validate = obj.auth(username, password);
		if(validate==true) {
			out.println("Valid User");
		}
		else {
			out.println("Invalid User");
		}
	}
}
