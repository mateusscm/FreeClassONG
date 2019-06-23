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
//					professor_list.add(ProfessorDAO.getFirst(day[i], period[j]));
				String p = ProfessorDAO.getFirst(day[i], period[j]);
				if (p != null) {
					Aula a = new Aula(ProfessorDAO.getFirst(day[i], period[j]), i+j, day[i], period[j]);
					AulaDAO.save(a);
				}
			}
		}
		
	}
}
