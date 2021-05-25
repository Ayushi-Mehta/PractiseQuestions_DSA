package Lecture43;

public class SegmentTreeMax implements SegmentTreeInterface{

	@Override
	public int operation(int v1, int v2) {
		return Math.max(v1, v2) ;
	}

	@Override
	public int defaultValue() {
		return Integer.MIN_VALUE ;
	}

}