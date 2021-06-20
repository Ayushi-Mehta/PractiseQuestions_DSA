package Lecture48;

public class Count_Set_bit {
	public static void main(String[] args) {
      System.out.println(CountSetBit(13));
      System.out.println(FastCountSetBit(13));
	}
	public static int CountSetBit(int n) {
		int count=0;
		while(n!=0) {
			if((n&1)==1) {
				count++;
			}
			n>>=1;// n= n>>1
		}
		return count;
	}
	public static int FastCountSetBit(int n) {
		int count=0;
		while(n!=0) {
			count++;
			n=(n&(n-1));
		}
		return count;
	}
}

