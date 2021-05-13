package Lecture40;

import java.util.Comparator;

public class carSpeedComparator implements Comparator<Car>{

	@Override
	public int compare(Car tcar, Car ocar) {
		return tcar.speed-ocar.speed;
	}

	
}
