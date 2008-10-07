package com.livedoor.flow_manager.test.bean;

public class TestFinalizeObject1 {
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("Object1 will gc");
	}
}
