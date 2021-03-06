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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cs5610summer2019javaserverpankajBadgujar.models.Widget;
import com.example.cs5610summer2019javaserverpankajBadgujar.services.Direction;
import com.example.cs5610summer2019javaserverpankajBadgujar.services.WidgetService;
import com.example.cs5610summer2019javaserverpankajBadgujar.services.WidgetServiceUsingJavaObjects;

@RestController
@CrossOrigin("*")
public class WidgetController {
//	WidgetServiceUsingJavaObjects service = new WidgetServiceUsingJavaObjects();

	@Autowired
	WidgetService widgetService;
	
	@PostMapping("/api/topics/{tid}/widgets")
	List<Widget> createWidget(@PathVariable("tid") int topicId, @RequestBody Widget widget) {
		return widgetService.createWidget(topicId,widget);
//		service.createWidget(widget);
//		return service.findAllWidgets();
	}

	@GetMapping("/api/widgets")
	List<Widget> findAllWidgets() {
		return widgetService.findAllWidgets();
//		return service.findAllWidgets();
	}

	@GetMapping("/api/widgets/{wid}")
	Widget findWidgetById(@PathVariable("wid") int wid) {
		return widgetService.findWidgetById(wid);
//		return service.findWidgetById(wid);
	}

	@GetMapping("/api/topics/{topicId}/widgets")
	List<Widget> findAllWidgetsForTopic(@PathVariable("topicId") int topicId){
		return widgetService.findAllWidgetsForTopic(topicId);
	}
	
	@PutMapping("/api/widgets/{wid}")
	Widget updateWidget(@PathVariable("wid") int wid, @RequestBody Widget widget) {
		return widgetService.updateWidget(wid, widget);

//		service.updateWidget(wid, widget);
//		return service.findAllWidgets();
	}

	@DeleteMapping("/api/widgets/{wid}")
	void deleteWidget(@PathVariable("wid") int wid) {
		widgetService.deleteWidget(wid);
//		service.deleteWidget(wid);
//		return service.findAllWidgets();
	}

	@PostMapping("/api/widgets/{wid}")
	List<Widget> swapWidgets(@PathVariable("wid") int wid, @RequestParam("direction") Direction direction) {

		widgetService.swapWidgets(wid, direction);
		return widgetService.findAllWidgets();
//		service.swapWidgets(wid, direction);
//		return service.findAllWidgets();
	}

}
