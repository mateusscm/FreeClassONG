package application;
	
import database.DBManager;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import util.ControllersManager;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	private static Stage palco;
    private static Scene sceneHome;
    private static Scene sceneListProf;
    private static Scene sceneListAluno;
    private static Scene sceneCadProf;
    private static Scene sceneCadAluno;
    private static Scene sceneGerAula;
    private static Scene sceneEditAula;
	
	@Override
	public void start(Stage primaryStage) {
		try {
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
			DBManager.startDatabase();
			palco = primaryStage;
			
			Parent fxmlHome = FXMLLoader.load(getClass().getResource("../views/HomeScreen.fxml"));
			sceneHome = new Scene(fxmlHome);
			
			palco.setTitle("");
			palco.setScene(sceneHome);
			palco.setResizable(false);
			// palco.initStyle(StageStyle.UNDECORATED);
			palco.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	@Override
	public void stop() {
		DBManager.stopDBServer();
	}
	
	public static void loadListProfessor() throws Exception{
        Parent fxmlProf = FXMLLoader.load(Main.class.getResource("../views/ListProfessorScene.fxml"));
        sceneListProf = new Scene(fxmlProf);
    }
	
	public static void loadListAluno() throws Exception{
        Parent fxmlAluno = FXMLLoader.load(Main.class.getResource("../views/ListAlunoScene.fxml"));
        sceneListAluno = new Scene(fxmlAluno);
    }
	
	public static void loadCadProfessor() throws Exception{
        Parent fxmlProf = FXMLLoader.load(Main.class.getResource("../views/CadProfessorScene.fxml"));
        sceneCadProf = new Scene(fxmlProf);
    }
	
	public static void loadCadAluno() throws Exception{
        Parent fxmlAluno = FXMLLoader.load(Main.class.getResource("../views/CadAlunoScene.fxml"));
        sceneCadAluno = new Scene(fxmlAluno);
    }
	
	public static void loadGerenciaAula() throws Exception{
        Parent fxmlGerAula = FXMLLoader.load(Main.class.getResource("../views/GerenciarAulaScene.fxml"));
        sceneGerAula = new Scene(fxmlGerAula);
    }
	
	public static void loadEditaAula() throws Exception{
        Parent fxmlEditAula = FXMLLoader.load(Main.class.getResource("../views/EditAulaScene.fxml"));
        sceneEditAula = new Scene(fxmlEditAula);
    }
	
	public static void sceneChange(String cena, Object obj) throws Exception {
		if (obj instanceof Aluno) {
			ControllersManager.changeToAlunoStage((Aluno )obj, palco, sceneCadAluno);
            
		} 
		else if (obj instanceof Professor) {
			ControllersManager.changeToProfessorStage((Professor )obj, palco, sceneCadProf);
            
		}
		
	}
	
	public static void sceneChange(String cena) throws Exception {
        switch (cena){
            case "sceneHome":
                palco.setScene(sceneHome);
                break;
            case "sceneListProf":
                loadListProfessor();
                palco.setScene(sceneListProf);
                palco.centerOnScreen();
                break;
            case "sceneListAluno":
            	loadListAluno();
                palco.setScene(sceneListAluno);
                palco.centerOnScreen();
                break;
            case "sceneCadProf":
            	loadCadProfessor();
                palco.setScene(sceneCadProf);
                palco.centerOnScreen();
                break;
            case "sceneCadAluno":
            	loadCadAluno();
                palco.setScene(sceneCadAluno);
                palco.centerOnScreen();
                break;
            case "sceneGerAula":
            	loadGerenciaAula();
                palco.setScene(sceneGerAula);
                palco.centerOnScreen();
                break;
            case "sceneEditAula":
            	loadEditaAula();
                palco.setScene(sceneEditAula);
                palco.centerOnScreen();
                break;
        }
    }
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
