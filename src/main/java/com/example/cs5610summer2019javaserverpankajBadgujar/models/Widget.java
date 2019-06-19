package com.example.cs5610summer2019javaserverpankajBadgujar.models;

import javax.persistence.*;

@Entity
@Table(name="widgets")
public class Widget {
	
	private String name;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private WidgetType type;
	private String text;
	private String url;
	private int size;
	private int width;
	private int height;
	private String cssClass;
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
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getCssClass() {
		return cssClass;
	}
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getListType() {
		return listType;
	}

	public void setListType(String listType) {
		this.listType = listType;
	}
	

}
