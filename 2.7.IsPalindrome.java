// Cracking the Coding Interview 2.7
// Implement a function to check if a linked list is a palindrome.

import java.util.LinkedList;

public class IsPalindrome {
	// method1: iterative
	public static boolean isPalindrome1(Node head) {
		Node fast = head, slow = head;
		LinkedList<Integer> stack = new LinkedList<Integer>();

		while (fast != null && fast.next != null) {
			stack.push(slow.data);

			fast = fast.next.next;
			slow = slow.next;
		}

		// length of linked list is odd, skip the middle
		if (fast != null) {
			slow = slow.next;
		}

		while (slow != null) {
			if (stack.pop() != slow.data) {
				return false;
			}
			slow = slow.next;
		}

		return true;
	}

	// method2: recursive
	public static boolean isPalindrome2(Node head) {
		int length = head.length();

		Result res = isPalindromeR(head, length);

		return res.bool;
	}

	public static Result isPalindromeR(Node node, int length) {
		if (length == 0) {
			return new Result(true, node);
		}
		if (length == 1) {
			return new Result(true, node.next);
		}

		Result res = isPalindromeR(node.next, length - 2);

		if (!res.bool || node.data != res.node.data) {
			return new Result(false, res.node.next);
		}
		else {
			return new Result(true, res.node.next);
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

	public int length() {
		Node n = this;
		int cnt = 0;

		while (n != null) {
			n = n.next;
			cnt++;
		}

		return cnt;
	}
}

class Result {
	boolean bool;
	Node node;

	public Result(boolean bool, Node node) {
		this.bool = bool;
		this.node = node;
	}
}
