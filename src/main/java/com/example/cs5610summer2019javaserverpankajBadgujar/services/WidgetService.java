package com.example.cs5610summer2019javaserverpankajBadgujar.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.cs5610summer2019javaserverpankajBadgujar.models.Widget;
import com.example.cs5610summer2019javaserverpankajBadgujar.models.WidgetType;

public class WidgetService {

	private static List<Widget> widgets = new ArrayList<Widget>();

	static {
		widgets.add(new Widget("1", "Widget 1", WidgetType.HEADING, "Heading Text"));
		widgets.add(new Widget("2", "Widget 2", WidgetType.PARAGRAPH, "Paragraph Text"));
		widgets.add(new Widget("3", "Widget 3", WidgetType.LIST,
				"Enter\none\nlist\nper\nitem"));
		widgets.add(new Widget("4", "Widget 4", WidgetType.LINK, "Link Text"));
		widgets.add(new Widget("5", "Widget 5", WidgetType.IMAGE, null));
	}

	public void createWidget(Widget widget) {
		widgets.add(widget);
	}

	public List<Widget> findAllWidgets() {
		return widgets;
	}

	public Widget findWidgetById(String wid) {
		for (Widget w : widgets) {
			if (w.getId().equals(wid)) {
				return w;
			}
		}
		return null;
	}

	public void updateWidget(String wid, Widget widget) {
		for (Widget w : widgets) {
			if (w.getId().equals(wid)) {
				w.setSize(widget.getSize());
				w.setText(widget.getText());
				w.setName(widget.getName());
				w.setWidth(widget.getWidth());
				w.setHeight(widget.getHeight());
				w.setCssClass(widget.getCssClass());
				w.setUrl(widget.getUrl());
				w.setType(widget.getType());
				w.setListType(widget.getListType());
			}
		}

	}

	public void deleteWidget(String wid) {
		widgets = widgets.stream().filter(widget -> !widget.getId().equals(wid)).collect(Collectors.toList());
	}

	private int findIndexByWidgetId(String widgetId) {
		for (Widget w : widgets) {
			if (w.getId().equals(widgetId)) {
				return widgets.indexOf(w);
			}
		}
		return 0;
	}

	public void swapWidgets(String widgetId, Direction direction) {
		int index = this.findIndexByWidgetId(widgetId);
		Widget temp = widgets.get(index);
		switch (direction) {
		case UP:
			widgets.set(index, widgets.get(index - 1));
			widgets.set(index - 1, temp);
			break;
		case DOWN:
			widgets.set(index, widgets.get(index + 1));
			widgets.set(index + 1, temp);
			break;
		default:
			break;
		}
	}
}


