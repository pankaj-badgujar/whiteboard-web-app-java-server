package com.example.cs5610summer2019javaserverpankajBadgujar.models;

import java.util.List;

public class Lesson {
	private String id;
	private String title;
	private List<Topic> topics;
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
	public List<Topic> getTopics() {
		return topics;
	}
	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

}
