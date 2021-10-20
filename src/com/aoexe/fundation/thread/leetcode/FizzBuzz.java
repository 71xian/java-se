package com.aoexe.fundation.thread.leetcode;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FizzBuzz {
	private int n;

	private AtomicInteger x = new AtomicInteger(1);

	public FizzBuzz(int n) {
		this.n = n;
	}

	public void fizz(Runnable printFizz) throws InterruptedException {
		while (x.get() <= n) {
			while (x.get() % 5 == 0 || x.get() % 3 != 0) {
				TimeUnit.MILLISECONDS.sleep(1);
				if (x.get() == n + 1) {
					return;
				}
			}
			System.out.println("fizz");
			printFizz.run();
			x.incrementAndGet();
		}
	}

	public void buzz(Runnable printBuzz) throws InterruptedException {
		while (x.get() <= n) {
			while (x.get() % 3 == 0 || x.get() % 5 != 0) {
				TimeUnit.MILLISECONDS.sleep(1);
				if (x.get() == n + 1) {
					return;
				}
			}
			System.out.println("buzz");
			printBuzz.run();
			x.incrementAndGet();
		}
	}

	public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		while (x.get() <= n) {
			while ((x.get() % 5 != 0 && x.get() % 3 != 0) || (x.get() % 5 == 0 && x.get() % 3 != 0)
					|| (x.get() % 5 != 0 && x.get() % 3 == 0)) {
				TimeUnit.MILLISECONDS.sleep(1);
				if (x.get() == n + 1) {
					return;
				}
			}
			System.out.println("fizzbuzz");
			printFizzBuzz.run();
			x.incrementAndGet();
		}
	}

	public void number(IntConsumer printNumber) throws InterruptedException {
		while (x.get() <= n) {
			while (x.get() % 5 == 0 || x.get() % 3 == 0) {
				TimeUnit.MICROSECONDS.sleep(1);
				if (x.get() == n + 1) {
					return;
				}
			}
			printNumber.accept(x.get());
			x.incrementAndGet();
		}
	}
}
