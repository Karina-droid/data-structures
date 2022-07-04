package algorithms;

public class Sort {
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public void bubbleSort(int[] arr) {
		int n = arr.length - 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-i; j++) {
				if(arr[j]>arr[j+1]) {
					swap(arr, j, j+1);
	}}}}
	
	
	public void selectionSort(int[] arr) {
		//one by one move boundary of unsorted array
		int n = arr.length;
		for(int i=0; i<n-1; i++) {
			int min_idx = i;
			
			//find the minimum element in unsorted array
			for(int j=i+1; j<n; j++) {
				if(arr[j]<arr[min_idx]) {
					j = min_idx;
				}
			}
			//swap the found minimum with the first element
			swap(arr, i, min_idx);
	}}
}
