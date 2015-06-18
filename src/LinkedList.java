
public class LinkedList {
	public static boolean isEmpty(Node head) {
		if (head == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isLast(Node node) {
		if (node == null || node.next == null) {	// involve the condition that the total list is empty
			return true;
		}
		else {
			return false;
		}
	}
	
	public static Node find(Node head, int x) {
		Node ptr = head;
		while (ptr != null && ptr.x != x) {
			ptr = ptr.next;
		}
		return ptr;
	}
	
	/**
	 * return head of list, if index is invalid, does not insert
	 * @param head
	 * @param node (assume not null)
	 * @param index
	 * @return
	 */
	public static Node insert(Node head, Node node, int index) {
		if (index == 0) {
			node.next = head;
			return node;
		}
		Node ptr = head;
		index--;
		while (index != 0 && ptr.next != null) {
			ptr = ptr.next;
			index--;
		}
		if (index == 0) {
			node.next = ptr.next;
			ptr.next = node;
		}
		return head;
	}
	
	/**
	 * return head of list, if node does not exist in the list, does not delete
	 * @param head
	 * @param node
	 * @return
	 */
	public static Node delete(Node head, Node node) {
		if (head == node) {
			head = head.next;
			return head;
		}
		Node ptr = head;
		while (ptr.next != node && ptr.next != null) {
			ptr = ptr.next;
		}
		if (ptr.next != null) {
			ptr.next = ptr.next.next;
		}
		return head;
	}
	
	public static void display(Node head) {
		Node ptr = head;
		while (ptr != null) {
			System.out.print(ptr.x + " ");
			ptr = ptr.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// test find()
		System.out.println("test find()");
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node head = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		System.out.println(find(node1, 1).x);
		System.out.println(find(node1, 3).x);
		System.out.println(find(node1, 4).x);
		System.out.println(find(node1, 5) == null);
		// test insert()
		System.out.println("test insert()");
		Node node5 = new Node(5);
		head = insert(head, node5, 1);
		Node node6 = new Node(6);
		head = insert(head, node6, 5);
		Node node7 = new Node(7);
		head = insert(head, node7, 3);
		Node node8 = new Node(8);
		head = insert(head, node8, 0);
		Node node9 = new Node(9);
		head = insert(head, node9, 20);
		display(head);
		// test delete()
		System.out.println("test delete()");		
		head = delete(head, node8);
		head = delete(head, node2);
		head = delete(head, node6);
		display(head);
		
	}
}
