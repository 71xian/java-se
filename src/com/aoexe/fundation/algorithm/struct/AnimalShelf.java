package com.aoexe.fundation.algorithm.struct;

import java.util.LinkedList;

public class AnimalShelf {

	private LinkedList<Integer> cat = new LinkedList<>();

	private LinkedList<Integer> dog = new LinkedList<>();

	private LinkedList<Integer> link = new LinkedList<>();

	public AnimalShelf() {
	}

	public void enqueue(int[] animal) {
    	LinkedList<Integer> l = animal[1] == 0 ? cat : dog;
    	l.add(animal[0]);
    	link.add(animal[1]);
    }

	public int[] dequeueAny() {
		int[] result = new int[2];
		if(link.isEmpty()) {
			result[0] = -1;
			result[1] = -1;
            return result;
		}
		int animal = link.removeFirst();
		result[0] = animal == 0 ? cat.removeFirst() : dog.removeFirst();
		result[1] = animal;
		return result;
	}

	public int[] dequeueDog() {
		int[] result = new int[2];
		if(dog.isEmpty()) {
			result[0] = -1;
			result[1] = -1;
            return result;
		}
		int animal = link.getFirst();
		if(animal == 1) {
			link.removeFirst();
		}else{
             link.removeFirstOccurrence(1);
        }
		result[0] = dog.removeFirst();
		result[1] = 1;
		return result;
	}

	public int[] dequeueCat() {
		int[] result = new int[2];
		if(cat.isEmpty()) {
			result[0] = -1;
			result[1] = -1;
            return result;
		}
		int animal = link.getFirst();
		if(animal == 0) {
			link.removeFirst();
		}else{
             link.removeFirstOccurrence(0);
        }
		result[0] = cat.removeFirst();
		result[1] = 0;
		return result;
	}
}
