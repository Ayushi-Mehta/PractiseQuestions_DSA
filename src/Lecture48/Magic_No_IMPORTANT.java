package Lecture48;

public class Magic_No_IMPORTANT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nth_Magic_number(6));

	}
	public static int nth_Magic_number(int n) {
		int  ans=0;
		int mult=5;
		while(n!=0) {
			if((n&1)==1) {
				ans+=mult;
			}
			mult*=5;
			n>>=1;
		}
		return ans;
	}

}