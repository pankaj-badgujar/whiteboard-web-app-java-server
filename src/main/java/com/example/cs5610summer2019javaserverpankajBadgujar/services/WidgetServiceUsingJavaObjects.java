package com.example.cs5610summer2019javaserverpankajBadgujar.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.cs5610summer2019javaserverpankajBadgujar.models.Widget;
import com.example.cs5610summer2019javaserverpankajBadgujar.models.WidgetType;

public class WidgetServiceUsingJavaObjects {

	private static List<Widget> widgets = new ArrayList<Widget>();

//	static {
//		widgets.add(new Widget("1", "Widget 1", WidgetType.HEADING, "Heading Text"));
//		widgets.add(new Widget("2", "Widget 2", WidgetType.PARAGRAPH, "Paragraph Text"));
//		widgets.add(new Widget("3", "Widget 3", WidgetType.LIST,
//				"Enter\none\nlist\nper\nitem"));
//		widgets.add(new Widget("4", "Widget 4", WidgetType.LINK, "Link Text"));
//		widgets.add(new Widget("5", "Widget 5", WidgetType.IMAGE, null));
//	}

	public void createWidget(Widget widget) {
		widgets.add(widget);
	}

	public List<Widget> findAllWidgets() {
		return widgets;
	}

	public Widget findWidgetById(int wid) {
		for (Widget w : widgets) {
			if (w.getId() == (wid)) {
				return w;
			}
		}
		return null;
	}

	public void updateWidget(int wid, Widget widget) {
		for (Widget w : widgets) {
			if (w.getId() == (wid)) {
				w.setSize(widget.getSize());
				w.setText(widget.getText());
				w.setName(widget.getName());
				w.setUrl(widget.getUrl());
				w.setType(widget.getType());
				w.setListType(widget.getListType());
			}
		}

	}

	public void deleteWidget(int wid) {
		widgets = widgets.stream().filter(widget -> widget.getId() != wid).collect(Collectors.toList());
	}

	private int findIndexByWidgetId(int widgetId) {
		for (Widget w : widgets) {
			if (w.getId() == (widgetId)) {
				return widgets.indexOf(w);
			}
		}
		return 0;
	}

	public void swapWidgets(int widgetId, Direction direction) {
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


