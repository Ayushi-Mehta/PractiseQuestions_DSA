package Lecture48;

public class Clear_Bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=13;
		int pos=3;
		int mask=1<<pos-1;
		mask=~mask;
		n=n&mask;
		System.out.println(n);

	}

}

