package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Item implements Comparable<Item>{

	protected int premiereYear, rating;
	protected String name, type;
	protected boolean isMovie;
	protected PApplet app;
	protected PImage cover;

	public Item (int premiereYear, int rating, String name, String type, PApplet app, PImage cover) {
		this.premiereYear=premiereYear;
		this.rating=rating;
		this.name=name;
		this.type=type;
		this.cover=cover;
		isMovie=false;
		this.app = app;

	}

	public void drawItem(int x) {
		app.textSize(20);
		app.image(cover, x, 20,204,272);
		app.text(name, x, 320);
		app.text(premiereYear, x, 342);
		app.text(rating, x, 362);
		app.text(type, x, 382);

	}

	public int compareTo(Item nextBall) {
		return this.rating - nextBall.getRating();
	}

	public int getPremiereYear() {
		return premiereYear;
	}

	public void setPremiereYear(int premiereYear) {
		this.premiereYear = premiereYear;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public PImage getCover() {
		return cover;
	}

	public void setCover(PImage cover) {
		this.cover = cover;
	}



}
