package Lecture40;

import java.util.Comparator;

public class carPriceComparator implements Comparator<Car>{

	@Override
	public int compare(Car tcar, Car ocar) {
		return ocar.price-tcar.price;
	}

	
}
