package Lecture17;

public class pallindromePartition {

	public static void main(String[] args) {
		palliPart("nitin", "");
	}

	public static void palliPart(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 1; i <= ques.length(); i++) {
			String part = ques.substring(0, i);
			String roq = ques.substring(i);

			if(isPalli(part)) {
			palliPart(roq, ans + part + "|");
			}
		}
	}
	public static boolean isPalli(String str) {
		int i=0;
		int j=str.length()-1;
		while(i<j) {
			if(str.charAt(i)!=str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
