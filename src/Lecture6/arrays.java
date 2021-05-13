package Lecture6;

public class arrays {

	public static void main(String[] args) {
		int[] arr = null;//declaring an empty array
		arr= new int[5];//memory allocated in heap for 5 int(contigious)
		System.out.println(arr.length);
		System.out.println(arr);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		
		arr[0]=10;
		arr[1]=20;
		arr[2]=30;
		arr[3]=40;
		arr[5]=50;
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		 
		for( int val:arr) {//enhanced for loop
			System.out.println(val);
		}
		
		char[] carr= null;
		carr= new char[3];// 3 being size of arr with index 0,1,2
		carr[0]='a';
		carr[1]='q';
		carr[2]='y';
		
		for(char temp: carr) {
			System.out.println(temp);
		}
		
		
	}

}
