package controller;

import static application.Main.sceneChange;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class ListProfessorController {

    @FXML
    private TableView<?> tbProfessores;

    @FXML
    private TableColumn<?, ?> colCPFProf;

    @FXML
    private AnchorPane btnProfessores;

    @FXML
    private TableColumn<?, ?> colDispProf;

    @FXML
    private Button btnExcluirProf;

    @FXML
    private AnchorPane btnAulas;

    @FXML
    private TableColumn<?, ?> colConhecimentoProf;

    @FXML
    private TableColumn<?, ?> colMateriaProf;

    @FXML
    private Button btnCadastrarProf;

    @FXML
    private AnchorPane btnAlunos;

    @FXML
    private AnchorPane btnSair;

    @FXML
    private TableColumn<?, ?> colTelProf;

    @FXML
    private Button btnAlterarProf;

    @FXML
    private TableColumn<?, ?> colNomeProf;

    @FXML
    private TableColumn<?, ?> colEmailProf;

    @FXML
    private AnchorPane btnHome;

    @FXML
    public void clickCadastrarProf() throws Exception {
    	sceneChange("sceneCadProf");
    }

    @FXML
    public void clickAlterarProf() throws Exception {
    	sceneChange("sceneCadProf");
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
