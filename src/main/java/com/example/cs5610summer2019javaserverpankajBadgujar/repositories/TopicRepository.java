package com.example.cs5610summer2019javaserverpankajBadgujar.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.cs5610summer2019javaserverpankajBadgujar.models.Topic;

public interface TopicRepository extends CrudRepository<Topic, Integer> {
	
	@Query("select topic from Topic topic")
	List<Topic> findAllTopics();
	
	@Query("select topic from Topic topic where topic.lesson.id = :lid")
	List<Topic> findAllTopicsForLesson(@Param("lid") int lessonId);

	@Query("select topic from Topic topic where topic.id = :tid")
	Topic findTopicById(@Param("tid") int topicId);
	

}
