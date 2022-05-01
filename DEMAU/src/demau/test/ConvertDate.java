package demau.test;

public class ConvertDate {
	public static java.sql.Date convertUtilToSqlDate (java.util.Date utilDate){
		return new java.sql.Date(utilDate.getTime());
	}
	
	public static java.util.Date convertSqlToUtilDate(java.sql.Date sqlDate){
		return new java.util.Date(sqlDate.getTime());
	}
}
