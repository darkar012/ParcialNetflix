package controller;

import java.util.LinkedList;

import model.Item;
import model.Logic;
import processing.core.PApplet;

public class Control {

	private Logic logic;
	private PApplet app;

	public Control(PApplet app) {
		this.app=app;
		logic = new Logic(app);
	}

	public LinkedList<Item> getListItem() {
		return logic.getListItem();
	}

	public void sortList(char c) {
		logic.sortList(c);
	}


}
