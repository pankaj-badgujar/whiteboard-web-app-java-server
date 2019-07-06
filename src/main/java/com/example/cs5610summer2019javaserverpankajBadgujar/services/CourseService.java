package com.example.cs5610summer2019javaserverpankajBadgujar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cs5610summer2019javaserverpankajBadgujar.models.Course;
import com.example.cs5610summer2019javaserverpankajBadgujar.models.Module;
import com.example.cs5610summer2019javaserverpankajBadgujar.repositories.CourseRepository;
import com.example.cs5610summer2019javaserverpankajBadgujar.repositories.LessonRepository;
import com.example.cs5610summer2019javaserverpankajBadgujar.repositories.ModuleRepository;

@Service
public class CourseService {

	@Autowired
	LessonRepository lessonRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	ModuleRepository moduleRepository;

	ModuleService moduleService;

	public List<Course> findAllCourses() {
		return courseRepository.findAllCourses();
	}

	public void createCourse(Course course) {
		courseRepository.save(course);
	}

	public Course findCourseById(int courseId) {
		return courseRepository.findCourseById(courseId);
	}

	public void deleteCourse(int courseId) {

		List<Module> modulesContained = moduleRepository.findAllModulesForCourse(courseId);
		modulesContained
				.forEach(module -> lessonRepository.deleteAll(lessonRepository.findAllLessonsByModule(module.getId())));
		moduleRepository.deleteAll(modulesContained);
		courseRepository.deleteById(courseId);
	}

	public void updateCourse(int cid, Course course) {
		Course courseToBeUpdated = courseRepository.findCourseById(cid);
		courseToBeUpdated.setTitle(course.getTitle());
		courseRepository.save(courseToBeUpdated);
	}

}
