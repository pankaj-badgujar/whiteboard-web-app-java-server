package com.example.cs5610summer2019javaserverpankajBadgujar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cs5610summer2019javaserverpankajBadgujar.models.Course;
import com.example.cs5610summer2019javaserverpankajBadgujar.models.Module;
import com.example.cs5610summer2019javaserverpankajBadgujar.repositories.CourseRepository;
import com.example.cs5610summer2019javaserverpankajBadgujar.repositories.ModuleRepository;

@RestController
@CrossOrigin("*")
public class ModuleController {
	
	@Autowired
	ModuleRepository moduleRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@GetMapping("/api/modules")
	public List<Module> findAllModules(){
		return moduleRepository.findAllModules();
	}
	
	@GetMapping("/api/courses/{cid}/modules")
	public List<Module> findAllModulesForCourse(@PathVariable("cid") Integer courseId){
		return moduleRepository.findAllModulesForCourse(courseId);
	}
	
	@GetMapping("/api/modules/{mid}")
	public Module findModuleById(@PathVariable("mid") Integer moduleId) {
		return moduleRepository.findModuleById(moduleId);
	}
	
	@PostMapping("/api/courses/{cid}/modules")
	public List<Module> addModuleToCourse(@PathVariable("cid") Integer courseId, @RequestBody Module newModule){
		Course courseToBeAddedTo = courseRepository.findCourseById(courseId);
		newModule.setCourse(courseToBeAddedTo);
		moduleRepository.save(newModule);
		return moduleRepository.findAllModulesForCourse(courseId);
		
	}
	
	

}
