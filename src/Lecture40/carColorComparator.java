package Lecture40;

import java.util.Comparator;

public class carColorComparator implements Comparator<Car>{

	@Override
	public int compare(Car tcar, Car ocar) {
		return tcar.color.compareTo(ocar.color);
	}

	
}
