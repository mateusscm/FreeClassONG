package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.Server;


public class DBManager {

	private static final int PORT = 5696;
	private static final String URL = "hsql://localhost:" + PORT + "/freeclass";
	private static final String USER = "SA";
	private static final String PASSWORD = "";
	private static final String DB_NAME = "freeclass";
	private static final String DB_LOCATION = "c:\\temp\\";
	private static Server server;

	public static void startDatabase() {
		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			startDBServer();
			connection = getConnection();
			statement = connection.createStatement();

			String createAluno = "CREATE TABLE Aluno(" + 
					"cpf VARCHAR(20) PRIMARY KEY," + 
					"nome VARCHAR(50) NOT NULL," + 
					"email VARCHAR(50)," + 
					"nivelConhecimento VARCHAR(50)," + 
					"telefone VARCHAR(50)," + 
					"materia VARCHAR(50)," + 
					"descricao VARCHAR(255)" + 
					");";
			String createProfessor = "CREATE TABLE Professor(" + 
					"cpf VARCHAR(20) PRIMARY KEY," + 
					"nome VARCHAR(50) NOT NULL," + 
					"email VARCHAR(50)," + 
					"nivelConhecimento VARCHAR(50)," + 
					"telefone VARCHAR(50)," + 
					"materia VARCHAR(50)," + 
					"descricao VARCHAR(255)" + 
					");";
			String createTurma = "CREATE TABLE Turma(" + 
					"codigo int PRIMARY KEY," + 
					"cpf_prof VARCHAR(20) FOREIGN KEY REFERENCES professor(cpf)," + 
					"materia VARCHAR(20)," +
					"dia_da_semana VARCHAR(20)," +
					"max_alunos int DEFAULT 40," +
					"min_alunos int DEFAULT 20," +
					"hora int);";
			String createAlunoInTurma = "CREATE TABLE AlunoInTurma(" + 
					"cpf_aluno VARCHAR(20) FOREIGN KEY REFERENCES aluno(cpf)PRIMARY KEY," + 
					"cod_turma int FOREIGN KEY REFERENCES turma(codigo));";
			String createDisponibilidade1 = "CREATE TABLE DisponibilidadeP(" + 
					"cpf_prof VARCHAR(20) FOREIGN KEY REFERENCES professor(cpf)," + 
					"seg Boolean DEFAULT 0," +
					"ter Boolean DEFAULT 0," +
					"qua Boolean DEFAULT 0," +
					"qui Boolean DEFAULT 0," +
					"sex Boolean DEFAULT 0," +
					"manha Boolean DEFAULT 0," +
					"tarde Boolean DEFAULT 0," +
					"noite Boolean DEFAULT 0);";
			String createDisponibilidade2 = "CREATE TABLE DisponibilidadeA(" + 
					"cpf_aluno VARCHAR(20) FOREIGN KEY REFERENCES aluno(cpf)," + 
					"seg Boolean DEFAULT 0," +
					"ter Boolean DEFAULT 0," +
					"qua Boolean DEFAULT 0," +
					"qui Boolean DEFAULT 0," +
					"sex Boolean DEFAULT 0," +
					"manha Boolean DEFAULT 0," +
					"tarde Boolean DEFAULT 0," +
					"noite Boolean DEFAULT 0);";
			String createClassLog = "CREATE TABLE ClassLog(" + 
					"date DATE);";
			statement.executeUpdate(createProfessor + createAluno + createDisponibilidade1 + createDisponibilidade2 +createTurma + createAlunoInTurma  + createClassLog);

		}  catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	public static void startDBServer() {
		HsqlProperties props = new HsqlProperties();
		props.setProperty("server.database.0", "file:" + DB_LOCATION + DB_NAME  + ";");
		props.setProperty("server.dbname.0", DB_NAME);
		props.setProperty("server.port", PORT);
		server = new Server();
		try {
			server.setProperties(props);
		} catch (Exception e) {
			return;
		}
		server.start();
	}

	public static void stopDBServer() {
		server.shutdown();
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.hsqldb.jdbcDriver");
		return DriverManager.getConnection("jdbc:hsqldb:" + URL, USER, PASSWORD);
	}
}
