package com.livedoor.flow_manager.tools;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

public class DateUtil {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	private static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
	public static String getDateStringAsYYYYMMddHHmmss(Date date){
		SimpleDateFormat sdt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdt.format(date);
	}
	
	public static String getDateStringAsYYYYMMddHHmmss(long time){
		Date d = new Date();
		d.setTime(time);
		return DateUtil.getDateStringAsYYYYMMddHHmmss(d);
	}
	
	public static Calendar getTestCalendar(String yyyyMMddStr){
		
		if(DayValidate.isDate(yyyyMMddStr)){ 
			
			int year=Integer.parseInt(yyyyMMddStr.substring(0,4));
			int month=Integer.parseInt(yyyyMMddStr.substring(4,6))-1;
			int day=Integer.parseInt(yyyyMMddStr.substring(6,8));
			return new GregorianCalendar(year,month,day);
			
		}else{ 
			return null;
		}
		
	}
	
	public static boolean isNumericDateIfExist(String date){
		
		
		if(date.length()!= 8) return false;
		
		return	Pattern.matches("^[1|2][0-9][0-9][0-9][0|1][0-9][0-3][0-9]$",date);
		
	}
	
	public static boolean isMonth(int month){
		
		return month >= 1 && month <= 12 ;
	}
	
	public static boolean isDay(int year,int month,int day) {
		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(year,month-1,1);
        return calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH)>=day;
	}
	
	public static boolean isDateYYYYMMDD(String yyyyMMdd){
		
		
		
		int year=Integer.parseInt(yyyyMMdd.substring(0,4));
		int month=Integer.parseInt(yyyyMMdd.substring(4,6));
		int day=Integer.parseInt(yyyyMMdd.substring(6,8));
		
		if ( !isMonth(month)) return false;
		
		if ( !isDay(year,month,day)) return false;
		
		return true;
	}
	
	public static boolean beforeNextSaturday(String date){
		
		return Integer.parseInt(getNextSaturday()) > Integer.parseInt(date);
	}
	
	public static String getNextSaturday(){
		Calendar cal= Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_MONTH, cal.WEEK_OF_MONTH + 1);
		cal.set(Calendar.DAY_OF_WEEK, 7);
		return sdf.format(cal.getTime());
	}
	
	
	
	public static String getCurrentSaturday() {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis((new Date()).getTime());
		cal.set(Calendar.DAY_OF_WEEK, 7);
		return sdf.format(cal.getTime());
	}

	public static String getCurrentDatetime(){
		return sdf2.format(new Date());
	}
	
	public static void main(String[] args) {
//		for (int i = 0; i < 10; i++) {
//			System.out.println(DateUtil.getNextSaturday());
//		}
		
		System.out.println(beforeNextSaturday("20120924"));
		System.out.println(beforeNextSaturday("20120929"));
		System.out.println(beforeNextSaturday("20120930"));
	}


}
