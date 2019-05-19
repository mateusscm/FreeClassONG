package controller;

import static application.Main.sceneChange;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class ListAlunoController {

    @FXML
    private TableColumn<?, ?> colEmailAluno;

    @FXML
    private TableColumn<?, ?> colTelAluno;

    @FXML
    private AnchorPane btnProfessores;

    @FXML
    private TableView<?> tbAlunos;

    @FXML
    private Button btnExcluirAluno;

    @FXML
    private TableColumn<?, ?> colNomeAluno;

    @FXML
    private AnchorPane btnAulas;

    @FXML
    private TableColumn<?, ?> colConhecimentoAluno;

    @FXML
    private TableColumn<?, ?> colMateriaAluno;

    @FXML
    private TableColumn<?, ?> colCPFAluno;

    @FXML
    private Button btnCadastrarAluno;

    @FXML
    private AnchorPane btnAlunos;

    @FXML
    private AnchorPane btnSair;

    @FXML
    private Button btnAlterarAluno;

    @FXML
    private TableColumn<?, ?> colDispAluno;

    @FXML
    private AnchorPane btnHome;

    @FXML
    void clickCadastrarProf(ActionEvent event) {

    }

    @FXML
    void clickAlterarProf(ActionEvent event) {

    }

    @FXML
    void clickExcluirProf(ActionEvent event) {

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

