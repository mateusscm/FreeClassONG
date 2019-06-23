package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.Aula;
import application.Professor;
import util.DateUtil;
import util.IndexFactory;

public class ProfessorDAO {
	public static String getFirst(String day, String period) throws SQLException {
		String p = null;
		Connection connection = null;
		try {
			PreparedStatement statement;
			connection = DBManager.getConnection(); //NAO SABIA Q EU SABIA SQL, OLHA ESA QUERY QUE LINDA
			String sql = "SELECT p.cpf FROM (disponibilidadep d INNER JOIN professor p ON  d.cpf_prof = p.cpf) LEFT JOIN turma t ON p.cpf = t.cpf_prof WHERE t.cpf_prof IS NULL AND d."+period+" = TRUE AND d."+day+" = TRUE;";
			statement = connection.prepareStatement(sql); 
			ResultSet result = statement.executeQuery();
			IndexFactory index = null;
			while(result.next()){
				index = IndexFactory.newInstance(1, 1);
				p = result.getString(index.nextIndex());
	            break;
	         }
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(connection != null)
				connection.close();
		}
		
		return p;
	}
	
	public static ArrayList<String> getNotInClass() throws SQLException {
		ArrayList<String> professor_list = new ArrayList<String>();
		Connection connection = null;
		try {
			PreparedStatement statement;
			connection = DBManager.getConnection();
			String sql = "SELECT p.cpf FROM professor p LEFT JOIN turma t on p.cpf = t.cpf_prof WHERE t.cpf_prof IS NULL;";
			statement = connection.prepareStatement(sql); 
			ResultSet result = statement.executeQuery();
			IndexFactory index = null;
			while(result.next()){
				index = IndexFactory.newInstance(1, 1);
	            professor_list.add(result.getString(index.nextIndex())); 
	         }
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(connection != null)
				connection.close();
		}
		return professor_list;
	}
	public static ArrayList<Professor> getAll() throws SQLException {
		ArrayList<Professor> professor_list = new ArrayList<Professor>();
		Connection connection = null;
		try {
			PreparedStatement statement;
			connection = DBManager.getConnection();
			String sql = "SELECT * FROM Professor;";
			statement = connection.prepareStatement(sql); 
			ResultSet result = statement.executeQuery();
			IndexFactory index = null;
			while(result.next()){
				index = IndexFactory.newInstance(1, 8);
				Professor professor = new Professor();
	            professor.setCpf(result.getString(index.nextIndex()));
	            professor.setNome(result.getString(index.nextIndex()));
	            professor.setEmail(result.getString(index.nextIndex()));
	            professor.setNivelConhecimento(result.getString(index.nextIndex()));
	            professor.setTelefone(result.getString(index.nextIndex()));
	            professor.setMateria(result.getString(index.nextIndex()));
	            professor.setDescricao(result.getString(index.nextIndex()));
	            professor_list.add(professor); 
	         }
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(connection != null)
				connection.close();
		}
		return professor_list;
	}
	
	public static int getCountProfessor() throws SQLException {
		int quantidade = 0;
		Connection connection = null;
		try {
			PreparedStatement statement;
			connection = DBManager.getConnection();
			String sql = "SELECT * FROM Professor;"; //Sei que poderia usar count, vou mudar jaja, foi mal deus o java
			statement = connection.prepareStatement(sql); 
			ResultSet result = statement.executeQuery();
			while(result.next()){
	            quantidade++;
	             
	         }
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(connection != null)
				connection.close();
		}
		return quantidade;
	}
	
	public static void save(Professor professor) throws SQLException {
		Connection connection = null;
		try {
			PreparedStatement statement;
			connection = DBManager.getConnection();
			IndexFactory index = IndexFactory.newInstance(1, 8);
			String sql;
			if(getByCpf(professor.getCpf()) == null) {
				sql = "INSERT INTO Professor VALUES (?,?,?,?,?,?,?);";
				statement = connection.prepareStatement(sql);
				statement.setString(index.nextIndex(), professor.getCpf());
				statement = setCommonValuesInStatement(sql, statement, professor, index);
			} else {
				sql = "UPDATE Professor SET nome = ?,email = ?,nivelConhecimento = ?,telefone = ?,materia = ?,descricao = ? WHERE cpf = ?;";	
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
