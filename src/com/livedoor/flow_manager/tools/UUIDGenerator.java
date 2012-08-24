package com.livedoor.flow_manager.tools;

import java.util.UUID;

public class UUIDGenerator {

    public UUIDGenerator() { 
    } 
    /** 
     * 获得一个UUID 
     * @return String UUID 
     */ 
    private static String getOriginalUUID(){ 
        return UUID.randomUUID().toString(); 
    }
    
    public static String getUUID(){
    	return DateUtil.getCurrentDatetime() + getOriginalUUID();
    }
    
    /** 
     * 获得指定数目的UUID 
     * @param number int 需要获得的UUID数量 
     * @return String[] UUID数组 
     */ 
    public static String[] getBatchUUID(int number){ 
        if(number < 1){ 
            return null; 
        } 
        String[] ss = new String[number]; 
        for(int i=0;i<number;i++){ 
            ss[i] = getUUID(); 
        } 
        return ss; 
    } 
    
    public static void main(String[] args){ 
        for(int i=0;i<20;i++){ 
//            System.out.println(UUIDGenerator.getOriginalUUID()); 
        } 
    } 
}
