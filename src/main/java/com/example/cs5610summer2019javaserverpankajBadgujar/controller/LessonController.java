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

import com.example.cs5610summer2019javaserverpankajBadgujar.models.Lesson;
import com.example.cs5610summer2019javaserverpankajBadgujar.services.LessonService;

@RestController
@CrossOrigin("*")
public class LessonController {
	
	@Autowired
	LessonService lessonService;
	
	@GetMapping("/api/lessons")
	public List<Lesson> findAllLessons(){
		return lessonService.findAllLessons();
	}
	
	@GetMapping("/api/modules/{mid}/lessons")
	public List<Lesson> findAllLessonsForModule(@PathVariable("mid") int moduleId){
		return lessonService.findAllLessonsForModule(moduleId);
	}
	
	@GetMapping("/api/lessons/{lid}")
	public Lesson findLessonById(@PathVariable("lid") int lessonId) {
		return lessonService.findLessonById(lessonId);
	}

	@DeleteMapping("/api/lessons/{lid}")
	public void deleteLesson(@PathVariable("lid") int lessonId){
		lessonService.deleteLesson(lessonId);		
	}
	
	@PostMapping("/api/modules/{mid}/lessons/")
	public List<Lesson> createLessonForModule(@PathVariable("mid") int moduleId, @RequestBody Lesson newLesson){
		lessonService.createLessonForModule(moduleId, newLesson);
		return lessonService.findAllLessonsForModule(moduleId);
	}
	
	@PutMapping("/api/lessons/{lid}")
	public Lesson updateLesson(@PathVariable("lid") Integer lessonId, @RequestBody Lesson lesson) {
		return lessonService.updateLesson(lessonId, lesson);
	}
}
