package model;

import java.util.Collections;
import java.util.LinkedList;
import processing.core.PApplet;
import processing.core.PImage;

public class Logic {

	private String [] arrayNetflix;
	private LinkedList<Item> listItem;
	private PApplet app;
	private PImage image;
	
	private MovieSerieComparator MSC;
	private NameComparator NC;
	private ReleaseYearComparator PYC;
	
	private String[] byName, byYear, byType, byRating;

	public Logic(PApplet app) {
		this.app = app;
		MSC = new MovieSerieComparator ();
		NC = new  NameComparator() ;
		PYC = new ReleaseYearComparator();
		byRating = new String [7];
		byName = new String [7];
		byYear = new String [7];
		byType = new String [7];
		
		arrayNetflix = app.loadStrings ("../resources/netflix.txt");
		listItem = new LinkedList<Item>();

		for (int i = 0; i < arrayNetflix.length; i++) {
			String[] lineString = arrayNetflix[i].split(",");

			String name = lineString[0];

			String imageName = name.toLowerCase().replaceAll(" ", "");
			image = app.loadImage("../resources/"+ imageName + "" + ".jpg");

			int premiereYear = Integer.parseInt(lineString[1]);
			int rating = Integer.parseInt(lineString[2]);

			String type = lineString[3];

			addElementList(new Item (premiereYear,rating, name, type, app, image));
		}
	}

	public void addElementList(Item obj) {
		listItem.add(obj);		
	}

	public void sortList(char c) {
		switch (c) {
		case 'r':
			Collections.sort(listItem);
		
			for (int i = 0; i < listItem.size(); i++) {

				String name = listItem.get(i).getName();
				String type = listItem.get(i).getType();
				String year = Integer.toString(listItem.get(i).getPremiereYear());
				String rating = Integer.toString(listItem.get(i).getRating());
				

				String line = name + ", " + year + ", " + rating + ", " + type;
				
				byRating[i] = line;
			}
			this.app.saveStrings("byRating.txt", byRating);
			
			break;
		case 'm':
			Collections.sort(listItem, MSC);
			
			for (int i = 0; i < listItem.size(); i++) {

				String name = listItem.get(i).getName();
				String year = Integer.toString(listItem.get(i).getPremiereYear());
				String rating = Integer.toString(listItem.get(i).getRating());
				String type = (listItem.get(i).getType());

				String line = name + ", " + year + ", " + rating + ", " + type;
				
				byType[i] = line;
			}
			app.saveStrings("byType.txt", byType);
			break;
		case 'n':
			Collections.sort(listItem, NC);
			for (int i = 0; i < listItem.size(); i++) {

				String name = listItem.get(i).getName();
				String year = Integer.toString(listItem.get(i).getPremiereYear());
				String rating = Integer.toString(listItem.get(i).getRating());
				String type = (listItem.get(i).getType());

				String line = name + ", " + year + ", " + rating + ", " + type;
				
				byName[i] = line;
			}
			app.saveStrings("byName.txt", byName);
			break;
		case 'y':
			Collections.sort(listItem, PYC);
			for (int i = 0; i < listItem.size(); i++) {

				String name = listItem.get(i).getName();
				String year = Integer.toString(listItem.get(i).getPremiereYear());
				String rating = Integer.toString(listItem.get(i).getRating());
				String type = (listItem.get(i).getType());

				String line = name + ", " + year + ", " + rating + ", " + type;
				
				byYear[i] = line;
			}
			app.saveStrings("byPremiereYear.txt", byYear);
		default:
			break;

		}
	}

	public LinkedList<Item> getListItem() {
		return listItem;
	}


	public void setListItem(LinkedList<Item> listItem) {
		this.listItem = listItem;
	}



}
