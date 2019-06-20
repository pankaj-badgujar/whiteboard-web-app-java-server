package com.example.cs5610summer2019javaserverpankajBadgujar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.cs5610summer2019javaserverpankajBadgujar.models.Module;

public interface ModuleRepository extends CrudRepository<Module, Integer> {
	
	@Query("select module from Module module")
	List<Module> findAllModules();
	
	@Query("select module from Module module where module.id=:mid")
	Module findModuleById(@Param("mid") Integer moduleId);
	
	@Query("select module from Module module where module.course.id = :cid")
	List<Module> findAllModulesForCourse(@Param("cid") Integer courseId);
}
