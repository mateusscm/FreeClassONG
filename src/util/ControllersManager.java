package util;

import java.io.IOException;

import application.Aluno;
import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllersManager {
	
	public static Aluno aluno;
	public static boolean isEditAluno;
	
	public static void changeToAlunoStage(Aluno aluno, Stage palco, Scene scener) throws IOException {
		ControllersManager.aluno = aluno;
		Parent fxmlAluno = FXMLLoader.load(Main.class.getResource("../views/CadAlunoScene.fxml"));
        scener = new Scene(fxmlAluno);
		palco.setScene(scener);
        palco.centerOnScreen();
        isEditAluno = true;
	}
	
	public static Aluno getAluno() {
		Aluno al = aluno;
//		aluno = null;
		isEditAluno = false;
		return al;
	}
}
