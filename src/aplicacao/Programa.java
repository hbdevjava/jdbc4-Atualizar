package aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Programa {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.abrirConexao();
	
			st = conn.prepareStatement(
					"UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE "
					+ "(DepartmentId = ?)");

			st.setDouble(1, 200.0);
			st.setInt(2, 2);
			
			int linhasAfetadas = st.executeUpdate();
			
			System.out.println("linhas afetadas: " + linhasAfetadas);
		}
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			DB.fecharStatement(st);
			DB.fecharConexao();;
		}
	}
}