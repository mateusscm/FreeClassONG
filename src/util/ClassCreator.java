package util;

import database.AulaDAO;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClassCreator {
	AulaDAO dao = new AulaDAO();
	private Boolean check_date() throws Exception {
		Date date = new Date();
		return date.equals(dao.getLogDate());
	}
	public void Create() throws Exception {
		if (check_date()) {
			//verificar quais alunos e prof que nao tem turma
			//criar turma
			dao.setLogDate(new Date());
		}
		//THIS BITCH WILL DO ALL THE WORK
	}
}
