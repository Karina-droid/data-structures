package queue;

public class Queue {
	int front, tail, size;
	int n;
	Integer[] data;
	
	Queue(int n) {
		size = tail = front;
		this.n = n;
		data = new Integer[n];
	}
	
	boolean isEmpty() { return size==0; }
	
	boolean enqueue(Integer newValue) {
		boolean ans;
		if(size==n) {
			ans = false;
			System.out.println("The queue is full");
		}else {
			data[tail] = newValue;
			tail = (tail+1)%n;
			size += 1;
			ans = true;
		}return ans;
	}
	
	Integer dequeue() {
		Integer ans;
		if(isEmpty()) {
			ans = null;
			System.out.println("The queue is empty");
		}else {
			ans = data[front];
			front = (front+1)%n;
			size -= 1;
		}return ans;
	}
	
	Integer peek() {
		Integer ans;
		if(isEmpty()) {
			ans = null;
			System.out.println("The queue is empty");
		}else ans = data[front];
		return ans;
	}
	
	boolean contains(Integer value) {
		boolean ans = false;
		for(int i=0; i<size; i++) {
			if(data[(front+i)%n]==value) {
				ans = true;
			}
		}return ans;
	}
	
	int size() { return size; }
	
	void clear	() { size = front = tail = 0; }
}
