// Cracking the Coding Interview 2.2
// Implement an algorithm to find the kth to last element of a singly linked list.

public class KthToLast {
	// method1: first traverse the linked list to get its length, then find the kth to last element
	// O(n) time, O(1) space
	public static Node kthToLast1(Node head, int k) {
		if (head == null || k < 0) {
			return null;
		}

		Node n = head;
		int cnt = 0;
		while (n.next != null) {
			n = n.next;
			cnt += 1;
		}

		if (k > cnt) {
			return null;
		}

		n = head;
		for (int i = 0; i < cnt - k; i++) {
			n = n.next;
		}

		return n;
	}

	// method2: use two pointers k nodes apart and move them together
	// O(n) time, O(1) space
	public static Node kthToLast2(Node head, int k) {
		if (head == null || k < 0) {
			return null;
		}

		Node current = head, runner = head;

		for (int i = 0; i < k; i++) {
			runner = runner.next;
			if (runner == null) {
				return null;
			}
		}

		while (runner.next != null) {
			runner = runner.next;
			current = current.next;
		}

		return current;
	}

	// method3: recursive
	// O(n) time, O(n) space
	public static Node kthToLast3(Node head, int k) {
		if (head == null || k < 0) {
			return null;
		}

		Result result = kthToLastR(head, k);

		if (result.index == k) {
			return result.node;
		}
		else {
			return null;
		}
	}

	public static Result kthToLastR(Node n, int k) {
		if (n.next == null) {
			return new Result(n, 0);
		}

		Result result = kthToLastR(n.next, k);

		if (result.index == k) {
			return result;
		}
		else {
			return new Result(n, result.index + 1);
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
}

class Result {
	Node node;
	int index;

	public Result(Node node, int index) {
		this.node = node;
		this.index = index;
	}
}
