package tree;

import java.util.Random;

public class BinaryTree {
	Node root;
	
	public BinaryTree() { root = null; }
	
	public BinaryTree(int key) { root = new Node(key); }
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		System.out.print(tree.diameter());
	}
	
	
	//root-left-right
	void printPreorder(Node node) {
		if(node==null) return;
		System.out.print(node.key + " ");
		printPreorder(node.left);
		printPreorder(node.right);
	}
	
	
	//left-root-right
	void printInorder(Node node) {
		
	}
	
	
	int countLeaves(Node node) {
		if(node==null) return 0;
		else if(node.right==null && node.left==null) return 1;
		else return countLeaves(node.right) + countLeaves(node.left);
	}
	
	
	boolean contains(int key, Node node) {
		boolean ans = false;
		if(node!=null) {
			ans = (node.key==key) || (contains(key, node.left)) || (contains(key, node.right));
		}return ans;
	}
	
	
	int nodeHeight(Node node) {
		int h = 0;
		if(node != null) {
			int leftHeight = nodeHeight(node.left);
			int rightHeight = nodeHeight(node.right);
			h = Math.max(leftHeight, rightHeight) + 1;
		}
		return h;
	}
	
	
	void add(int key) { root = add(key, root); }
	
	Node add(int key, Node node) {
		Random generator = new Random();
		if(node != null) {
			double rand = generator.nextDouble();
			if(rand<0.5) {
				node.left = add(key, node.left);
				return node;
			}
			else {
				node.right = add(key, node.right);
				return node;
			}
		}return new Node(key);
	}
	
	
	//find height of the tree
	static int treeHeight(Node node) {
		if (node==null) return 0;
		//return 1 + height of the max subtrees
		
		return (1 + Math.max(treeHeight(node.left), treeHeight(node.right)));
	}
	
	
	int diameter(Node root) {
		//base case if root==null
		if(root==null) return 0;
		
		return (1 + Math.max(treeHeight(root.left), treeHeight(root.right)));
	}
	
	//a wrapper for diameter(root), called once from the main
	int diameter() { return diameter(root); }
}

class Node {
	int key;
	Node left, right;
	
	public Node(int item) {
		key = item;
		left = right = null;
	}
}
