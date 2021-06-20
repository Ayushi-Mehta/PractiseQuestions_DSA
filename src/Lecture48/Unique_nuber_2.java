package Lecture48;

public class Unique_nuber_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {2,3,2,5,3,7,5,9};
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			ans=ans^arr[i];
		}
		int mask=(ans&(~(ans-1)));
		int a=0;
		for (int i = 0; i < arr.length; i++) {
			if((mask&arr[i])>=1) {
				a=a^arr[i];
			}
		}
		System.out.println(a);
		System.out.println(ans^a);

	}

}

