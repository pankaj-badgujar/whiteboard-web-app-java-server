package com.example.cs5610summer2019javaserverpankajBadgujar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cs5610summer2019javaserverpankajBadgujar.models.Lesson;
import com.example.cs5610summer2019javaserverpankajBadgujar.models.Module;
import com.example.cs5610summer2019javaserverpankajBadgujar.repositories.LessonRepository;
import com.example.cs5610summer2019javaserverpankajBadgujar.repositories.ModuleRepository;
import com.example.cs5610summer2019javaserverpankajBadgujar.repositories.TopicRepository;

@Service
public class LessonService {

	@Autowired
	LessonRepository lessonRepository;
	
	@Autowired
	ModuleRepository moduleRepository;
	
	@Autowired
	TopicRepository topicRepository;
	
	public List<Lesson> findAllLessons(){
		return lessonRepository.findAllLessons();
	}

	public List<Lesson> findAllLessonsForModule(int moduleId) {
		return lessonRepository.findAllLessonsByModule(moduleId);
	}
	
	public Lesson findLessonById(int lessonId) {
		return lessonRepository.findLessonById(lessonId);
	}
	
	public void createLessonForModule(int moduleId, Lesson newLesson) {
		Module moduleToBeAddedTo = moduleRepository.findModuleById(moduleId);
		newLesson.setModule(moduleToBeAddedTo);
		lessonRepository.save(newLesson);
	}
	
	public void deleteLesson(Integer lessonId) {
		topicRepository.deleteAll(topicRepository.findAllTopicsForLesson(lessonId));
		lessonRepository.deleteById(lessonId);
	}
	
	public Lesson updateLesson(Integer lessonId,Lesson lesson) {
		Lesson lessonToBeUpdated = lessonRepository.findLessonById(lessonId);
		lessonToBeUpdated.setTitle(lesson.getTitle());
		lessonRepository.save(lessonToBeUpdated);
		return lessonToBeUpdated;
	}
}
