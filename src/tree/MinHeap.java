package tree;

public class MinHeap {
	HeapNode root;
	int heapSize;
	int maxSize;
	
	MinHeap(HeapNode root, int maxSize) {
		this.root = root;
		this.maxSize = maxSize;
		heapSize = 1;
	}
	
	int heapMinimum(int arr[]) {
		return arr[0];
	}
	
	int heapExtractMin(int arr[], int heapSize) {
		int min = Integer.MAX_VALUE;
		if(heapSize>0) {
			min = arr[0];
			arr[0] = arr[heapSize-1];
			heapSize -= 1;
			minHeapify(arr, 0, heapSize);
		}return min;
	}
	
	int parent(int i) {
		return (i-1)/2;
	}
	
	int right(int i) {
		return 2*i + 2;
	}
	
	int left(int i) {
		return 2*i + 1;
	}
	
	//minHeapify() maintains minHeap property
	void minHeapify(int arr[], int v, int heapSize) {
		int smallest = -1;
		int left = left(v);
		int right = right(v);
		if(left<heapSize && arr[left]<arr[v]) {
			smallest = left;
		}else smallest = v;
		
		if(right<smallest && arr[right]<arr[smallest]) {
			smallest = right;
		}
		
		if(smallest!=v) {
			swap(arr, v, smallest);
			minHeapify(arr, smallest, heapSize);
		}
	}
	
	
	void buildMinHeap(int arr[], int heapSize) {
		for(int i=heapSize/2-1; i>=0; i--) {
			minHeapify(arr, i, heapSize);
		}
	}

	void swap(int arr[], int v, int w) {
		int temp = arr[v];
		arr[v] = arr[w];
		arr[w] = temp;
	}
	
	
	//O(nlog(n))
	void heapSort(int arr[]) {
		buildMinHeap(arr, arr.length); //O(n)
		int heapSize = arr.length;
		for(int i=heapSize-1; i>=0; i--) {
			swap(arr, 0, i);
		}
	}
	
	
	/*helper function to add a new item
	the node with key to decrease - on the i'th place, and its new key should be key
	first the func changes the value of a[i] and then swaps nodes for the min-heap property*/
	void heapDecreaseKey(int arr[], int i, int key) {
		if(key<arr[i]) {
			arr[i] = key;
		}while(i>0 && arr[i]<arr[parent(i)]) {
			swap(arr, i, parent(i));
			i = parent(i);
		}
	}
	
	
	void minHeapInsert(int arr[], int key) {
		heapSize += 1;
		arr[heapSize-1] = Integer.MAX_VALUE;
		heapDecreaseKey(arr, heapSize-1, key);
	}
}


class HeapNode {
	int key;
	HeapNode right, left, parent;
	
	HeapNode(int key) { this.key = key; }
}
