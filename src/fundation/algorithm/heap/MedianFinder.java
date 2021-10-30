package fundation.algorithm.heap;

import java.util.PriorityQueue;

public class MedianFinder {

	PriorityQueue<Integer> left;
	PriorityQueue<Integer> right;

	public MedianFinder() {
		left = new PriorityQueue<>((a, b) -> b - a);
		right = new PriorityQueue<>((a, b) -> a - b);
	}

	public void addNum(int num) {
		left.offer(num);
		while (!right.isEmpty() && left.peek() > right.peek()) {
			right.offer(left.poll());
			left.offer(right.poll());
		}
		if(left.size() == right.size() + 2) {
			right.offer(left.poll());
		}
	}

	public double findMedian() {
		if (left.size() == right.size()) {
			return (left.peek() + right.peek()) / 2.0;
		} else {
			return left.peek();
		}
	}
}
