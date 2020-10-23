package model;

import java.util.Comparator;

public class ReleaseYearComparator implements Comparator<Item> {

	public int compare(Item o1, Item o2) {
		return o1.getPremiereYear() - o2.getPremiereYear();
	}
}