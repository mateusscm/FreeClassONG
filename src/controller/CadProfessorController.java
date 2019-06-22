package controller;

import static application.Main.sceneChange;
import static database.ProfessorDAO.save;
import database.AulaDAO;

import java.awt.Checkbox;
import java.sql.SQLException;
import java.util.Date;

import application.Disponibilidade;
import application.Professor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import util.ControllersManager;

public class CadProfessorController {

	public void initialize() throws SQLException {
		Professor p = ControllersManager.getProfessor();
		if (p != null) {
			tfCpfProf.setText(p.getCpf());
			tfNomeProf.setText(p.getNome());
			tfEmailProf.setText(p.getEmail());
			tfTelProf.setText(p.getTelefone());
			tfMatProf.setText(p.getMateria());
		}		
	} 
	
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
    private CheckBox ckSegunda;
    
    @FXML
    private CheckBox ckTerca;

    @FXML
    private CheckBox ckQuarta;

    @FXML
    private CheckBox ckQuinta;

    @FXML
    private CheckBox ckSexta;

    @FXML
    private RadioButton manha;
    
    @FXML
    private RadioButton tarde;
    
    @FXML
    private RadioButton noite;
    

    @FXML
    public void clickCancelaProf() throws Exception{
    	sceneChange("sceneListProf");
    }

    @FXML
    void clickSalvaProf(ActionEvent event) throws Exception {
    	Disponibilidade d = new Disponibilidade(tfCpfProf.getText(), "",ckSegunda.isSelected(), ckTerca.isSelected(), ckQuarta.isSelected(), ckQuinta.isSelected(), ckSexta.isSelected(), manha.isSelected(), tarde.isSelected(), noite.isSelected());
    	System.out.println(d.getCPF());
    	Professor p = new Professor(tfCpfProf.getText(), tfNomeProf.getText(), tfEmailProf.getText(), sctConhecimentoProf.getPromptText(), tfTelProf.getText(), tfMatProf.getText(), "");
    	save(p);
    	AulaDAO.save_disp(d);
    	sceneChange("sceneListProf");
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
