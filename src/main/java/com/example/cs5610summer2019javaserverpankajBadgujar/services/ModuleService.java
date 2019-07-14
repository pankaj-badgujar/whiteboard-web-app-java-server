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
public class ModuleService {

	@Autowired
	LessonRepository lessonRepository;
	
	@Autowired
	ModuleRepository moduleRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	TopicRepository topicRepository;
		
	public List<Module> findAllModules(){
		return moduleRepository.findAllModules();
	}
	
	public List<Module> findAllModulesForCourse(Integer courseId){
		return moduleRepository.findAllModulesForCourse(courseId);
	}

	public Module findModuleById( Integer moduleId) {
		return moduleRepository.findModuleById(moduleId);
	}
	

	public void createModuleForCourse(Integer courseId,  Module newModule){
		Course courseToBeAddedTo = courseRepository.findCourseById(courseId);
		newModule.setCourse(courseToBeAddedTo);
		moduleRepository.save(newModule);		
	}
	

	public void deleteModule(Integer moduleId){
//		int courseId = moduleRepository.findCourseIdFromModuleId(moduleId);
		
		lessonRepository.findAllLessonsByModule(moduleId).forEach(lesson -> {
			topicRepository.deleteAll(topicRepository.findAllTopicsForLesson(lesson.getId()));	
			lessonRepository.delete(lesson);
		});
		moduleRepository.deleteById(moduleId);
//		return moduleRepository.findAllModulesForCourse(courseId);
	}
	
	
	public Module updateModule(Integer moduleId, Module module) {
		Module moduleToBeUpdated = moduleRepository.findModuleById(moduleId);
		moduleToBeUpdated.setTitle(module.getTitle());
		moduleRepository.save(moduleToBeUpdated);
		return moduleToBeUpdated;
	}
}
