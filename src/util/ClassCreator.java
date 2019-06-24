package util;

import database.AulaDAO;
import database.ProfessorDAO;
import database.AlunoDAO;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import application.Aula;
import application.Professor;

public class ClassCreator {
	//sdds dict do python
	private static String[] day = {"seg", "ter", "qua", "qui", "sex"};
	private static String[] period = {"manha", "tarde", "noite"};
	
	public static void create() throws Exception {
//			ArrayList<String> professor_list = ProfessorDAO.getNotInClass();
//			ArrayList<String> aluno_list = AlunoDAO.getNotInClass();
		for (int i = 0; i < day.length; i++) {
			for (int j = 0; j < period.length; j++) {
				//Pega o 1o professor que esta disponivel no dia/periodo da iteracao e cria uma turma com ele
				String p = ProfessorDAO.getFirst(day[i], period[j]);
				if (p != null) {
					String cpf = ProfessorDAO.getFirst(day[i], period[j]);
					Aula a = new Aula(cpf, i+j, day[i], period[j]);
					AulaDAO.save(a);
					add_alunos(a, day[i], period[j], cpf);
				}
			}
		}
		
	}
	
	public static void add_alunos(Aula a, String day, String period, String cpf) throws Exception {
		AlunoDAO.add_in_class(AlunoDAO.getNotInClass(day, period, a), AulaDAO.getByCpf(cpf));
	}
}
