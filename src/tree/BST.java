package tree;

public class BST {
	BSTNode root;
	
	BST() { root = null; }
	BST(int key) { root = new BSTNode(key); }
	
	
	public boolean search(Integer el) {
		boolean ans = false;
		BSTNode n = root;
		while(!ans && n!=null) {
			if(el.equals(n.key)) ans = true;
			else if(n.key>el) n = n.left;
			else n = n.right;
		}return ans;
	}
	
	public void insert(BSTNode newNode) {
		if(root==null) root = newNode;
		else {
			boolean flag = true;
			BSTNode n = root;
			
			while(flag) {
				if(n.key>newNode.key) {
					if(n.left!=null) n = n.left;
					else {
						n.left = newNode;
						newNode.parent = n;
						flag = false;
				}}
				else {
					if(n.right != null) n = n.right;
					else {
						n.right = newNode;
						newNode.parent = n;
						flag = false;
	}}}}}
	
	/*when deleting an internal node, we have 2 options: 
	put on its place the smallest node of the right subtree / the biggest node of the left subtree
	we'll go with the first */
	public BSTNode remove(BSTNode node) {
		int el = node.key;
		if(node != null) {
			if(node.key>el) {
				remove(node.left);
			}
			else if(node.key<el) {
				remove(node.right);
			}
			else { //the node to be deleted is found
				if(node.right==null && node.left==null) {//the node is a leaf
					node = null;
				}
				else if(node.right!=null && node.left==null) { //the node has only one child - right
					node = node.right;
				}
				else if(node.right==null && node.left!=null) { //the node has only one child - left
					node = node.left;
				}
				else { //the node is internal node
					if(node.right.left==null) {
						node.right.left = node.left;
						node = node.right;
					}
					else {
						BSTNode p = node.right;
						while(p.left.left!=null) {
							p = p.left;
						}
						node.key = p.left.key;
						p.left = p.left.right;
		}}}}return node;
	}
	
	
	BSTNode treeMin(BSTNode n) {
		while(n.left!=null) n = n.left;
		return n;
	}
	
	
	BSTNode treeMax(BSTNode n) {
		while(n.right!=null) n = n.right;
		return n;
	}
	
	
	BSTNode findSuccessor(BSTNode n) {
		if(n==null) return treeMax(root);
		if(n.right!=null) return treeMin(n.right);
		
		BSTNode s = n.parent;
		while(s!=null && n==s.right) {
			n = s;
			s = s.parent;
		}return s;
	}
	
	
	BSTNode findPredecessor(BSTNode n) {
		if(n==null) {
			return treeMin(root);
		}
		if(n.left!=null) return treeMax(n.left);
		
		BSTNode p = n.parent;
		while(p!=null && n==p.left) {
			n = p;
			p = p.parent;
		}
		return p;
	}
}


class BSTNode {
	Integer key;
	BSTNode right, left, parent;
	
	BSTNode(int newKey) {
		key = newKey;
		right = left = parent = null;
	}
	
	BSTNode(int newKey, BSTNode left, BSTNode right) {
		key = newKey;
		this.left = left;
		this.right = right;
	}
}
