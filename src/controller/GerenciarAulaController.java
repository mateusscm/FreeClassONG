package controller;

import static application.Main.sceneChange;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class GerenciarAulaController {

    @FXML
    private Label lblHorario;

    @FXML
    private Label lblNivel;

    @FXML
    private Button btnEdit;

    @FXML
    private TableColumn<?, ?> colTel;

    @FXML
    private TableColumn<?, ?> colCpf;

    @FXML
    private Tab tab3;

    @FXML
    private TableView<?> tbAluno;

    @FXML
    private Tab tab4;

    @FXML
    private Tab tab1;

    @FXML
    private TableView<?> tbAluno1;

    @FXML
    private Tab tab2;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private AnchorPane btnAlunos;

    @FXML
    private Label lblProf;

    @FXML
    private Button btnEdit1;

    @FXML
    private AnchorPane btnHome;

    @FXML
    private TableView<?> tbAluno1111;

    @FXML
    private TableView<?> tbAluno11;

    @FXML
    private AnchorPane btnProfessores;

    @FXML
    private Label lblMat;

    @FXML
    private DatePicker datePicker;

    @FXML
    private AnchorPane btnAulas;

    @FXML
    private Label lblData;

    @FXML
    private TableColumn<?, ?> colAluno;

    @FXML
    private Tab tab5;

    @FXML
    private AnchorPane btnSair;

    @FXML
    private TableView<?> tbAluno111;

    @FXML
    void ClickDate(ActionEvent event) {

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
