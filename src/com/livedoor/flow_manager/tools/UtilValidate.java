package com.livedoor.flow_manager.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.livedoor.flow_manager.user.beans.User;

/**
 * @author lbq
 *
 */
public class UtilValidate {
        
	
        

        
        
        public static boolean isDigit(String param) {
            return CharacterValidator.isDigit(param);
        }
        
        public static boolean isNotDigit(String param) {
            return !(CharacterValidator.isDigit(param));
        }

        
   
        public static boolean digitCheck(String param) {
            if (UtilValidate.isNotDigit(param)) return true ;
            char paramArray[] = param.toCharArray();
            if(paramArray[0] == '0') return true ;
            return false;
        }

        
        public static boolean isFull(String value){
            return CharacterValidator.isFull(value);
        }
        
        public static boolean isHalf(String value) {
           return CharacterValidator.isHalf(value);
        }        
        
        
        public static boolean  isEquimultiple(double param1, double param2){
        	param1 = (long)param1;
        	param2 = (long)param2;
        	return param1 != 0 && param1 % param2 == 0 ? true : false;
        }
        
               
        public static boolean  isNotEquimultiple(double param1, double param2){
        	return !(isEquimultiple(param1, param2));
        }        
        
        
        public static boolean isLengthLessThan(String param, int n){
        	return param.length() < n ? true : false; 
        }
        
        
        public static boolean isLengthLessEqual(String param, int n){
        	return param.length() <= n ? true: false;
        }
        
        
        public static boolean isLengthGreaterThan(String param, int n){
        	return param.length() > n ? true : false;
        }
        
         
        public static boolean isLengthGreaterEqual(String param, int n){
        	return param.length() >= n ? true : false;
        }
        
        
        public static boolean isLengthEqual(String param, int n){
        	return param.length() == n ? true : false;
        }
        
        
        public static boolean isLenghtNotEqual(String param, int n){
        	return !(isLengthEqual(param, n));
        }    
        
    	
    	public static boolean negativeCheck(String d) {
    		try{
    			double i = Double.parseDouble(d);
    			return ( i < 0 ) ? true : false;
    		}
    		catch(NumberFormatException e ){
    			return false;
    		}
    	}
        
    	
    	public static boolean decimalCheck(String d) {
    		String reg = "([\\d]*)\\.([\\d]*)";
    		Pattern p = Pattern.compile(reg);
    		Matcher m = p.matcher(d);
    		return m.matches();
    	}
    	
    	
    	public static boolean intNegativeCheck(String d) {
    		String reg = "^[-][\\d]*";
    		Pattern p = Pattern.compile(reg);
    		Matcher m = p.matcher(d);
    		return m.matches();
    	}
    	
    	
//    	public static boolean numberCheck(String d) {
//    		try {
//    			double i = Double.parseDouble(d);
//    			return true;
//    		} catch (NumberFormatException e) {
//    			return false;
//    		}
//    	}
    	
    	public static boolean isBeginOfLine(String src,String begin){
    		Pattern p = Pattern.compile(begin,Pattern.CASE_INSENSITIVE|Pattern.MULTILINE);
    		Matcher m = p.matcher(src);

//    		m.find();
//    		System.out.println(m.group());
    		return m.find();
    	}

		public static boolean isNotValidUser(User user) {
//			logger.info("AccountNonExpiredInt:"+user.getAccountNonExpiredInt());
			return user.getAccountNonExpiredInt() == 1 ? false : true;
		}
    	
//    	public static void main(String[] args) {
//    	
//    		System.out.println(UtilValidate.isBeginOfLine(Constants.SPR_REGEX_TEST_STRING,"^java")); 
//		}
}
