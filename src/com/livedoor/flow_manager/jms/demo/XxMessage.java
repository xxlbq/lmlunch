package com.livedoor.flow_manager.jms.demo;

import java.io.Serializable;

public class XxMessage implements Serializable{
	
	private String name;
	private int age;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
