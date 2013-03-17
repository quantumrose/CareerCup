// Cracking the Coding Interview 3.6
// Write a program to sort a stack in ascending order (with biggest items on top).
// You may use additional stacks to hold items, but you may not copy the elements into any other data structure (such as an array).
// The stack supports the following operations: push, pop, peek, and isEmpty.

import java.util.LinkedList;

public class Sort {
	public static LinkedList<Integer> sort(LinkedList<Integer> stack) {
		LinkedList<Integer> buffer = new LinkedList<Integer>();

		while (!stack.isEmpty()) {
			int value = stack.pop();

			while (!buffer.isEmpty() && buffer.peek() > value) {
				stack.push(buffer.pop());
			}
			buffer.push(value);
		}
		return buffer;
	}
}
