package com.livedoor.flow_manager.test.bean;

public class TestThread implements Runnable{
	
	private String name;
	
	private static Object obj = new Object();
	
	public TestThread(String name) {
		this.name=name;
	}
	public void run() {
		synchronized (obj) {
			
		
		for (int i = 0; i < 3; i++) {
			System.out.println(i+":"+name);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		}
		
	}
	
	public static void main(String[] args) {
		TestThread a = new TestThread("A");
		TestThread b = new TestThread("B");
		
		Thread A = new Thread(a);
		Thread B = new Thread(b);
		
		A.start();
		B.start();
	}

}
