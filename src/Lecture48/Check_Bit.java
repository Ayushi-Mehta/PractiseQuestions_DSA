package Lecture48;

public class Check_Bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int n=13;
      int pos=2;
      int mask = 1<<pos-1;
      if((mask&n)>0) {
    	  System.out.println(1);
      }
      else {
    	  System.out.println(0);
      }
	}

}

