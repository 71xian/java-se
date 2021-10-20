package com.aoexe.fundation.thread.my;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

	private AtomicInteger I = new AtomicInteger();
	private int i = 0;

	public static void main(String[] args) {
		final Counter cas = new Counter();
		List<Thread> ts = new ArrayList<>(600);
		long start = System.currentTimeMillis();
		for (int j = 0; j < 100; j++) {
			Thread t = new Thread(() -> {
				for (int i = 0; i < 10000; i++) {
					cas.count();
					cas.safeCount();
				}
			});
			ts.add(t);
		}
		for (Thread t : ts) {
			t.start();
		}
		for (Thread t : ts) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(cas.i);
		System.out.println(cas.I.get());
		System.out.println(System.currentTimeMillis() - start);
	}

	private void safeCount() {
		for (;;) {
			int i = I.get();
			boolean suc = I.compareAndSet(i, i++);
			if (suc) {
				break;
			}
		}
	}

	private void count() {
		i++;
	}
}
