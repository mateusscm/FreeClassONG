package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.Aluno;
import util.DateUtil;
import util.IndexFactory;

public class AlunoDAO {

	public static void save(Aluno aluno) throws SQLException {
		Connection connection = null;
		try {
			PreparedStatement statement;
			connection = DBManager.getConnection();
			IndexFactory index = IndexFactory.newInstance(1, 8);
			String sql;
			if(getByCpf(aluno.getCpf()) == null) {
				sql = "INSERT INTO Aluno VALUES (?,?,?,?,?,?,?,?);";
				statement = connection.prepareStatement(sql);
				statement.setString(index.nextIndex(), aluno.getCpf());
				statement = setCommonValuesInStatement(sql, statement, aluno, index);
			} else {
				sql = "UPDATE Aluno SET nome = ?,email = ?,nivelConhecimento = ?,telefone = ?,materia = ?,disponibilidade = ?,descricao = ? WHERE cpf = ?;";	
				statement = connection.prepareStatement(sql);
				statement = setCommonValuesInStatement(sql, statement, aluno, index);
				statement.setString(index.nextIndex(), aluno.getCpf());
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
	
	private static PreparedStatement setCommonValuesInStatement(String sql, PreparedStatement statement, Aluno aluno, IndexFactory index) throws IndexOutOfBoundsException, SQLException {
		statement.setString(index.nextIndex(), aluno.getNome());
		statement.setString(index.nextIndex(), aluno.getEmail());
		statement.setString(index.nextIndex(), aluno.getNivelConhecimento());
		statement.setString(index.nextIndex(), aluno.getTelefone());
		statement.setString(index.nextIndex(), aluno.getMateria());
		statement.setDate(index.nextIndex(), DateUtil.convertJavaDateToSQL(aluno.getDisponibilidade()));
		statement.setString(index.nextIndex(), aluno.getDescricao());
		return statement;
	}
	
	public static Aluno getByCpf(String cpf) throws SQLException {
		Aluno aluno = null;
		Connection connection = null;
		try {
			PreparedStatement statement;
			connection = DBManager.getConnection();
			String sql = "SELECT * FROM Aluno WHERE cpf = ?;";
			statement = connection.prepareStatement(sql); 
			statement.setString(1, cpf);
			ResultSet result = statement.executeQuery();
			IndexFactory index = null;
			while(result.next()){
				index = IndexFactory.newInstance(1, 8);
				aluno = new Aluno();
	            aluno.setCpf(result.getString(index.nextIndex()));
	            aluno.setNome(result.getString(index.nextIndex()));
	            aluno.setEmail(result.getString(index.nextIndex()));
	            aluno.setNivelConhecimento(result.getString(index.nextIndex()));
	            aluno.setTelefone(result.getString(index.nextIndex()));
	            aluno.setMateria(result.getString(index.nextIndex()));
	            aluno.setDisponibilidade(result.getDate(index.nextIndex()));
	            aluno.setDescricao(result.getString(index.nextIndex()));
	         }
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(connection != null)
				connection.close();
		}
		return aluno;
	}
	
	public static void delete(String cpf) throws SQLException {
		Connection connection = null;
		try {
			PreparedStatement statement;
			connection = DBManager.getConnection();
			String sql = "DELETE FROM Aluno WHERE cpf = ?;";
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
