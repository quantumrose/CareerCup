// Cracking the Coding Interview 3.7
// An animal shelter holds only dogs and cats, and operates on a strictly “first in, first out” basis.
// People must adopt either the “oldest” (based on arrival time) of all animals at the shelter, or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
// They cannot select which specific animal they would like.
// Create the data structures to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog and dequeueCat.
// You may use the built-in LinkedList data structure.

import java.util.LinkedList;

public class AnimalQueue {
	LinkedList<Cat> catQueue;
	LinkedList<Dog> dogQueue;

	public AnimalQueue() {
		catQueue = new LinkedList<Cat>();
		dogQueue = new LinkedList<Dog>();
	}

	public void enqueue(Animal animal) {
		if (animal instanceof Cat) {
			catQueue.add((Cat) animal);
		}
		else if (animal instanceof Dog) {
			dogQueue.add((Dog) animal);
		}
	}

	public Animal dequeueAny() {
		if (catQueue.isEmpty()) {
			return dogQueue.remove();
		}
		else if (dogQueue.isEmpty()) {
			return catQueue.remove();
		}

		if (catQueue.peek().getid() < dogQueue.peek().getid()) {
			return catQueue.remove();
		}
		else {
			return dogQueue.remove();
		}
	}

	public Cat dequeueCat() {
		return catQueue.remove();
	}

	public Dog dequeueDog() {
		return dogQueue.remove();
	}
}

class Animal {
	private static int count = 0;
	private final int id = count++;
	public String name;

	public Animal(String name) {
		this.name = name;
	}

	public int getid() {
		return id;
	}

	public String toString() {
		return name;
	}
}

class Cat extends Animal {
	public Cat(String name) {
		super(name);
	}
}

class Dog extends Animal {
	public Dog(String name) {
		super(name);
	}
}
