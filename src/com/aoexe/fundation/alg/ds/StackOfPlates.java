package com.aoexe.fundation.alg.ds;

import java.util.LinkedList;
import java.util.Stack;

public class StackOfPlates {

	private Stack<Integer> stack = new Stack<>();

	private LinkedList<Stack<Integer>> list = new LinkedList<>();

	private int size;

	public StackOfPlates(int cap) {
		size = cap;
		list.add(stack);
	}

	public void push(int val) {
		// 容量为0的时候不允许放置元素
		if (size == 0) {
			return;
		}
		// 容量满的时候就新建一个栈
		if (stack.size() == size) {
			stack = new Stack<>();
			list.add(stack);
		}
		stack.push(val);
	}

	public int pop() {
		if(stack.isEmpty()) {
			return -1;
		}
		int result = stack.pop();
		if(stack.isEmpty()) {
			if(list.size() > 1) {
				list.removeLast();
				stack = list.getLast();
			}
		}
		return result;
	}

	public int popAt(int index) {
		if (index >= list.size() || index < 0) {
			return -1;
		}
		Stack<Integer> arr = list.get(index);
		if(arr.equals(stack)) {
			return this.pop();
		}
		if (arr.isEmpty()) {
			return -1;
		}
		int result = arr.pop();
		if (arr.isEmpty()) {
			if(list.size() > 1) {
				list.remove(index);
			}
		}
		return result;
	}
}