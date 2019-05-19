package util;

import java.util.Date;

public class DateUtil {
	
	public static java.sql.Date convertJavaDateToSQL(Date date) { 
		return new java.sql.Date(date.getTime());
	}


}
