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
import com.example.cs5610summer2019javaserverpankajBadgujar.repositories.WidgetRepository;
import com.example.cs5610summer2019javaserverpankajBadgujar.services.Direction;
import com.example.cs5610summer2019javaserverpankajBadgujar.services.WidgetService;

@RestController
@CrossOrigin("*")
public class WidgetController {
	WidgetService service = new WidgetService();

	@Autowired
	WidgetRepository widgetRepository;

	@PostMapping("/api/widgets")
	List<Widget> createWidget(@RequestBody Widget widget) {
		widgetRepository.save(widget);
		return widgetRepository.findAllWidgets();
//		service.createWidget(widget);
//		return service.findAllWidgets();
	}

	@GetMapping("/api/widgets")
	List<Widget> findAllWidgets() {
		return widgetRepository.findAllWidgets();
//		return service.findAllWidgets();
	}

	@GetMapping("/api/widgets/{wid}")
	Widget findWidgetById(@PathVariable("wid") int wid) {
		return widgetRepository.findWidgetById(wid);
//		return service.findWidgetById(wid);
	}

	@PutMapping("/api/widgets/{wid}")
	List<Widget> updateWidget(@PathVariable("wid") int wid, @RequestBody Widget widget) {
		Widget widgetToBeUpdated = widgetRepository.findWidgetById(wid);
		widgetToBeUpdated.set(widget);
		widgetRepository.save(widgetToBeUpdated);
		return widgetRepository.findAllWidgets();

//		service.updateWidget(wid, widget);
//		return service.findAllWidgets();
	}

	@DeleteMapping("/api/widgets/{wid}")
	List<Widget> deleteWidget(@PathVariable("wid") int wid) {
		widgetRepository.deleteById(wid);
		return widgetRepository.findAllWidgets();
//		service.deleteWidget(wid);
//		return service.findAllWidgets();
	}

	@PostMapping("/api/widgets/{wid}")
	List<Widget> swapWidgets(@PathVariable("wid") int wid, @RequestParam("direction") Direction direction) {

		Widget widgetToBeMoved = widgetRepository.findWidgetById(wid);
		int positionToBeChanged = widgetToBeMoved.getPosition();
		switch (direction) {
		case UP:
			Widget widgetAbove = widgetRepository.findWidgetByPosition(positionToBeChanged-1);
			widgetAbove.setPosition(positionToBeChanged);
			widgetToBeMoved.setPosition(positionToBeChanged-1);
			widgetRepository.save(widgetAbove);
			break;
			
		case DOWN:
			Widget widgetBelow = widgetRepository.findWidgetByPosition(positionToBeChanged+1);
			widgetBelow.setPosition(positionToBeChanged);
			widgetToBeMoved.setPosition(positionToBeChanged+1);
			widgetRepository.save(widgetBelow);
			break;
			
		default:
			break;
		}
		widgetRepository.save(widgetToBeMoved);
		return widgetRepository.findAllWidgets();
//		service.swapWidgets(wid, direction);
//		return service.findAllWidgets();
	}
	
}
