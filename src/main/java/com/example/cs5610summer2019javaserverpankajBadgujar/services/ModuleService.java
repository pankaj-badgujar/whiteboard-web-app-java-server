package com.example.cs5610summer2019javaserverpankajBadgujar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cs5610summer2019javaserverpankajBadgujar.models.Course;
import com.example.cs5610summer2019javaserverpankajBadgujar.models.Module;
import com.example.cs5610summer2019javaserverpankajBadgujar.repositories.CourseRepository;
import com.example.cs5610summer2019javaserverpankajBadgujar.repositories.ModuleRepository;

@Service
public class ModuleService {

	@Autowired
	ModuleRepository moduleRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	public List<Module> findAllModules(){
		return moduleRepository.findAllModules();
	}
	
	public List<Module> findAllModulesForCourse(Integer courseId){
		return moduleRepository.findAllModulesForCourse(courseId);
	}

	public Module findModuleById( Integer moduleId) {
		return moduleRepository.findModuleById(moduleId);
	}
	

	public void addModuleToCourse(Integer courseId,  Module newModule){
		Course courseToBeAddedTo = courseRepository.findCourseById(courseId);
		newModule.setCourse(courseToBeAddedTo);
		moduleRepository.save(newModule);		
	}
	

	public List<Module> deleteModule(Integer moduleId){
		int courseId = moduleRepository.findCourseIdFromModuleId(moduleId);
		moduleRepository.deleteById(moduleId);
		return moduleRepository.findAllModulesForCourse(courseId);
	}
	
	
	public void updateModule(Integer moduleId, Module module) {
		Module moduleToBeUpdated = moduleRepository.findModuleById(moduleId);
		moduleToBeUpdated.setTitle(module.getTitle());
		moduleRepository.save(moduleToBeUpdated);
	}
}
