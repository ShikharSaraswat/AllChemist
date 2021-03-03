package com.app.dto;

public class HospitalD {
	
	private String name;
	private int id;
	private String password;
	
	//Default Constr
	public HospitalD() {
		// TODO Auto-generated constructor stub
	}
	
	
	//Parameterized contr
	public HospitalD(int id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	
	// for editing details
	public HospitalD(String name, int id, String password) {
		super();
		this.name = name;
		this.id = id;
		this.password = password;
	}


	//Getters and setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
