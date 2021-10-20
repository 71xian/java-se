package fundation.thread.leetcode;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Foo {

	private AtomicInteger lock = new AtomicInteger(0);

	public Foo() {

	}

	public void first(Runnable printFirst) throws InterruptedException {
		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		lock.incrementAndGet();
	}

	public void second(Runnable printSecond) throws InterruptedException {
		while (lock.get() != 1) {
			TimeUnit.MILLISECONDS.sleep(5);
		}
		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();
		lock.incrementAndGet();
	}

	public void third(Runnable printThird) throws InterruptedException {
		while (lock.get() != 2) {
			TimeUnit.MILLISECONDS.sleep(5);
		}
		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();
		lock.getAndSet(0);
	}

}
