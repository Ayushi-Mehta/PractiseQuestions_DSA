package Lecture25;

public class countPallindromicSubstrings_IMPORTANT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countPalliSub_Efficient("nitin"));
	}

	// O(n^2)
	public static int countPalliSub_Efficient(String str) {
		int count = 0;
		// odd length pallindromic substrings
		for (int axis = 0; axis < str.length(); axis++) {
			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {
				if (str.charAt(axis - orbit) == str.charAt(axis + orbit)) {
					count++;
				} else {
					break;
				}
			}
		}

		// even length pallindromic substrings
		for (double axis = 0.5; axis < str.length(); axis++) {
			for (double orbit = 0.5; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {
				if (str.charAt((int) (axis - orbit)) == str.charAt((int) (axis + orbit))) {
					count++;
				} else {
					break;
				}
			}
		}
		return count;
	}

}
