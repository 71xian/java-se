package com.aoexe.fundation.thread.test;

import com.aoexe.fundation.thread.leetcode.FizzBuzz;
import com.aoexe.fundation.thread.leetcode.IntConsumer;

public class TestString {

	public static void main(String[] args) {
		FizzBuzz f = new FizzBuzz(10000);
		new Thread(new MyPrint(0, f)).start();
		new Thread(new MyPrint(1, f)).start();
		new Thread(new MyPrint(2, f)).start();
		new Thread(new MyPrint(3, f)).start();
	}
}

class MyPrint implements Runnable {

	private int x;

	private FizzBuzz f;

	public MyPrint(int x, FizzBuzz f) {
		this.x = x;
		this.f = f;
	}

	@Override
	public void run() {
		try {
			if (x == 0) {
				f.fizz(() -> {
				});
			} else if (x == 1) {
				f.buzz(() -> {
				});
			} else if (x == 2) {
				f.fizzbuzz(() -> {
				});
			} else {
				f.number(new IntConsumer());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
