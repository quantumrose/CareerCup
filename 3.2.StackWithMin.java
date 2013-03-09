// Cracking the Coding Interview 3.2
// How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element?
// Push, pop and min should all operate in O(1) time.

import java.util.LinkedList;

public class StackWithMin {
	protected LinkedList<Integer> stack;
	protected LinkedList<Integer> min;

	public StackWithMin() {
		stack = new LinkedList<Integer>();
		min = new LinkedList<Integer>();
	}

	public void push(int data) {
		stack.push(data);
		if (data <= min()) {
			min.push(data);
		}
	}

	public int pop() {
		int rv = stack.pop();
		if (rv == min()) {
			min.pop();
		}
		return rv;
	}

	public int peek() {
		return stack.peek();
	}

	public int min() {
		if (min.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		else {
			return min.peek();
		}
	}
}
