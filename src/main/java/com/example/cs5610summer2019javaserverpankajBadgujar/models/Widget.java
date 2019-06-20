package com.example.cs5610summer2019javaserverpankajBadgujar.models;

import javax.persistence.*;

@Entity
@Table(name = "widgets")
public class Widget {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private WidgetType type;
	private String text;
	private String url;
	private int size;
	private String listType;

	public Widget() {
		super();
	}

	public Widget(int id, String name, WidgetType type, String text) {

		this.id = id;
		this.name = name;
		this.type = type;
		this.text = text;
		this.setListType("unordered");
		this.setSize(1);
		this.setUrl("#");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getListType() {
		return listType;
	}

	public void setListType(String listType) {
		this.listType = listType;
	}

	public void set(Widget newWidget) {
		this.setListType(newWidget.getListType());
		this.setType(newWidget.getType());
		this.setName(newWidget.getName());
		this.setSize(newWidget.getSize());
		this.setText(newWidget.getText());
		this.setUrl(newWidget.getUrl());
		
	}
}
