package com.app.dto;

public class HospitalDto {
	
	private String name;
	private int id;
	private String password;
	private String email;
	
	//Default Constr
	public HospitalDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	//Parameterized contr
	public HospitalDto(int id,String email, String password) {
		super();
		this.email=email;
		this.id = id;
		this.password = password;
	}

	
	// for editing details
	public HospitalDto(int id,String email, String password,String name) {
		super();
		this.email=email;
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


	public void setEmail(String email) {
		this.email = email;
	}


	public String getEmail() {
		return email;
	}


	
}
