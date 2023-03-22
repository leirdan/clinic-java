package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionFactory {
	
	private static final String url = "jdbc:mysql://localhost/consultorio";
	private static final String user = "leirdan";
	private static final String passwd = "passwd123";
	
	public static final Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, passwd);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao conectar: " + e.getMessage());
		}
		return con;
	}
}
