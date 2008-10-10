package com.livedoor.flow_manager.test.bean;

public class TestFinalizeMethod {

	TestFinalizeObject1 obj1 = new TestFinalizeObject1();
	TestFinalizeObject2 obj2 = new TestFinalizeObject2();
	
	public static void main(String[] args) {
		TestFinalizeObject1 obj1 = new TestFinalizeObject1();
		TestFinalizeObject2 obj2 = new TestFinalizeObject2();
		System.gc();
	}
	

}
