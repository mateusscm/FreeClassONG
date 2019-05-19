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

			statement.executeUpdate("CREATE TABLE Aluno(" + 
					"cpf VARCHAR(20) PRIMARY KEY," + 
					"nome VARCHAR(50) NOT NULL," + 
					"email VARCHAR(50)," + 
					"nivelConhecimento VARCHAR(50)," + 
					"telefone VARCHAR(50)," + 
					"materia VARCHAR(50)," + 
					"disponibilidade DATE," + 
					"descricao VARCHAR(255)" + 
					");"
					);

		}  catch (Exception e) {
			try {
				AlunoDAO.delete("1111");
				AlunoDAO.getByCpf("");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace(System.out);
		}
	}

	public static void startDBServer() {
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

	        public void run() {
	            stopDBServer();
	        }
	    }));
		
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
