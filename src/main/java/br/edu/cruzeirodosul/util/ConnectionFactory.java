package br.edu.cruzeirodosul.util;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static void main(String[] args) {
		new ConnectionFactory().getConnection();
	}
	public void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", "INTERNET","123456");
			System.out.println("Conectou!");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}