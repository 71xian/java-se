package com.aoexe.fundation.algorithm.struct;

public class TripleInOne {

	int N = 3;
	// 3 * n 的数组，每一行代表一个栈
	int[][] data;
	// 记录每个栈「待插入」位置
	int[] locations;

	public TripleInOne(int stackSize) {
		data = new int[N][stackSize];
		locations = new int[N];
	}

	public void push(int stackNum, int value) {
		int[] stk = data[stackNum];
		int loc = locations[stackNum];
		if (loc < stk.length) {
			stk[loc] = value;
			locations[stackNum]++;
		}
	}

	public int pop(int stackNum) {
		int[] stk = data[stackNum];
		int loc = locations[stackNum];
		if (loc > 0) {
			int val = stk[loc - 1];
			locations[stackNum]--;
			return val;
		} else {
			return -1;
		}
	}

	public int peek(int stackNum) {
		int[] stk = data[stackNum];
		int loc = locations[stackNum];
		if (loc > 0) {
			return stk[loc - 1];
		} else {
			return -1;
		}
	}

	public boolean isEmpty(int stackNum) {
		return locations[stackNum] == 0;
	}
}
