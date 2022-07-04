package stack;

public class Stack {
	final int MAX_SIZE = 10;
	Integer[] items;
	int current, size;
	
	Stack() {
		size = MAX_SIZE;
		current = 0;
		items = new Integer[size];
	}
	
	boolean push(int newVal) {
		boolean ans = true;
		if(current==size) ans = false;
		else items[current++] = newVal;
		return ans;
	}
	
	int pop() {
		Integer result = null;
		if(current>0) result = items[--current];
		return result;
	}
	
	Integer top() {
		Integer result = null;
		if(current>0) result = items[current-1];
		return result;
	}
	
	void clear() { current = 0; }
	
	boolean isEmpty() { return current==0; }
	
	int size() { return current; }
}
