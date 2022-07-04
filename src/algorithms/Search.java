package algorithms;

public class Search {
	public static void main(String[] args) {
		int[] arr = {1, 5, 7, 23, 97, 100};
		System.out.print(binarySearch(arr, 0, arr.length-1, 23));
	}
	
	public static int binarySearch(int[] arr, int l, int r, int val) {
		int mid = (r + l)/2;
		if(arr[mid]==val) return mid;
		else if(arr[mid]>val) {
			r = mid;
			return binarySearch(arr, l, r-1, val);
		}
		else {
			l = mid;
			return binarySearch(arr, l+1, r, val);
		}
	}
	
	public static int sortWithVal(int[] arr, int val) {
		int l = 0;
		int r = arr.length - 1;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]<val) {
				
			}
		}
	}
}
