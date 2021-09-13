package com.aoexe.fundation.thread;

public class Listen {
	
	private static Object lock1 = new Object();
	
	private static Object lock2 = new Object();

	public static void main(String[] args) throws InterruptedException {
		while(true) {
			Thread t = new Thread(() -> {
				System.out.println("hello");
			});
			t.join();
			t.start();
		}
	}
}
