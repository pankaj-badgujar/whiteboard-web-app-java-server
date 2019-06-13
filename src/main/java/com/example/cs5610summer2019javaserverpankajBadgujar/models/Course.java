package com.example.cs5610summer2019javaserverpankajBadgujar.models;

import java.util.ArrayList;
import java.util.List;

public class Course {

	private String id;
	private String title;
	private List<Module> modules;
	
	public Course(String id, String title) {
		super();
		this.id = id;
		this.title = title;
		this.modules = new ArrayList<Module>();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
