package com.example.cs5610summer2019javaserverpankajBadgujar.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="lessons")
public class Lesson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	
	@OneToMany(mappedBy = "lesson")
	private List<Topic> topics;
	
	@ManyToOne
	@JsonIgnore
	private Module module;
	
	public Lesson() {
		
	}
	
	public Lesson(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	
	@Transient
	public String getModuleTitle() {
		return module.getTitle();
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

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

}
