// Cracking the Coding Interview 2.4
// Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than of equal to x.

public class Partition {
	// create two linked lists to hold node less than x and nodes greater than or equal to x, then merge
	// O(n) time, O(1) space
	public static Node partition(Node n, int x) {
		Node lHead = null, lTail = null; // nodes less than x
		Node gHead = null, gTail = null; // nodes greater than or equal to x

		while (n != null) {
			if (n.data < x) {
				if (lHead == null) {
					lHead = n;
					lTail = n;
				}
				else {
					lTail.next = n;
					lTail = n;
				}
			}
			else {
				if (gHead == null) {
					gHead = n;
					gTail = n;
				}
				else {
					gTail.next = n;
					gTail = n;
				}
			}
			n = n.next;
		}

		if (lHead == null) {
			return gHead;
		}
		else {
			lTail.next = gHead;
			return lHead;
		}
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
