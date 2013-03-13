// Cracking the Coding Interview 3.5
// Implement a MyQueue class which implements a queue using two stacks.

import java.util.LinkedList;

public class MyQueue {
	private LinkedList<Integer> stack1;
	private LinkedList<Integer> stack2;

	public MyQueue() {
		stack1 = new LinkedList<Integer>();
		stack2 = new LinkedList<Integer>();
	}

	public void add(int data) {
		stack1.push(data);
	}

	public int remove() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

	public int element() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.peek();
	}
}
