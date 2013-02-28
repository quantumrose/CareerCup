// Cracking the Coding Interview 2.5
// You have two numbers represented by a linked list, where each node contains a single digit.
// The digits are stored in reverse order, such that the 1's digit is at the head of the list.
// Write a function that adds the two numbers and returns the sum as a linked list.
//
// EXAMPLE
// Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295
// Output: 2 -> 1 -> 9. That is, 912.
//
// FOLLOW UP
// Suppose the digits are stored in forward order. Repeat the above problem.
//
// EXAMPLE
// Input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295.
// Output: 9 -> 1 -> 2. That is, 912.

public class AddLists {
	// reverse order
	public static Node addLists1(Node head1, Node head2) {
		return addListsReverse(head1, head2, 0);
	}

	public static Node addListsReverse(Node n1, Node n2, int carry) {
		if (n1 == null && n2 == null) {
			if (carry == 0) {
				return null;
			}
			else {
				return new Node(carry);
			}
		}

		int sum = 0;
		if (n1 == null) {
			sum = n2.data + carry;
		}
		else if (n2 == null) {
			sum = n1.data + carry;
		}
		else {
			sum = n1.data + n2.data + carry;
		}

		int partialSum = sum % 10;
		int newCarry = sum / 10;

		Node n = new Node(partialSum);

		// when one linked list is shorter than another
		if (n1 == null) {
			n.next = addListsReverse(null, n2.next, newCarry);
		}
		else if (n2 == null) {
			n.next = addListsReverse(n1.next, null, newCarry);
		}
		else {
			n.next = addListsReverse(n1.next, n2.next, newCarry);
		}

		return n;
	}

	// forward order
	public static Node addLists2(Node head1, Node head2) {
		int len1 = head1.length();
		int len2 = head2.length();

		// pad zeros in front of the shorter linked list
		if (len1 < len2) {
			head1 = padZeros(head1, len2 - len1);
		}
		else if (len1 > len2) {
			head2 = padZeros(head2, len1 - len2);
		}

		Result result = addListsForward(head1, head2);

		if (result.carry == 0) {
			return result.node;
		}
		else {
			Node head = new Node(result.carry);
			head.next = result.node;
			return head;
		}
	}

	public static Node padZeros(Node n, int num) {
		if (num <= 0) {
			return n;
		}

		Node head = new Node(0);
		Node curr = head;

		for (int i = 0; i < num - 1; i++) {
			curr.next = new Node(0);
			curr = curr.next;
		}
		curr.next = n;

		return head;
	}

	public static Result addListsForward(Node n1, Node n2) {
		if (n1 == null && n2 == null) {
			return new Result(null, 0);
		}

		Result result = addListsForward(n1.next, n2.next);

		int sum = n1.data + n2.data + result.carry;
		int partialSum = sum % 10;
		int newCarry = sum / 10;

		Node n = new Node(partialSum);
		n.next= result.node;

		return new Result(n, newCarry);
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
	Node node;
	int carry;

	public Result(Node node, int carry) {
		this.node = node;
		this.carry = carry;
	}
}
