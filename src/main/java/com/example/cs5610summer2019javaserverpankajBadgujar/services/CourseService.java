package com.example.cs5610summer2019javaserverpankajBadgujar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cs5610summer2019javaserverpankajBadgujar.models.Course;
import com.example.cs5610summer2019javaserverpankajBadgujar.models.Lesson;
import com.example.cs5610summer2019javaserverpankajBadgujar.models.Module;
import com.example.cs5610summer2019javaserverpankajBadgujar.repositories.CourseRepository;
import com.example.cs5610summer2019javaserverpankajBadgujar.repositories.LessonRepository;
import com.example.cs5610summer2019javaserverpankajBadgujar.repositories.ModuleRepository;
import com.example.cs5610summer2019javaserverpankajBadgujar.repositories.TopicRepository;

@Service
public class CourseService {

	@Autowired
	LessonRepository lessonRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	ModuleRepository moduleRepository;

	@Autowired
	TopicRepository topicRepository;

	ModuleService moduleService;

	public List<Course> findAllCourses() {
		return courseRepository.findAllCourses();
	}

	public List<Course> createCourse(Course course) {
		courseRepository.save(course);
		return this.findAllCourses();
	}

	public Course findCourseById(int courseId) {
		return courseRepository.findCourseById(courseId);
	}

	public void deleteCourse(int courseId) {

		moduleRepository.findAllModulesForCourse(courseId).forEach(module -> {
			lessonRepository.findAllLessonsByModule(module.getId()).forEach(lesson -> {
				topicRepository.deleteAll(topicRepository.findAllTopicsForLesson(lesson.getId()));
				lessonRepository.delete(lesson);
			});
			moduleRepository.delete(module);
		});
		courseRepository.deleteById(courseId);
	}

	public Course updateCourse(int cid, Course course) {
		Course courseToBeUpdated = courseRepository.findCourseById(cid);
		courseToBeUpdated.setTitle(course.getTitle());
		courseRepository.save(courseToBeUpdated);
		return courseToBeUpdated;
	}

}
