package com.livedoor.flow_manager.jmx.demo;

public class HelloWorld implements HelloWorldMBean {
	
	private String hello;
//	private String testAttr;
	
	public HelloWorld() {
		this.hello = "Hello World! I am a Standard MBean";
	}
	public HelloWorld(String hello) {
		this.hello = hello;
	}
	public void setHello(String hello) {
		this.hello = hello;
	}
	public void sayHello() {
//		System.out.println(hello);
	}
	
//	public void sayAttr(){
//		System.out.println(testAttr);
//	}
}

