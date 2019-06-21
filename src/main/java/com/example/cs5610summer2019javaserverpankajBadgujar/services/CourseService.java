package com.example.cs5610summer2019javaserverpankajBadgujar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cs5610summer2019javaserverpankajBadgujar.models.Course;
import com.example.cs5610summer2019javaserverpankajBadgujar.repositories.CourseRepository;
import com.example.cs5610summer2019javaserverpankajBadgujar.repositories.ModuleRepository;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;

	@Autowired
	ModuleRepository moduleRepository;
	
	
	public List<Course> findAllCourses() {
		return courseRepository.findAllCourses();
	}

	
	public void createCourse(Course course) {
		courseRepository.save(course);
	}

	
	public Course findCourseById(int courseId) {
		return courseRepository.findCourseById(courseId);
	}

	
	public void deleteCourse(int cid) {
		moduleRepository.deleteAll(moduleRepository.findAllModulesForCourse(cid));
		courseRepository.deleteById(cid);		
	}

	
	public void updateCourse(int cid, Course course) {
		Course courseToBeUpdated = courseRepository.findCourseById(cid);
		courseToBeUpdated.setTitle(course.getTitle());
		courseRepository.save(courseToBeUpdated);
	}

}
