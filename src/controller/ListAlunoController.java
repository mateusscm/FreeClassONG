package controller;

import static application.Main.sceneChange;
import static database.AlunoDAO.getAll;
import static database.AlunoDAO.delete;

import java.sql.SQLException;
import java.util.ArrayList;

import application.Aluno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ListAlunoController {
	
	public void initialize() throws SQLException {
		ArrayList<Aluno> alunos = getAll();

		this.colNomeAluno.setCellValueFactory(new PropertyValueFactory<Aluno, String>("nome"));
    	this.colEmailAluno.setCellValueFactory(new PropertyValueFactory<Aluno, String>("email"));
    	this.colTelAluno.setCellValueFactory(new PropertyValueFactory<Aluno, String>("telefone"));
    	this.colConhecimentoAluno.setCellValueFactory(new PropertyValueFactory<Aluno, String>("conhecimento"));
    	this.colCPFAluno.setCellValueFactory(new PropertyValueFactory<Aluno, String>("cpf"));
    	this.colMateriaAluno.setCellValueFactory(new PropertyValueFactory<Aluno, String>("materia"));
    	this.colDispAluno.setCellValueFactory(new PropertyValueFactory<Aluno, String>("disponibilidade"));

    	
    	
    	this.tbAlunos.getItems().setAll(alunos);
		
	}

    @FXML
    private TableColumn<Aluno, String>colEmailAluno;

    @FXML
    private TableColumn<Aluno, String>colTelAluno;

    @FXML
    private AnchorPane btnProfessores;

    @FXML
    private TableView<Aluno> tbAlunos;

    @FXML
    private Button btnExcluirAluno;

    @FXML
    private TableColumn<Aluno, String>colNomeAluno;

    @FXML
    private AnchorPane btnAulas;

    @FXML
    private TableColumn<Aluno, String>colConhecimentoAluno;

    @FXML
    private TableColumn<Aluno, String>colMateriaAluno;

    @FXML
    private TableColumn<Aluno, String>colCPFAluno;

    @FXML
    private Button btnCadastrarAluno;

    @FXML
    private AnchorPane btnAlunos;

    @FXML
    private AnchorPane btnSair;

    @FXML
    private Button btnAlterarAluno;

    @FXML
    private TableColumn<Aluno, String>colDispAluno;

    @FXML
    private AnchorPane btnHome;

    @FXML
    public void clickCadastrarProf() throws Exception {
    	sceneChange("sceneCadAluno");
    }

    @FXML
    public void clickAlterarProf() throws Exception {
    	int index = this.tbAlunos.getSelectionModel().getSelectedIndex();

        Aluno a = tbAlunos.getItems().get(index);
    	sceneChange("sceneCadAluno", a);
    }

    @FXML
    void clickExcluirProf(ActionEvent event) throws SQLException {
    	int index = this.tbAlunos.getSelectionModel().getSelectedIndex();

        Aluno a = tbAlunos.getItems().get(index); 
        delete(a.getCpf());
        this.initialize();
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

