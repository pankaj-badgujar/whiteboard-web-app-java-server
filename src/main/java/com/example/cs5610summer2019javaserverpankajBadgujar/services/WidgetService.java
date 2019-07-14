package com.example.cs5610summer2019javaserverpankajBadgujar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cs5610summer2019javaserverpankajBadgujar.models.Widget;
import com.example.cs5610summer2019javaserverpankajBadgujar.repositories.TopicRepository;
import com.example.cs5610summer2019javaserverpankajBadgujar.repositories.WidgetRepository;

@Service
public class WidgetService {
	
	@Autowired
	WidgetRepository widgetRepository;
	
	@Autowired
	TopicRepository topicRepository;
	
	public List<Widget> createWidget(int topicId, Widget widget) {
		widget.setTopic(topicRepository.findTopicById(topicId));
		widgetRepository.save(widget);
		return this.findAllWidgetsForTopic(topicId);
	}
	
	
	public List<Widget> findAllWidgets() {
		return widgetRepository.findAllWidgets();
	}

	
	public Widget findWidgetById(int wid) {
		return widgetRepository.findWidgetById(wid);
	}

	public List<Widget> findAllWidgetsForTopic(int topicId){
		return widgetRepository.findAllWidgetsForTopic(topicId);
	}
	
	public Widget updateWidget(int wid, Widget widget) {
		Widget widgetToBeUpdated = widgetRepository.findWidgetById(wid);
		widgetToBeUpdated.set(widget);
		widgetRepository.save(widgetToBeUpdated);
		return widgetToBeUpdated;
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
