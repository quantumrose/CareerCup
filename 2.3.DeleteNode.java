// Cracking the Coding Interview 2.3
// Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
//
// EXAMPLE
// Input: the node c from the linked list a -> b -> c -> d -> e
// Result: nothing is returned, but the new linked list looks like a -> b -> d -> e

public class DeleteNode {
	public static boolean deleteNode(Node n) {
		if (n == null || n.next == null) {
			return false;
		}

		n.data = n.next.data;
		n.next = n.next.next;

		return true;
	}
}

class Node {
	Node next = null;
	int data;

	public Node(int data) {
		this.data = data;
	}

	public void appendToTail(int data) {
		Node n = this;

		while (n.next != null) {
			n = n.next;
		}

		n.next = new Node(data);
	}

	public void display() {
		Node n = this;

		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}
}
