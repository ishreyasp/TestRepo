package com.shreyas.assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Utility {

	String driverName;
	String databaseUrl;
	String name;
	String password;

	public Utility() {

	}

	public void getConnection() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("C:\\Users\\purka\\eclipse-workspace-ee\\AuthenticationWebApp\\configuration.txt");
		Scanner sc = new Scanner(fis);
		driverName = sc.nextLine();
		databaseUrl = sc.nextLine();
		name = sc.nextLine();
		password = sc.nextLine();
		sc.close();
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDatabaseUrl() {
		return databaseUrl;
	}

	public void setDatabaseUrl(String databaseUrl) {
		this.databaseUrl = databaseUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
