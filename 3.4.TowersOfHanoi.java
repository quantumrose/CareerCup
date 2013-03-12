// Cracking the Coding Interview 3.4
// In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes which can slide onto any tower.
// The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top of an even larger one).
// You have the following constraints:
// (1) Only one disk can be moved at a time.
// (2) A disk is slid off the top of one tower onto the next tower.
// (3) A disk can only be placed on top of a larger disk.
// Write a program to move the disks from the first tower to the last using stacks.

import java.util.LinkedList;

public class TowersOfHanoi {
	public static void moveDisks(Tower from, Tower to, Tower through, int n) {
		if (n == 0) {
			return;
		}
		if (n == 1) {
			from.moveTo(to);
			return;
		}

		moveDisks(from, through, to, n - 1);
		from.moveTo(to);
		moveDisks(through, to, from, n - 1);
	}
}

class Tower {
	private LinkedList<Integer> tower;

	public Tower() {
		tower = new LinkedList<Integer>();
	}

	public boolean add(int disk) {
		if (tower.isEmpty() || tower.peek() > disk) {
			tower.push(disk);
			return true;
		}
		return false;
	}

	public boolean moveTo(Tower to) {
		if (tower.isEmpty()) {
			return false;
		}
		return to.add(tower.pop());
	}

	public String toString() {
		return tower.toString();
	}
}
