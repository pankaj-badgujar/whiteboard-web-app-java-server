package com.example.cs5610summer2019javaserverpankajBadgujar.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "widgets")
public class Widget {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private WidgetType type;
	private String text;
	private String url;
	private int size;
	
	@Column(columnDefinition = "TINYINT(1)", length = 1)
	private boolean isOrdered;
	private int position;

	@ManyToOne
	@JsonIgnore
	private Topic topic;
	
	public Widget() {
		
	}
	
	@Transient
	public String getTopicTitle() {
		return topic.getTitle();
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Widget(int id, WidgetType type, String text) {

		this.id = id;
		this.type = type;
		this.text = text;
		this.setSize(1);
		this.setUrl("#");
	}


	public boolean isOrdered() {
		return isOrdered;
	}

	public void setOrdered(boolean isOrdered) {
		this.isOrdered = isOrdered;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public WidgetType getType() {
		return type;
	}

	public void setType(WidgetType type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}


	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void set(Widget newWidget) {
		this.setOrdered(newWidget.isOrdered());
		this.setType(newWidget.getType());
		this.setSize(newWidget.getSize());
		this.setText(newWidget.getText());
		this.setUrl(newWidget.getUrl());
		this.setPosition(newWidget.getPosition());
		
	}
}
