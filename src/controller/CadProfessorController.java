package controller;

import static application.Main.sceneChange;
import static database.ProfessorDAO.save;

import java.sql.SQLException;
import java.util.Date;

import application.Professor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CadProfessorController {

    @FXML
    private Button btnCancelaProf;

    @FXML
    private AnchorPane btnProfessores;

    @FXML
    private Button btnSalvaProf;

    @FXML
    private AnchorPane btnAulas;

    @FXML
    private Label lblCpfProf;

    @FXML
    private ComboBox<?> sctConhecimentoProf;

    @FXML
    private ComboBox<?> sctDispProf;

    @FXML
    private TextField tfMatProf;

    @FXML
    private Label lblEmailProf;

    @FXML
    private Label lblDispProf;

    @FXML
    private Label lblDescProf;

    @FXML
    private Label lblTelProf;

    @FXML
    private TextField tfNomeProf;

    @FXML
    private TextField tfEmailProf;

    @FXML
    private TextField tfTelProf;

    @FXML
    private Label lblMatProf;

    @FXML
    private AnchorPane btnAlunos;

    @FXML
    private AnchorPane btnSair;

    @FXML
    private Label lblConhProf;

    @FXML
    private TextArea tfDescProf;

    @FXML
    private TextField tfCpfProf;

    @FXML
    private AnchorPane btnHome;

    @FXML
    private Label lblNameProf;

    @FXML
    void clickCancelaProf(ActionEvent event) {

    }

    @FXML
    void clickSalvaProf(ActionEvent event) throws SQLException {
    	Date a = new Date(); //Tem problema nessa variavel disponibildade aaaa 
    	Professor p = new Professor(tfCpfProf.getText(), tfNomeProf.getText(), tfEmailProf.getText(), sctConhecimentoProf.getPromptText(), tfTelProf.getText(), tfMatProf.getText(), a, tfDescProf.getText());
    	save(p);
    }

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
    	
    }

}
