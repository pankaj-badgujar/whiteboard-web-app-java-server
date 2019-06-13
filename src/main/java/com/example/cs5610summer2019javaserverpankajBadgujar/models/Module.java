package com.example.cs5610summer2019javaserverpankajBadgujar.models;

import java.util.List;

public class Module {
	private String id;
	private String title;
	private List<Lesson> lessons;

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

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
}
