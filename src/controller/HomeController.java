package controller;
import util.ClassCreator;
import static application.Main.sceneChange;
import static database.AulaDAO.getCountAula;
import static database.AlunoDAO.getCountAluno;
import static database.ProfessorDAO.getCountProfessor;


import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class HomeController {

	public void initialize() throws Exception {
		lblNroProf.setText(Integer.toString(getCountProfessor()));
		lblNroAlunos.setText(Integer.toString(getCountAluno()));
		ClassCreator.create();
		lblNroAulas.setText(Integer.toString(getCountAula()));
	}
	
    @FXML
    private Label txtNroProf;

    @FXML
    private Label lblNroConc;

    @FXML
    private Label txtNroConcluiram;

    @FXML
    private AnchorPane btnProfessores;

    @FXML
    private Label txtNroAulas;

    @FXML
    private AnchorPane btnAulas;

    @FXML
    private LineChart<?, ?> chartTwo;

    @FXML
    private Label lblNroDisc;

    @FXML
    private Label txtNroAluno;

    @FXML
    private Label lblNroProf;

    @FXML
    private Label txtNroDisciplinas;

    @FXML
    private LineChart<?, ?> chartOne;

    @FXML
    private AnchorPane btnAlunos;

    @FXML
    private AnchorPane btnSair;

    @FXML
    private Label lblNroAulas;

    @FXML
    private Label lblNroAlunos;

    @FXML
    private AnchorPane btnHome;
    
    @FXML
    public void clickHome() throws Exception {
    	sceneChange("sceneHome");
    }

    @FXML
    public void clickAulas() throws Exception {
    	sceneChange("sceneGerAula");
    }

    @FXML
    public void clickProfessores() throws Exception {
    	sceneChange("sceneListProf");
    }


    @FXML
    public void clickAlunos() throws Exception {
    	sceneChange("sceneListAluno");
    }

    @FXML
    void clickSair(ActionEvent event) {
    	System.exit(0);
    }
}
