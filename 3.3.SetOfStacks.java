// Cracking the Coding Interview 3.3
// Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
// Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and should create a new stack once the previous one exceeds capacity.
// SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is, pop() should return the same values as it would if there were just a single stack).
//
// FOLLOW UP
// Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.

import java.util.ArrayList;
import java.util.LinkedList;

public class SetOfStacks {
	protected ArrayList<LinkedList<Integer>> stacks;
	public int capacity;

	public SetOfStacks(int capacity) {
		stacks = new ArrayList<LinkedList<Integer>>();
		this.capacity = capacity;
	}

	public void push(int data) {
		if (topStack() == null || topStack().size() == capacity) {
			stacks.add(new LinkedList<Integer>());
		}
		topStack().push(data);
	}

	protected LinkedList<Integer> topStack() {
		if (stacks.isEmpty()) {
			return null;
		}
		else {
			return stacks.get(stacks.size() - 1);
		}
	}

	public int pop() throws Exception {
		if (topStack() == null) {
			throw new Exception("Stack is empty");
		}

		int rv = topStack().pop();
		if (topStack().isEmpty()) {
			stacks.remove(topStack());
		}
		return rv;
	}

	public int peek() throws Exception {
		if (topStack() == null) {
			throw new Exception("Stack is empty");
		}
		return topStack().peek();
	}

	public int popAt(int index) throws Exception {
		if (index >= stacks.size()) {
			throw new Exception("Index out of range");
		}

		LinkedList<Integer> stack = stacks.get(index);
		int rv = stack.pop();
		if (index != stacks.size() - 1) {
			stack.push(shift(index + 1));
		}
		return rv;
	}

	protected int shift(int index) {
		LinkedList<Integer> stack = stacks.get(index);
		int rv = stack.removeLast();
		if (index != stacks.size() - 1) {
			stack.push(shift(index + 1));
		}
		else {
			if (stack.isEmpty()) {
				stacks.remove(stack);
			}
		}
		return rv;
	}

	public void display() {
		for (LinkedList<Integer> stack: stacks) {
			System.out.println(stack.toString());
		}
	}
}
