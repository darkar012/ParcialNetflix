package view;

import controller.Control;
import processing.core.PApplet;

public class Main extends PApplet {

	private Control control;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}
	public void settings() {
		size(2000,659);
	}

	public void setup() {
		control = new Control(this);
	}

	public void draw() {
		background(0);

		for (int i = 0; i < control.getListItem().size(); i++) {
			control.getListItem().get(i).drawItem(10+(190*i));
		}
		
		textSize(30);
		text("Pulse R para ordenar por rating", 10, 500);
		text("Pulse y para ordenar por año", 10, 535);
		text("Pulse n para ordenar por nombre", 10, 565);
		text("Pulse t para ordenar por tipo", 10, 595);

	}

	public void mousePressed() {
	}

	public void keyPressed(){
		control.sortList(key);
	}
}


