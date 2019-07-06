package com.example.cs5610summer2019javaserverpankajBadgujar.models;

import java.util.List;

import javax.persistence.*;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="topics")
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	
	@ManyToOne
	@JsonIgnore
	private Lesson lesson;
	
	public Topic() {
		
	}
	
	public Topic(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	
	@Transient
	public String getLessonTitle() {
		return lesson.getTitle();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
