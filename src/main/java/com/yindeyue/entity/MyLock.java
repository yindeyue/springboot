package com.yindeyue.entity;

public class MyLock {
	private String name;
	private String value;

	public MyLock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public MyLock(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	@Override
	public String toString() {
		return "MyLock [name=" + name + ", value=" + value + "]";
	}

}
