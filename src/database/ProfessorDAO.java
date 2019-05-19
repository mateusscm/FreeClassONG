package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.Professor;
import util.DateUtil;
import util.IndexFactory;

public class ProfessorDAO {

	public static void save(Professor professor) throws SQLException {
		Connection connection = null;
		try {
			PreparedStatement statement;
			connection = DBManager.getConnection();
			IndexFactory index = IndexFactory.newInstance(1, 8);
			String sql;
			if(getByCpf(professor.getCpf()) == null) {
				sql = "INSERT INTO Professor VALUES (?,?,?,?,?,?,?,?);";
				statement = connection.prepareStatement(sql);
				statement.setString(index.nextIndex(), professor.getCpf());
				statement = setCommonValuesInStatement(sql, statement, professor, index);
			} else {
				sql = "UPDATE Professor SET nome = ?,email = ?,nivelConhecimento = ?,telefone = ?,materia = ?,disponibilidade = ?,descricao = ? WHERE cpf = ?;";	
				statement = connection.prepareStatement(sql);
				statement = setCommonValuesInStatement(sql, statement, professor, index);
				statement.setString(index.nextIndex(), professor.getCpf());
			}
			statement.execute();
			connection.commit();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(connection != null)
				connection.close();
		}
	}
	
	private static PreparedStatement setCommonValuesInStatement(String sql, PreparedStatement statement, Professor professor, IndexFactory index) throws IndexOutOfBoundsException, SQLException {
		statement.setString(index.nextIndex(), professor.getNome());
		statement.setString(index.nextIndex(), professor.getEmail());
		statement.setString(index.nextIndex(), professor.getNivelConhecimento());
		statement.setString(index.nextIndex(), professor.getTelefone());
		statement.setString(index.nextIndex(), professor.getMateria());
		statement.setDate(index.nextIndex(), DateUtil.convertJavaDateToSQL(professor.getDisponibilidade()));
		statement.setString(index.nextIndex(), professor.getDescricao());
		return statement;
	}
	
	public static Professor getByCpf(String cpf) throws SQLException {
		Professor professor = null;
		Connection connection = null;
		try {
			PreparedStatement statement;
			connection = DBManager.getConnection();
			String sql = "SELECT * FROM Professor WHERE cpf = ?;";
			statement = connection.prepareStatement(sql); 
			statement.setString(1, cpf);
			ResultSet result = statement.executeQuery();
			IndexFactory index = null;
			while(result.next()){
				index = IndexFactory.newInstance(1, 8);
				professor = new Professor();
	            professor.setCpf(result.getString(index.nextIndex()));
	            professor.setNome(result.getString(index.nextIndex()));
	            professor.setEmail(result.getString(index.nextIndex()));
	            professor.setNivelConhecimento(result.getString(index.nextIndex()));
	            professor.setTelefone(result.getString(index.nextIndex()));
	            professor.setMateria(result.getString(index.nextIndex()));
	            professor.setDisponibilidade(result.getDate(index.nextIndex()));
	            professor.setDescricao(result.getString(index.nextIndex()));
	         }
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(connection != null)
				connection.close();
		}
		return professor;
	}
	
	public static void delete(String cpf) throws SQLException {
		Connection connection = null;
		try {
			PreparedStatement statement;
			connection = DBManager.getConnection();
			String sql = "DELETE FROM Professor WHERE cpf = ?;";
			statement = connection.prepareStatement(sql);
			statement.setString(1, cpf);
			statement.execute();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			if(connection != null)
				connection.close();
		}
		
	}
	
	

}
