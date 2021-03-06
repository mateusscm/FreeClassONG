package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import application.Aula;
import application.Disponibilidade;
import application.Professor;
import util.DateUtil;
import util.IndexFactory;
public class AulaDAO {
		public static ArrayList<Aula> getAll() throws SQLException {
			ArrayList<Aula> aula_list = new ArrayList<Aula>();
			Connection connection = null;
			try {
				PreparedStatement statement;
				connection = DBManager.getConnection();
				String sql = "SELECT * FROM Turma;";
				statement = connection.prepareStatement(sql); 
				ResultSet result = statement.executeQuery();
				IndexFactory index = null;
				while(result.next()){
					index = IndexFactory.newInstance(1, 8);
					Aula aula = new Aula();
		            //LATER BITCH
		         }
				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(connection != null)
					connection.close();
			}
			return aula_list;
		}
		
		public static int getCountAula() throws SQLException {
			int quantidade = 0;
			Connection connection = null;
			try {
				PreparedStatement statement;
				connection = DBManager.getConnection();
				String sql = "SELECT * FROM Turma;"; //Sei que poderia usar count, vou mudar jaja, foi mal deus o java
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
		
		public static void save(Aula aula) throws SQLException {
			Connection connection = null;
			try {
				PreparedStatement statement;
				connection = DBManager.getConnection();
				IndexFactory index = IndexFactory.newInstance(1, 6);
				String sql;
				if(getById(aula.getId_aula()) == null) {
					sql = "INSERT INTO Turma (cpf_prof, dia_da_semana, max_alunos, min_alunos, hora) VALUES (?,?,?,?,?);";
					statement = connection.prepareStatement(sql);
					statement = setCommonValuesInStatement(sql, statement, aula, index);
				} else {
					sql = "UPDATE Turma SET cpf_prof = ?,codigo = ?,dia_da_semana = ?,hora = ?,max_alunos = ?, min_alunos = ? WHERE codigo = ?;";	
					statement = connection.prepareStatement(sql);
					statement = setCommonValuesInStatement(sql, statement, aula, index);
					statement.setString(index.nextIndex(), Integer.toString(aula.getId_aula()));
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
		
		private static PreparedStatement setCommonValuesInStatement(String sql, PreparedStatement statement, Aula a, IndexFactory index) throws IndexOutOfBoundsException, SQLException {
			statement.setString(index.nextIndex(), a.getCpf_professor());
			statement.setString(index.nextIndex(), a.getDia_semana());
			statement.setInt(index.nextIndex(), a.getMax_alunos());
			statement.setInt(index.nextIndex(), a.getMin_alunos());
			statement.setString(index.nextIndex(), a.getHora());
			return statement;
		}
		
		public static Aula getById(int id) throws SQLException {
			Aula aula = null;
			Connection connection = null;
			try {
				PreparedStatement statement;
				connection = DBManager.getConnection();
				String sql = "SELECT * FROM Turma WHERE codigo = ?;";
				statement = connection.prepareStatement(sql); 
				statement.setString(1, Integer.toString(id));
				ResultSet result = statement.executeQuery();
				IndexFactory index = null;
				while(result.next()){
					index = IndexFactory.newInstance(1, 8);
					aula = new Aula();
					aula.setCpf_professor(result.getString(index.nextIndex()));
					aula.setId_aula(Integer.parseInt(result.getString(index.nextIndex())));
					aula.setMateria(result.getString(index.nextIndex()));
					//ADICIONAR DISPONIBILIDADE AQUI
		         }
				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(connection != null)
					connection.close();
			}
			return aula;
		}
		public static String getByCpf(String cpf) throws SQLException {
			Connection connection = null;
			Aula aula = null;
			try {
				PreparedStatement statement;
				connection = DBManager.getConnection();
				String sql = "SELECT * FROM Turma WHERE cpf_prof = ?;";
				statement = connection.prepareStatement(sql); 
				statement.setString(1, cpf);
				ResultSet result = statement.executeQuery();
				IndexFactory index = null;
				while(result.next()){
					index = IndexFactory.newInstance(1, 8);
					aula = new Aula();
					aula.setId_aula(Integer.parseInt(result.getString(index.nextIndex())));
		         }
				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(connection != null)
					connection.close();
			}
			return Integer.toString(aula.getId_aula());
		}
		
		public static ArrayList<Aula> getByDate(String day) throws SQLException {
			Aula aula = null;
			ArrayList<Aula> a = new ArrayList<Aula>();
			Connection connection = null;
			try {
				PreparedStatement statement;
				connection = DBManager.getConnection();
				String sql = "SELECT * FROM Turma WHERE dia_da_semana = ?;";
				statement = connection.prepareStatement(sql); 
				statement.setString(1, day);
				ResultSet result = statement.executeQuery();
				IndexFactory index = null;
				while(result.next()){
					index = IndexFactory.newInstance(1, 6);
					aula = new Aula();
					aula.setId_aula(Integer.parseInt(result.getString(index.nextIndex())));
					aula.setCpf_professor(result.getString(index.nextIndex()));
					aula.setDia_semana(result.getString(index.nextIndex()));
					aula.setMax_alunos(result.getInt(index.nextIndex()));
					aula.setMin_alunos(result.getInt(index.nextIndex()));
					aula.setHora(result.getString(index.nextIndex()));
					a.add(aula);
		         }
				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(connection != null)
					connection.close();
			}
			return a;
		}
		
		
		public static void delete(int id) throws SQLException {
			Connection connection = null;
			try {
				PreparedStatement statement;
				connection = DBManager.getConnection();
				String sql = "DELETE FROM Turma WHERE codigo = ?;";
				statement = connection.prepareStatement(sql);
				statement.setString(1, Integer.toString(id));
				statement.execute();
				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}  finally {
				if(connection != null)
					connection.close();
			}
			
		}
		
		
		public static void save_disp(Disponibilidade d) throws SQLException {
			Connection connection = null;
			try {
				PreparedStatement statement;
				connection = DBManager.getConnection();
				IndexFactory index = IndexFactory.newInstance(1, 9);
				String sql;
					sql = "INSERT INTO Disponibilidade"+d.getType()+" VALUES (?,?,?,?,?,?,?,?,?);";
					statement = connection.prepareStatement(sql);
					statement = setCommonValuesInStatementDisp(sql, statement, d, index);
				
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
		
		private static PreparedStatement setCommonValuesInStatementDisp(String sql, PreparedStatement statement, Disponibilidade d, IndexFactory index) throws IndexOutOfBoundsException, SQLException {
			statement.setString(index.nextIndex(), d.getCPF());
			statement.setBoolean(index.nextIndex(), d.getSegunda());
			statement.setBoolean(index.nextIndex(), d.getTerca());
			statement.setBoolean(index.nextIndex(), d.getQuarta());
			statement.setBoolean(index.nextIndex(), d.getQuinta());
			statement.setBoolean(index.nextIndex(), d.getSexta());
			statement.setBoolean(index.nextIndex(), d.getManha());
			statement.setBoolean(index.nextIndex(), d.getTarde());
			statement.setBoolean(index.nextIndex(), d.getNoite());
			return statement;
		}
		
}
