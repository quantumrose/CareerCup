// Cracking the Coding Interview 2.1
// Write code to remove duplicates from an unsorted linked list.
//
// FOLLOW UP
// How would you solve this problem if a temporary buffer is not allowed?

import java.util.HashMap;

public class DeleteDups {
	// method1: use hash map to track duplicates
	// O(n) time
	public static void deleteDups1(Node head) {
		if (head == null) {
			return;
		}

		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		map.put(head.data, true);

		while (head.next != null) {
			if (map.containsKey(head.next.data)) {
				head.next = head.next.next;
			}
			else {
				map.put(head.next.data, true);
				head = head.next;
			}
		}
	}

	// method2: nested loop, without temporary buffer
	// O(n^2) time, O(1) space
	public static void deleteDups2(Node head) {
		Node curr;

		while (head != null) {
			curr = head;
			while (curr.next != null) {
				if (head.data == curr.next.data) {
					curr.next = curr.next.next;
				}
				else {
					curr = curr.next;
				}
			}
			head = head.next;
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
