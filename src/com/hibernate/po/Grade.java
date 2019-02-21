package com.hibernate.po;

import java.util.ArrayList;
import java.util.List;

public class Grade {
	private Integer id;
	private String name;
	
	private List<Student> student = new ArrayList<Student>();
	

	public Grade() {
		super();
	}

	public Grade(String name) {
		super();
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}
	
	
}
