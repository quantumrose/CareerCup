// Cracking the Coding Interview 2.6
// Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
//
// DEFINITION
// Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.
//
// EXAMPLE
// Input: A -> B -> C -> D -> E -> C [the same C as earlier]
// Output: C

public class FindBeginning {
	// should add null-pointer checking in case there is no loop in linked list
	public static Node findBeginning(Node head) {
		Node fast, slow;

		fast = head.next.next;
		slow = head.next;
		while (fast != slow) {
			fast = fast.next.next;
			slow = slow.next;
		}

		fast = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}

		return fast;
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
}
