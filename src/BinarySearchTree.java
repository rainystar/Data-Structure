
/**
 * Reference:
 * https://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/code/BST.java
 */
public class BinarySearchTree {
	
	public static Node find(Node root, int x) {
		if (root == null) {
			return null;
		}
		if (root.x == x) {
			return root;
		}
		if (root.x < x) {
			return find(root.right, x);
		}
		else {
			return find(root.left, x);
		}
	}
	
	public static Node findMin(Node root) {
		if (root == null) {
			return null;
		}
		if (root.left == null) {
			return root;
		}
		else {
			return findMin(root.left);
		}
	}
	
	public static Node findMax(Node root) {
		if (root == null) {
			return null;
		}
		if (root.right == null) {
			return root;
		}
		else {
			return findMax(root.right);
		}
	}
	
	public static Node insert(Node root, int x) {
		Node node = new Node(x);
		if (root == null) {
			return node;
		}
		if (root.x == x) {
			return root;
		}
		if (root.x < x) {
			root.right = insert(root.right, x);
		}
		else {
			root.left = insert(root.left, x);
		}
		return root;
	}
	
	/**
	 * http://webdocs.cs.ualberta.ca/~holte/T26/del-from-bst.html
	 * if the deleted node has two subtrees, replace the deleted node's key with the smallest key in the right subtree or the largest key in the left subtree
	 * @param root
	 * @param x
	 * @return
	 */
	public static Node delete(Node root, int x) {
		if (root == null) {
			return null;
		}
		if (root.x < x) {
			root.right =  delete(root.right, x);
		}
		else if (root.x > x) {
			root.left = delete(root.left, x);
		}
		else {
			if (root.left == null) {
				return root.right;
			}
			if (root.right == null) {
				return root.left;
			}
			Node maxLeft = findMax(root.left);
			root.x = maxLeft.x;
			root.left = delete(root.left, maxLeft.x);
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node0 = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node6 = new Node(6);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		node6.left = node1;
		node6.right = node9;
		node1.left = node0;
		node1.right = node2;
		node9.left = node8;
		node9.right = node10;
		Node root = delete(node6, 6);
		return;
	}

}
