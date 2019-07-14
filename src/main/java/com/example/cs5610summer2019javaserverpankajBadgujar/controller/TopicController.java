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

import com.example.cs5610summer2019javaserverpankajBadgujar.models.Topic;
import com.example.cs5610summer2019javaserverpankajBadgujar.services.TopicService;

@RestController
@CrossOrigin("*")
public class TopicController {
	
	@Autowired
	TopicService topicService;
	
	@GetMapping("/api/topics")
	public List<Topic> findAllTopics(){
		return topicService.findAllTopics();
	}
	
	@GetMapping("/api/lessons/{lid}/topics")
	public List<Topic> findAllTopicsForLesson(@PathVariable("lid") int lessonId){
		return topicService.findAllTopicsForLesson(lessonId);
	}
	
	@GetMapping("/api/topics/{tid}")
	public Topic findTopicById(@PathVariable("tid") int topicId) {
		return topicService.findTopicById(topicId);
	}

	@PostMapping("/api/lessons/{lid}/topics")
	public void createTopic(@PathVariable("lid") int lessonId, @RequestBody Topic newTopic) {
		topicService.createTopic(lessonId, newTopic);
	}
	
	@DeleteMapping("/api/topics/{tid}")
	public void deleteTopic(@PathVariable("tid") int topicId) {
		topicService.deleteTopic(topicId);
	}
	
	@PutMapping("/api/topics/{tid}")
	public Topic updateTopic(@PathVariable("tid") int topicId, @RequestBody Topic newTopic) {
		return topicService.updateTopic(topicId, newTopic);
	}
	
}
