package Lecture43;

public class SegmentTreeProduct implements SegmentTreeInterface {

	@Override
	public int operation(int v1, int v2) {
		return v1 * v2;
	}

	@Override
	public int defaultValue() {
		return 1;
	}

}