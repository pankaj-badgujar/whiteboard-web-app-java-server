package com.example.cs5610summer2019javaserverpankajBadgujar.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.cs5610summer2019javaserverpankajBadgujar.models.Course;

public class CourseServiceUsingJavaObjects {

	private static List<Course> courses = new ArrayList<Course>();
	
	static {
		courses.add(new Course(1,"CS 5600"));
		courses.add(new Course(2,"CS 5800"));
		courses.add(new Course(3,"CS 5010"));
	}

	public void createCourse(Course course) {
		courses.add(course);
	}

	public List<Course> findAllCourses() {
		return courses;
	}

	public Course findCourseById(int courseId) {
		for (Course c : courses) {
			if (c.getId() == courseId) {
				return c;
			}
		}
		return null;
	}

	public void deleteCourse(int courseId) {
		courses = courses
				.stream()
				.filter(course -> course.getId() != courseId)
				.collect(Collectors.toList());
	}
	
	public void updateCourse(int courseId, Course course) {
		for(Course c : courses) {
			if(c.getId() == courseId) {
				c.setTitle(course.getTitle());
			}
		}
	}

}
