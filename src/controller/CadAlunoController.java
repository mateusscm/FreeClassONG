package controller;

import static application.Main.sceneChange;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CadAlunoController {

    @FXML
    private Label lblEmailAluno;

    @FXML
    private TextArea tfDescAluno;

    @FXML
    private Label lblDescAluno;

    @FXML
    private ComboBox<?> sctDispAluno;

    @FXML
    private TextField tfMatAluno;

    @FXML
    private Label lblMatAluno;

    @FXML
    private Label lblDispAluno;

    @FXML
    private Label lblNameAluno;

    @FXML
    private Label lblTelAluno;

    @FXML
    private TextField tfNomeAluno;

    @FXML
    private AnchorPane btnProfessores;

    @FXML
    private Button btnSalvaAluno;

    @FXML
    private AnchorPane btnAulas;

    @FXML
    private TextField tfCpfAluno;

    @FXML
    private TextField tfTelAluno;

    @FXML
    private ComboBox<?> sctConhecimentoAluno;

    @FXML
    private AnchorPane btnAlunos;

    @FXML
    private AnchorPane btnSair;

    @FXML
    private Button btnCancelaAluno;

    @FXML
    private Label lblCpfAluno;

    @FXML
    private Label lblConhAluno;

    @FXML
    private TextField tfEmailAluno;

    @FXML
    private AnchorPane btnHome;

    @FXML
    void clickCancelaAluno(ActionEvent event) {

    }

    @FXML
    void clickSalvaAluno(ActionEvent event) {

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
