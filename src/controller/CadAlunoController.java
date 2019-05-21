package controller;

import static application.Main.sceneChange;
import static database.AlunoDAO.save;

import java.sql.SQLException;
import java.util.Date;

import application.Aluno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import util.ControllersManager;

public class CadAlunoController {
	
	public void initialize() throws SQLException {
		Aluno aluno = ControllersManager.getAluno();
		if (aluno != null) {
			tfCpfAluno.setText(aluno.getCpf());
			tfNomeAluno.setText(aluno.getNome());
			tfEmailAluno.setText(aluno.getEmail());
			tfDescAluno.setText(aluno.getDescricao());
			tfTelAluno.setText(aluno.getTelefone());
			tfMatAluno.setText(aluno.getMateria());
		}		
	} 
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
    void clickCancelaAluno() throws Exception {
    	sceneChange("sceneListAluno");
    }

    @FXML
    void clickSalvaAluno(ActionEvent event)throws SQLException {
    	Date a = new Date(); 
    	Aluno aluno = new Aluno(tfCpfAluno.getText(), tfNomeAluno.getText(), tfEmailAluno.getText(), sctConhecimentoAluno.getPromptText(), tfTelAluno.getText(), tfMatAluno.getText(), a, tfDescAluno.getText());
    	save(aluno);
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
