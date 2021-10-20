package fundation.thread.my;

import java.util.concurrent.locks.ReentrantLock;

public class ReLock {

	private ReentrantLock lock = new ReentrantLock();

	public void test() {
		lock.lock();
		try {
			System.out.println("hello");
		} finally {
			lock.unlock();
		}
	}
}
