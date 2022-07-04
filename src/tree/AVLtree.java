package tree;

public class AVLtree {
	AVLNode root;
	
	AVLtree() { root = null; }
	
	AVLtree(AVLNode root) { this.root = root; }
	
	AVLNode rotateLeft(AVLNode a) {
		AVLNode b = a.right;
		b.parent = a.parent;
		a.right = b.left;
		if(a.right!=null) {
			a.right.parent = a;
		}
		b.left = a;
		a.parent = b;
		if(b.parent!=null) {
			if(b.parent.right==a) {
				b.parent.right = b;
			}else {
				b.parent.left = b;
			}
		}setBalance(a, b);
		return b;
	}
	
	
	void insert(AVLNode node, Integer key) {
		if(root==null) root = new AVLNode(key);
		else {
			if(node.key>key) {
				insert(node.left, key);
			}else if(node.key<key) {
				insert(node.right, key);
			}else {
				throw new RuntimeException("Duplicate key!");
			}
		}
	}
	
	
	AVLNode delete(Integer delKey, AVLNode node) {
		if(node==null) return node;
		else if(node.key>delKey) delete(delKey, node.left);
		else if(node.key<delKey) delete(delKey, node.right);
		else {
			if(node.left==null || node.right==null) {
				node = node.left==null ? node.right : node.left;
			}else {
				AVLNode mostLeft = mostLeftChild(node.right);
				node.key = mostLeft.key;
				node.right = delete(node.key, node.right);
			}
		}if(node!=null) rebalance(node);
		return node;
	}
	
	
	//helper function for delete()
	AVLNode mostLeftChild(AVLNode node) {
		AVLNode mostLeft = node;
		while(mostLeft.left!=null) {
			mostLeft = mostLeft.left;
		}return mostLeft;
	}
	
	
	AVLNode rotateRight(AVLNode a) {
		AVLNode b = a.left;
		b.parent = a.parent;
		a.left = b.right;
		if(a.left!=null) {
			a.left.parent = a;
		}
		b.right = a;
		a.parent = b;
		if(b.parent!=null) {
			if(b.parent.right==a) {
				b.parent.right = b;
			}else {
				b.parent.left = b;
			}
		}setBalance(a, b);
		return b;
	}
	
	
	void setBalance(AVLNode...nodes) {
		for(AVLNode n : nodes) {
			n.balance = n.right.height - n.left.height;
		}
	}
	
	int height(AVLNode p) {
		if(p==null) return -1;
		int hLeft = p.left!=null ? p.left.height : -1;
		int hRight = p.right!=null ? p.right.height : -1;
		p.height = 1 + hLeft>hRight ? hLeft : hRight;
		return p.height;
	}
	
	
	void rebalance(AVLNode n) {
		setBalance(n);
		if(n.balance==-2) {
			if(height(n.left.left)>=height(n.left.right)) {
				n = rotateRight(n);
			}else {
				rotateLeft(n.left);
				n = rotateRight(n);
			}
		}else if(n.balance==-2) {
			if(height(n.right.right)>=height(n.right.left)) {
				rotateLeft(n);
			}else {
				rotateRight(n.right);
				n = rotateLeft(n);
			}
		}
		if(n.parent!=null) {
			rebalance(n.parent);
		}else {
			root = n;
		}
	}
}


class AVLNode {
	Integer key;
	AVLNode right, left, parent;
	int balance, height;
	
	AVLNode(Integer key) {
		this.key = key;
		this.parent = null;
		left = right = null;
		height = 0;
	}
	
	AVLNode(Integer key, AVLNode parent) {
		this.key = key;
		this.parent = parent;
		left = right = null;
		height = 0;
	}
}