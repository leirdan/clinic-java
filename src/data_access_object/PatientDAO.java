package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.Patient;
import utils.ConnectionFactory;

public class PatientDAO {
	Connection con = ConnectionFactory.getConnection();
	String sql = null;

	protected void index() {

	}

	public void insert(Patient p) throws SQLException {
		sql = "INSERT INTO pacientes (nome, cpf, genero, dataNasc) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, p.getName()); // first parameter
			stmt.setString(2, p.getCpf());
			stmt.setString(3, p.getGender());
			stmt.setString(4, p.getBirthday());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {
			con.close();
		}
	}

}
