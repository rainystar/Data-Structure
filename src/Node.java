
public class Node {
	public int x;
	public char c;
	public Node next;
	public Node left;
	public Node right;
	
	public Node(int x) {
		this.x = x;
		this.next = null;
		this.left = null;
		this.right = null;
	}
	
	public Node(char c) {
		this.c = c;
		this.next = null;
		this.left = null;
		this.right = null;
	}
	
	public Node() {
		this.next = null;
		this.left = null;
		this.right = null;
	}
}
