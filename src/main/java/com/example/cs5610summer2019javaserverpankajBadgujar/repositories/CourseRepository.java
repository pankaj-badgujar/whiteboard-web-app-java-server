package com.example.cs5610summer2019javaserverpankajBadgujar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.cs5610summer2019javaserverpankajBadgujar.models.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {

	@Query("select course from Course course")
	List<Course> findAllCourses();
	
	@Query("select course from Course course where course.id = :cid")
	Course findCourseById(@Param("cid") Integer id);
}
