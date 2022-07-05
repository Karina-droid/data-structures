package algorithms;

public class BubbleSort {
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public void sort(int[] arr) {
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
	
	
	public void insertionSort(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			int key = arr[i];
			int j = i-1;
			
			//move els arr[0..i-1] that are greater than key one pos ahead of their cur pos
			while(j>=0 && arr[j]>key) {
				arr[j+1] = arr[j];
				j--;
			}arr[j+1] = key;
		}
	}
	
	
	public void merge(int[] arr, int l, int m, int r) {
		//find sizes of the two arrays
		int s1 = m - l + 1;
		int s2 = r - m;
		
		//create temp arrays, copy data to them
		int[] L = new int[s1];
		for(int i=0; i<s1; i++) {
			L[i] = arr[l+i];
		}
		int[] R = new int[s2];
		for(int i=0; i<s2; i++) {
			R[i] = arr[l+m+i];
		}
		
		//merge the temp arrays
		int i = 0;
		int j = 0;
		int k = l;
		while(i<s1 && j<s2) {
			if(L[i]<R[j]) {
				arr[k] = L[i];
				i++;
			}else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		//copy remaining els of L[] and R[] if any
		while(i<s1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while(j<s2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	
	
	public void sort(int[] arr, int l, int r) {
		if(l<r) {
			int m = l + (r - l)/2;
			sort(arr, l, m);
			sort(arr, m+1, r);
			merge(arr, l, m, r);
		}
	}
	
	
	public int partition(int[] arr, int low, int high) {
		int pivot = low;
		low = low + 1;
		while(low<high) {
			if(arr[low]<=pivot) low++;
			else if(arr[high]>pivot) high--;
			else swap(arr, low, high);
		}swap(arr, high, pivot);
		return high;
	}
	
	
	public void quickSort(int[] arr, int low, int high) {
		int pivot = partition(arr, low, high);
		quickSort(arr, low, pivot-1);
		quickSort(arr, pivot+1, high);
	}
}
