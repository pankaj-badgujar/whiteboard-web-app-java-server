package com.example.cs5610summer2019javaserverpankajBadgujar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cs5610summer2019javaserverpankajBadgujar.models.Widget;
import com.example.cs5610summer2019javaserverpankajBadgujar.repositories.WidgetRepository;

@Service
public class WidgetService {
	
	@Autowired
	WidgetRepository widgetRepository;

	public void createWidget(Widget widget) {
		widgetRepository.save(widget);
	}
	
	
	public List<Widget> findAllWidgets() {
		return widgetRepository.findAllWidgets();
	}

	
	public Widget findWidgetById(int wid) {
		return widgetRepository.findWidgetById(wid);
	}

	
	public void updateWidget(int wid, Widget widget) {
		Widget widgetToBeUpdated = widgetRepository.findWidgetById(wid);
		widgetToBeUpdated.set(widget);
		widgetRepository.save(widgetToBeUpdated);
	}

	public void deleteWidget( int wid) {
		widgetRepository.deleteById(wid);
	}


	public void swapWidgets(int wid,Direction direction) {

		Widget widgetToBeMoved = widgetRepository.findWidgetById(wid);
		int positionToBeChanged = widgetToBeMoved.getPosition();
		int positionToStartLooking = positionToBeChanged;
		Widget widgetToBeChangedWith;
		switch (direction) {
		case UP:
			do {
				positionToStartLooking--;
				widgetToBeChangedWith = widgetRepository.findWidgetByPosition(positionToStartLooking);
			} while (widgetToBeChangedWith == null);
			widgetToBeChangedWith.setPosition(positionToBeChanged);
			widgetToBeMoved.setPosition(positionToStartLooking);
			widgetRepository.save(widgetToBeChangedWith);
			break;

		case DOWN:
			do {
				positionToStartLooking++;
				widgetToBeChangedWith = widgetRepository.findWidgetByPosition(positionToStartLooking);
			} while (widgetToBeChangedWith == null);
			widgetToBeChangedWith.setPosition(positionToBeChanged);
			widgetToBeMoved.setPosition(positionToStartLooking);
			widgetRepository.save(widgetToBeChangedWith);
			break;

		default:
			break;
		}
		widgetRepository.save(widgetToBeMoved);
	}
}
