package union_find;

public class DisjointSet {
	Node repr;
	
	void makeSet(Node v) {
		v.parent = v;
		v.size = 1;
	}
	
	Node find(Node v) {
		if(v.parent==v) return v;
		else return find(v.parent);
	}
	
	void union(Node a, Node b) {
		Node aRoot = find(a);
		Node bRoot = find(b);
		if(aRoot!=bRoot) {
			if(aRoot.size<bRoot.size) {
				aRoot.parent = bRoot;
				bRoot.size = aRoot.size + bRoot.size;
			}else {
				bRoot.parent = aRoot;
				aRoot.size = bRoot.size + aRoot.size;
			}
		}
	}
}


class Node {
	Node parent;
	int size, key;
}