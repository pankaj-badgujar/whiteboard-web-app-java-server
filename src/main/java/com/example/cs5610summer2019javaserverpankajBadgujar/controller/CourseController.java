package com.example.cs5610summer2019javaserverpankajBadgujar.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cs5610summer2019javaserverpankajBadgujar.models.Course;
import com.example.cs5610summer2019javaserverpankajBadgujar.services.CourseService;

@RestController
@CrossOrigin("*")
public class CourseController {

	CourseService service = new CourseService();

	@GetMapping("/api/courses")
	List<Course> findAllCourses() {
		return service.findAllCourses();
	}

	@PostMapping("/api/courses")
	List<Course> createCourse(@RequestBody Course course) {
		service.createCourse(course);
		return service.findAllCourses();
	}

	@GetMapping("/api/courses/{cid}")
	Course findCourseById(@PathVariable("cid") String courseId) {
		return service.findCourseById(courseId);
	}

	@DeleteMapping("/api/courses/{cid}")
	List<Course> deleteCourse(@PathVariable("cid") String cid){
		service.deleteCourse(cid);
		return service.findAllCourses();
	}
	
	@PutMapping("/api/courses/{cid}")
	List<Course> updateCourse(@PathVariable("cid") String cid, @RequestBody Course course){
		service.updateCourse(cid, course);
		return service.findAllCourses();
	}
}









