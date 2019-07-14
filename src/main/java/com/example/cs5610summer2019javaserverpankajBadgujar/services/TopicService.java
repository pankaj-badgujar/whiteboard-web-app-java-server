package com.example.cs5610summer2019javaserverpankajBadgujar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cs5610summer2019javaserverpankajBadgujar.models.Topic;
import com.example.cs5610summer2019javaserverpankajBadgujar.repositories.LessonRepository;
import com.example.cs5610summer2019javaserverpankajBadgujar.repositories.TopicRepository;

@Service
public class TopicService {
	
	@Autowired
	TopicRepository topicRepository;
	
	@Autowired
	LessonRepository lessonRepository;
	
	public List<Topic> findAllTopics(){
		return topicRepository.findAllTopics();
	}
	
	public List<Topic> findAllTopicsForLesson(int lessonId){
		return topicRepository.findAllTopicsForLesson(lessonId);
	}

	public Topic findTopicById(int topicId) {
		return topicRepository.findTopicById(topicId);
	}
	
	public void createTopic(int lessonId, Topic newTopic) {
		newTopic.setLesson(lessonRepository.findLessonById(lessonId));
		topicRepository.save(newTopic);
	}
	
	public void deleteTopic(int topicId) {
		topicRepository.deleteById(topicId);
	}
	
	public Topic updateTopic(int topicId, Topic newTopic) {
		 Topic topicToBeUpdated = topicRepository.findTopicById(topicId);
		 topicToBeUpdated.setTitle(newTopic.getTitle());
		 topicRepository.save(topicToBeUpdated);
		 return topicToBeUpdated;
	}
}
