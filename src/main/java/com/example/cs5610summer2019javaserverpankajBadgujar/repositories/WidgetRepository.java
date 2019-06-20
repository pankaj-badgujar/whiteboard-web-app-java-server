package com.example.cs5610summer2019javaserverpankajBadgujar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.cs5610summer2019javaserverpankajBadgujar.models.Widget;

public interface WidgetRepository extends CrudRepository<Widget, Integer> {

	@Query("select widget from Widget widget order by widget.position")
	List<Widget> findAllWidgets();
	
	@Query("select widget from Widget widget where widget.id = :wid")
	Widget findWidgetById(@Param("wid") Integer widgetId);
	
	@Query("select widget from Widget widget where widget.position =:pos")
	Widget findWidgetByPosition(@Param("pos") Integer position);
}
