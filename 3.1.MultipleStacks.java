// Cracking the Coding Interview 3.1
// Describe how you could use a single array to implement three stacks.

// flexible divisions

public class MultipleStacks {
	final int numOfStacks;
	final int capacity ;
	final int length;

	int[] array;
	StackData[] stacks;

	public MultipleStacks(int numOfStacks, int capacity) {
		this.numOfStacks = numOfStacks;
		this.capacity = capacity;
		length = numOfStacks * capacity;
		
		array = new int[length];
		stacks = new StackData[numOfStacks];
		for (int i = 0; i < numOfStacks; i++) {
			stacks[i] = new StackData(i * capacity, capacity);
		}
	}

	public void push(int index, int data) throws Exception {
		int size = 0;
		for (int i = 0; i < numOfStacks; i++) {
			size += stacks[i].size;
		}
		if (size == length) {
			throw new Exception("Out of space");
		}
		
		if (stacks[index].size == stacks[index].capacity) {
			shift((index + 1) % numOfStacks);
			stacks[index].capacity++;
		}

		array[(stacks[index].top + 1) % length] = data;
		stacks[index].top = (stacks[index].top + 1) % length;
		stacks[index].size++;
	}

	public void shift(int index) {
		if (stacks[index].size == stacks[index].capacity) {
			shift((index + 1) % numOfStacks);
			stacks[index].capacity++;
		}
		
		for (int i = stacks[index].top; i >= stacks[index].start; i--) {
			array[(i + 1) % length] = array[i];
		}
		stacks[index].top = (stacks[index].top + 1) % length;
		stacks[index].start = (stacks[index].start + 1) % length;
		stacks[index].capacity--;
	}

	public int pop(int index) throws Exception {
		if (stacks[index].size == 0) {
			throw new Exception("Stack is empty");
		}

		int rv = array[stacks[index].top];
		stacks[index].top = (stacks[index].top + length - 1) % length;
		stacks[index].size--;

		return rv;
	}

	public int peek(int index) throws Exception {
		if (stacks[index].size == 0) {
			throw new Exception("Stack is empty");
		}
		return array[stacks[index].top];
	}

	public void display() {
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < numOfStacks; j++) {
				if (i == stacks[j].start) {
					System.out.print("| ");
				}
			}
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}

class StackData {
	int start;
	int capacity;
	int top;
	int size = 0;

	public StackData(int start, int capacity) {
		this.start = start;
		this.capacity = capacity;
		top = start + size - 1;
	}
}
