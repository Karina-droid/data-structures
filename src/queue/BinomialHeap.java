package queue;

public class BinomialHeap {
	BHNode head;
	
	BinomialHeap() { head = null; }
	
	BinomialHeap(BHNode head) { this.head = head; }
	
	Integer findMinimum() {
		if(head==null) return null;
		else {
			BHNode min = head;
			while(min.sibling!=null) {
				if(min.sibling.key<min.key) {
					min = min.sibling;
				}
			}return min.key;
	}}
	
	BHNode linkBinomialTrees(BHNode t1, BHNode t2) {
		if(t1.key<t2.key) {
			t1.child = t2;
			t2.parent = t1;
			t2.sibling = t1.child;
			return t1;
		}else {
			t2.child = t1;
			t1.parent = t2;
			t1.sibling = t2.child;
			return t2;
		}
	}
	
	BHNode binomialHeapsMerge(BinomialHeap H1, BinomialHeap H2) {
		BinomialHeap H = new BinomialHeap();
		BHNode t1, t2, tail;
		if(H1.head.degree<H2.head.degree) {
			H.head = H1.head;
			t1 = H1.head.sibling;
			t2 = H2.head;
		}else {
			H.head = H2.head;
			t1 = H2.head;
			t2 = H1.head.sibling;
		}
		BHNode t = H.head;
		while(t1!=null && t2!=null) {
			if(t1.degree<=t2.degree) {
				t.sibling = t1;
				t = t.sibling;
				t1 = t1.sibling;
			}else {
				t.sibling = t2;
				t = t.sibling;
				t2 = t2.sibling;
			}
		}if(t1==null) tail = t2;
		else tail = t1;
		while(tail!=null) {
			t.sibling = tail;
			t = t.sibling;
			tail = tail.sibling;
		}return H.head;
	}
	
	BinomialHeap binomialHeapUnion(BinomialHeap H1, BinomialHeap H2) {
		BHNode head = binomialHeapsMerge(H1, H2);
		BinomialHeap H = new BinomialHeap();
		BHNode prevX = null;
		BHNode x = head;
		BHNode nextX = head.sibling;
		if(x.degree!=nextX.degree || (nextX.sibling!=null && x.degree==nextX.sibling.degree)) {
			//if the degree of sibling is not the same || there're 3 nodes with same degree, go to the next node
			prevX = x;
			x = nextX;
			nextX = nextX.sibling;
		}
		else if(x.key<=nextX.key) {
			x.sibling = nextX.sibling;
			linkBinomialTrees(x, nextX);
		}
		else if(prevX==null) {
			H.head = nextX;
		}else {
			prevX.sibling = nextX;
			linkBinomialTrees(x, nextX);
			x = nextX;
		}nextX = x.sibling;
		return H;
	}
	
	BinomialHeap binomialHeapInsert(BinomialHeap H, BHNode x) {
		BinomialHeap H1 = new BinomialHeap();
		x.sibling = null;
		x.child = null;
		x.parent = null;
		x.degree = 0;
		H1.head = x;
		H = binomialHeapUnion(H, H1);
		return H;
	}
	
	Integer extractMin() {
		if(head==null) return null;
		BHNode min = head;
		BHNode minPrev = null; //el before min
		BHNode next = min.sibling;
		
		while(next!=null) {
			if(next.key<min.key) {
				minPrev = min;
				min = next;
			}
		}removeTreeRoot(min, minPrev);
		return min.key;
	}
	
	BHNode removeTreeRoot(BHNode root, BHNode prev) {
		//remove the root from the heap
		if(root==head) head = root.sibling;
		else prev.sibling = root.sibling;
		
		//reverse the order of root's children and make a new binomial heap
		BHNode newHead = null;
		BHNode child = root.child;
		while(child!=null) {
			BHNode next = child.sibling;
			child.sibling = newHead;
			child.parent = null;
			newHead = child;
			child = next;
		}BinomialHeap newHeap = new BinomialHeap(newHead);
		BinomialHeap heap = binomialHeapUnion(newHeap, this);
		return heap.head;
	}
	
	void swapNodes(BHNode x, BHNode y) {
		int temp = x.key;
		x.key = y.key;
		y.key = temp;
	}
	
	void binomialHeapDecreaseKey(BinomialHeap H, BHNode x, int key) {
		if(x.key<key) System.out.println("Error: the current key is less than " + key);
		x.key = key;
		BHNode y = x;
		BHNode z = x.parent;
		while(z!=null && z.key>y.key) {
			swapNodes(x, y);
			y = z;
			z = y.parent;
		}
	}
	
	void binomialHeapDelete(BinomialHeap H, BHNode x) {
		binomialHeapDecreaseKey(H, x, Integer.MIN_VALUE);
		H.extractMin();
	}
}


class BHNode {
	int key, degree;
	BHNode parent, sibling, child;
	
	BHNode(int k) {
		this.key = k;
		degree = 0;
		parent = null;
		sibling = null;
		child = null;
	}
}
