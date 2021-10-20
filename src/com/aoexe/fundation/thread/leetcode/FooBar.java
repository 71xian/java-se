package com.aoexe.fundation.thread.leetcode;

import java.util.concurrent.TimeUnit;

public class FooBar {
	private int n;

	private volatile Boolean flag = true;

	public FooBar(int n) {
		this.n = n;
	}

	public void foo(Runnable printFoo) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			while(!flag) {
				TimeUnit.MILLISECONDS.sleep(1);
			}
			printFoo.run();
			flag = false;
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			while(flag) {
				TimeUnit.MILLISECONDS.sleep(1);
			}
			printBar.run();
			flag = true;
		}
	}
}
