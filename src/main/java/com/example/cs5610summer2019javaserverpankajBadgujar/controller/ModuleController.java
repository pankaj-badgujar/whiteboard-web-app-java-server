package com.example.cs5610summer2019javaserverpankajBadgujar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.cs5610summer2019javaserverpankajBadgujar.models.Module;
import com.example.cs5610summer2019javaserverpankajBadgujar.services.ModuleService;

@RestController
@CrossOrigin("*")
public class ModuleController {
	
	
	@Autowired
    ModuleService moduleService; 
	
	@GetMapping("/api/modules")
	public List<Module> findAllModules(){
		return moduleService.findAllModules();
	}
	
	@GetMapping("/api/courses/{cid}/modules")
	public List<Module> findAllModulesForCourse(@PathVariable("cid") Integer courseId){
		return moduleService.findAllModulesForCourse(courseId);
	}
	
	@GetMapping("/api/modules/{mid}")
	public Module findModuleById(@PathVariable("mid") Integer moduleId) {
		return moduleService.findModuleById(moduleId);
	}
	
	@PostMapping("/api/courses/{cid}/modules")
	public List<Module> createModuleForCourse(@PathVariable("cid") Integer courseId, @RequestBody Module newModule){
		moduleService.createModuleForCourse(courseId, newModule);
		return moduleService.findAllModulesForCourse(courseId);
	}
	
	@DeleteMapping("/api/modules/{mid}")
	public void deleteModule(@PathVariable("mid") Integer moduleId){
		/* return */ moduleService.deleteModule(moduleId);
	}
	
	@PutMapping("/api/modules/{mid}")
	public Module updateModule(@PathVariable("mid") Integer moduleId, @RequestBody Module module) {
		return moduleService.updateModule(moduleId, module);
	}

}
