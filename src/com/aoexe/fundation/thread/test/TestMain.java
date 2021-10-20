package com.aoexe.fundation.thread.test;

import java.util.ArrayList;
import java.util.List;

import com.aoexe.fundation.thread.leetcode.H2O;

public class TestMain {

	public static void main(String[] args) {
		H2O h = new H2O();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10000; i++) {
			if (i % 2 == 0) {
				sb.append('O');
			} else {
				sb.append('H');
			}
		}
		String s = sb.toString();
		List<Thread> ts = new ArrayList<>(s.length());
		for (char ch : s.toCharArray()) {
			ts.add(new Thread(new Print(h, ch)));
		}
		for (Thread t : ts) {
			t.start();
		}
	}
}

class Print implements Runnable {

	private H2O h;

	private char ch;

	public Print(H2O h, char ch) {
		this.h = h;
		this.ch = ch;
	}

	@Override
	public void run() {
		if (ch == 'H') {
			try {
				h.hydrogen(() -> {
				});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				h.oxygen(() -> {
				});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}