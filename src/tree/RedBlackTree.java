package tree;

public class RedBlackTree {
	BRTNode root;
	
	BRTNode rotateRight(BRTNode node) {
		BRTNode p = node.left;
		BRTNode t3 = p.right;
		p.right = node;
		node.left = t3;
		node.parent = p;
		if(t3!=null) {
			t3.parent = node;
		}
		return p;
	}
	
	
	BRTNode rotateLeft(BRTNode node) {
		BRTNode p = node.right;
		BRTNode t3 = p.left;
		p.left = node;
		node.right = t3;
		node.parent = p;
		if(t3!=null) {
			t3.parent = node;
		}
		return p;
	}
}

	
	//flags to know which rotation to perform
	boolean ll = false;
	boolean lr = false;
	boolean rr = false;
	boolean rl = false;
	
	//helper function for insert()
	BRTNode insertHelp(BRTNode root, int data) {
		//true when there's red-red conflict
		boolean f = false;
		
		//recursive calls to insert according to BST properties
		if(root==null) return new BRTNode(data);
		else if(data<root.data) {
			root.left = insertHelp(root.left, data);
			root.left.parent = root;
			if(root!=this.root) {
				if(root.color=='R' && root.left.color!='R') {
					f = true;
		}}}
		else {
			root.right = insertHelp(root.right, data);
			root.right.parent = root;
			if(root!=this.root) {
				if(root.color=='R' && root.right.color=='R') {
					f = true;
		}}}}
	
	//now rotate with the help of flags
	if(this.ll) {
		
	}
}

class BRTNode {
	int data;
	BRTNode right, left, parent;
	char color;
	
	BRTNode(int data) { 
		this.data = data;
		this.color = 'R';
	}
}
