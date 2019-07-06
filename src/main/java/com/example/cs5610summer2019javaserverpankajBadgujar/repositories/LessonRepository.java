package com.example.cs5610summer2019javaserverpankajBadgujar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.cs5610summer2019javaserverpankajBadgujar.models.Lesson;

public interface LessonRepository extends CrudRepository<Lesson, Integer> {

	@Query("select lesson from Lesson lesson")
	List<Lesson> findAllLessons();

	@Query("select lesson from Lesson lesson where lesson.module.id = :mid")
	List<Lesson> findAllLessonsByModule(@Param("mid") int moduleId);
	
	@Query("select lesson from Lesson lesson where lesson.id = :lid")
	Lesson findLessonById(@Param("lid") int lessonId);
	
}
