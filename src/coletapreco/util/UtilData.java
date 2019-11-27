package coletapreco.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class UtilData {

	public static String getDataHora() {
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		return date;
	}
	public static String getDataHoraGmt() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		String date = sdf.format(new Date());
		return date;
	}
	
	
	public static String deslocaMeses(String data, int meses) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(data));
		c.add(Calendar.MONTH, meses);
		String dt = sdf.format(c.getTime()); 
		return dt;
	}
	
	public static String deslocaDias(String data, int dias) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(data));
		c.add(Calendar.DATE, dias);
		String dt = sdf.format(c.getTime()); 
		return dt;
	}
	public static String deslocaDias( int dias) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, dias);
		String dt = sdf.format(c.getTime()); 
		return dt;
	}
	public static String deslocaDiasFormatoDabase( int dias) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		//c.setTime(new Date());
		c.add(Calendar.DATE, dias);
		String dt = sdf.format(c.getTime()); 
		return dt;
	}
	public static String deslocaMesesFormatoDabase( int meses) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		//c.setTime(new Date());
		c.add(Calendar.MONTH, meses);
		String dt = sdf.format(c.getTime()); 
		return dt;
	}
	
	public static String getData() {
		Calendar now = Calendar.getInstance();
		String data = now.get(1) + "-" + (now.get(2) + 1) + "-" + now.get(5);
		return data;
	}

	public static String getHora() {
		Calendar cal = Calendar.getInstance();
		Date hoje = cal.getTime();
		DateFormat df = DateFormat.getTimeInstance();
		return df.format(hoje);
	}
}
