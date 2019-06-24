package controller;

import static application.Main.sceneChange;
import static database.AlunoDAO.getAll;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import application.Aluno;
import application.Aula;
import application.Professor;
import database.AlunoDAO;
import database.AulaDAO;
import database.ProfessorDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class GerenciarAulaController {

    @FXML
    private Label lblHorario1;
    
    @FXML
    private Label lblHorario2;
    
    @FXML
    private Label lblHorario3;

    @FXML
    private Label lblNivel;

    @FXML
    private Button btnEdit;

    @FXML
    private TableColumn<Aluno, String> colTel1;

    @FXML
    private TableColumn<Aluno, String> colCpf1;
    
    @FXML
    private TableColumn<Aluno, String> colAluno1;
    
    @FXML
    private TableColumn<Aluno, String> colEmail1;
    
    @FXML
    private TableColumn<Aluno, String> colTel2;

    @FXML
    private TableColumn<Aluno, String> colCpf2;
    
    @FXML
    private TableColumn<Aluno, String> colAluno2;
    
    @FXML
    private TableColumn<Aluno, String> colEmail2;
    
    @FXML
    private TableColumn<Aluno, String> colTel3;

    @FXML
    private TableColumn<Aluno, String> colCpf3;
    
    @FXML
    private TableColumn<Aluno, String> colAluno3;
    
    @FXML
    private TableColumn<Aluno, String> colEmail3;

    @FXML
    private Tab tab3;

    @FXML
    private TableView<Aluno> tbAluno;
    
    @FXML
    private Tab tab1;

    @FXML
    private TableView<Aluno> tbAluno1;

    @FXML
    private Tab tab2;

    @FXML
    private AnchorPane btnAlunos;

    @FXML
    private Label lblProf1;
    
    @FXML
    private Label lblProf2;
    
    @FXML
    private Label lblProf3;

    @FXML
    private Button btnEdit1;

    @FXML
    private AnchorPane btnHome;

    @FXML
    private TableView<Aluno> tbAluno11;

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
    private AnchorPane btnSair;


    @FXML
    void ClickDate(ActionEvent event) throws SQLException {
    	lblProf1.setText("...");
		 lblHorario1.setText("...");
		 lblProf2.setText("...");
		 lblHorario2.setText("...");
		 lblProf3.setText("...");
		 lblHorario3.setText("...");
		 this.tbAluno.getItems().clear();
		 this.tbAluno1.getItems().clear();
		 this.tbAluno11.getItems().clear();
        String day = format_date(datePicker.getValue().getDayOfWeek().name());

		Iterator<Aula> iter = AulaDAO.getByDate(day).iterator(); 
		 while (iter.hasNext()) {
			 Aula a = iter.next();
			 Professor p = ProfessorDAO.getByCpf(a.getCpf_professor());
			 if (a.getHora().equals("manha")) {
				 lblProf1.setText(p.getNome());
				 lblHorario1.setText("Manha");
				 fillALuno(1, a.getId_aula());
			 } else if (a.getHora().equals("tarde")) {
				 lblProf2.setText(p.getNome());
				 lblHorario2.setText("Tarde");
				 fillALuno(2, a.getId_aula());
			 } else {
				 lblProf3.setText(p.getNome());
				 lblHorario3.setText("Noite");
				 fillALuno(3, a.getId_aula());
			 }
		 }
    }
    
    public void fillALuno(int n, int id) throws SQLException {
    	ArrayList<Aluno> alunos = AlunoDAO.getInClass(id);
    	if (n == 1) {
    		this.colAluno1.setCellValueFactory(new PropertyValueFactory<Aluno, String>("nome"));
    		this.colCpf1.setCellValueFactory(new PropertyValueFactory<Aluno, String>("cpf"));
    		this.colEmail1.setCellValueFactory(new PropertyValueFactory<Aluno, String>("email"));
    		this.colTel1.setCellValueFactory(new PropertyValueFactory<Aluno, String>("telefone"));
    		this.tbAluno.getItems().setAll(alunos);
    		
    	} else if (n == 2) {
    		this.colAluno2.setCellValueFactory(new PropertyValueFactory<Aluno, String>("nome"));
    		this.colCpf2.setCellValueFactory(new PropertyValueFactory<Aluno, String>("cpf"));
    		this.colEmail2.setCellValueFactory(new PropertyValueFactory<Aluno, String>("email"));
    		this.colTel2.setCellValueFactory(new PropertyValueFactory<Aluno, String>("telefone"));
    		this.tbAluno1.getItems().setAll(alunos);
    	} else {
    		this.colAluno3.setCellValueFactory(new PropertyValueFactory<Aluno, String>("nome"));
    		this.colCpf3.setCellValueFactory(new PropertyValueFactory<Aluno, String>("cpf"));
    		this.colEmail3.setCellValueFactory(new PropertyValueFactory<Aluno, String>("email"));
    		this.colTel3.setCellValueFactory(new PropertyValueFactory<Aluno, String>("telefone"));
    		this.tbAluno11.getItems().setAll(alunos);
    	}

    	
    	
    }
    public String format_date(String d) {
    	switch (d) {
    	case "MONDAY":
			return "seg";
		case "TUESDAY":
			return "ter";
		case "WEDNESDAY":
			return "qua";
		case "THURSDAY":
			return "qui";
		case "FRIDAY":
			return "sex";
		default:
			return "";
		}
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
