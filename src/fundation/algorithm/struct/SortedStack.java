package fundation.algorithm.struct;

import java.util.Stack;

public class SortedStack {

	private Stack<Integer> stack;

	private Stack<Integer> temp;

	public SortedStack() {
		stack = new Stack<>();
		temp = new Stack<>();
	}

	public void push(int val) {
		while (true) {
			int max = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek();
			int min = temp.isEmpty() ? Integer.MIN_VALUE : temp.peek();
			if (val > max) {
				if (!stack.isEmpty()) {
					temp.push(stack.pop());
				}
			} else if (val < min) {
				if (!temp.isEmpty()) {
					stack.push(temp.pop());
				}
			} else {
				stack.push(val);
				break;
			}
		}
	}

	public void pop() {
		while (!temp.isEmpty()) {
			stack.push(temp.pop());
		}
		if (!stack.isEmpty()) {
			stack.pop();
		}
	}

	public int peek() {
		while (!temp.isEmpty()) {
			stack.push(temp.pop());
		}
		if (stack.isEmpty()) {
			return -1;
		}
		return stack.peek();
	}

	public boolean isEmpty() {
		return stack.isEmpty() && temp.isEmpty();
	}
}
