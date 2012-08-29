package com.livedoor.flow_manager.noGenerator;

import java.text.DecimalFormat;

public class NoGeneratorService implements INoGeneratorService{

	private static final DecimalFormat nf = new DecimalFormat("00000");

	private NoGeneratorDao noGeneratorDao;
	
	public void setNoGeneratorDao(NoGeneratorDao noGeneratorDao) {
		this.noGeneratorDao = noGeneratorDao;
	}
	public int getIntegerId(String idKey) throws Exception{
		return noGeneratorDao.getGeneratorIncrementId(idKey);
	}
//	
	public String getPrefixId(String prefix ,String idKey) throws Exception{

		return prefix + nf.format(getIntegerId(idKey));
	}

	
	
	public static void main(String[] args) {
		int a = 213;
		int b = 1 ;
		
		System.out.println(nf.format(a));
		System.out.println(nf.format(b));
	}
}
