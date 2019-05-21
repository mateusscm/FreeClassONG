package controller;

import static application.Main.sceneChange;
import static database.ProfessorDAO.getAll;

import java.sql.SQLException;
import java.util.ArrayList;

import application.Professor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ListProfessorController {

	public void initialize() throws SQLException {
		ArrayList<Professor> professor = getAll();

		this.colNomeProf.setCellValueFactory(new PropertyValueFactory<Professor, String>("nome"));
    	this.colEmailProf.setCellValueFactory(new PropertyValueFactory<Professor, String>("email"));
    	this.colTelProf.setCellValueFactory(new PropertyValueFactory<Professor, String>("telefone"));
    	this.colConhecimentoProf.setCellValueFactory(new PropertyValueFactory<Professor, String>("conhecimento"));
    	this.colCPFProf.setCellValueFactory(new PropertyValueFactory<Professor, String>("cpf"));
    	this.colMateriaProf.setCellValueFactory(new PropertyValueFactory<Professor, String>("materia"));
    	this.colDispProf.setCellValueFactory(new PropertyValueFactory<Professor, String>("disponibilidade"));

    	
    	
    	this.tbProfessores.getItems().setAll(professor);
		
	}
    @FXML
    private TableView<Professor> tbProfessores;

    @FXML
    private TableColumn<Professor, String>colCPFProf;

    @FXML
    private AnchorPane btnProfessores;

    @FXML
    private TableColumn<Professor, String>colDispProf;

    @FXML
    private Button btnExcluirProf;

    @FXML
    private AnchorPane btnAulas;

    @FXML
    private TableColumn<Professor, String>colConhecimentoProf;

    @FXML
    private TableColumn<Professor, String>colMateriaProf;

    @FXML
    private Button btnCadastrarProf;

    @FXML
    private AnchorPane btnProfs;

    @FXML
    private AnchorPane btnSair;

    @FXML
    private TableColumn<Professor, String>colTelProf;

    @FXML
    private Button btnAlterarProf;

    @FXML
    private TableColumn<Professor, String>colNomeProf;

    @FXML
    private TableColumn<Professor, String>colEmailProf;

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
