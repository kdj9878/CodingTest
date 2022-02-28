import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BubbleSort {
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,6,2,9,3};
		
//		for(int i = 1; i < arr.length; i++) {
//			for(int j = 0; j < arr.length - i; j++) {
//				if(arr[j] > arr[j+1]) {
//					swap(arr, j, j+1);
//				}
//			}
//		}
		
		for(int i = 0; i < arr.length -1; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					swap(arr, i, j);
				}
			}
		}
		
		for(int v : arr) System.out.println(v);
	}

}
