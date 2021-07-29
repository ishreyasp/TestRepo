package com.shreyas.assignment;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ServiceProviderFactory {
	public static ServiceProvider getObject() {
		ServiceProvider ref = null;
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\purka\\eclipse-workspace-ee\\FactoryMethod\\config.txt");
			Scanner sc = new Scanner(fis);
			String className = sc.nextLine();
			Class meta = Class.forName(className);
			ref = (ServiceProvider)meta.newInstance();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ref;
	}
}
