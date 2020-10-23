package model;

import java.util.Comparator;

public class MovieSerieComparator implements Comparator<Item> {

		public int compare(Item o1, Item o2) {
			return o1.getType().compareTo(o2.getType()) ;
		}
	}

