package SearchingAndSorting;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {9,8,7,6,5,4,3,2,1};
		selectionsort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public static void selectionsort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			int min=i;
			for(int j=i+1;j<=arr.length-1;j++) {
				if(arr[j]<arr[min]) {
					min=j;
				}
			}
			int temp=arr[min];
			arr[min]=arr[i];
			arr[i]=temp;
		}
	}
}
