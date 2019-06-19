package com.example.cs5610summer2019javaserverpankajBadgujar.controller;

import java.util.List;

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

@RestController
@CrossOrigin("*")
public class WidgetController {
	WidgetService service = new WidgetService();
	
	@PostMapping("/api/widgets")
	List<Widget> createWidget (@RequestBody Widget widget){
		service.createWidget(widget);
		return service.findAllWidgets();
	}
	
	@GetMapping("/api/widgets")
	List<Widget> findAllWidgets(){
		return service.findAllWidgets();
	}
	
	@GetMapping("/api/widgets/{wid}")
	Widget findWidgetById(@PathVariable("wid") int wid) {
		return service.findWidgetById(wid);
	}
	
	@PutMapping("/api/widgets/{wid}")
	List<Widget> updateWidget(@PathVariable("wid") int wid, @RequestBody Widget widget) {
		service.updateWidget(wid, widget);
		return service.findAllWidgets();
	}
	
	@DeleteMapping("/api/widgets/{wid}")
	List<Widget> deleteWidget(@PathVariable("wid") int wid) {
		service.deleteWidget(wid);
		return service.findAllWidgets();
	}
	
	@PostMapping("/api/widgets/{wid}")
	List<Widget> swapWidgets(@PathVariable("wid") int wid, @RequestParam("direction") Direction direction){
		service.swapWidgets(wid, direction);
		return service.findAllWidgets();
	}
	

}
