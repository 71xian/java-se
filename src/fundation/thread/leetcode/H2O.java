package fundation.thread.leetcode;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class H2O {

	private AtomicInteger h = new AtomicInteger();

	private AtomicInteger o = new AtomicInteger();

	public H2O() {

	}

	public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		synchronized (h) {
			while (h.get() == 2) {
				TimeUnit.MILLISECONDS.sleep(1);
				if (o.get() == 1) {
					o.set(0);
					h.set(0);
				}
			}
		}
		releaseHydrogen.run();
		h.incrementAndGet();
	}

	public void oxygen(Runnable releaseOxygen) throws InterruptedException {
		synchronized (o) {
			while (o.get() == 1) {
				TimeUnit.MILLISECONDS.sleep(1);
				if (h.get() == 2) {
					o.set(0);
					h.set(0);
				}
			}
		}
		releaseOxygen.run();
		o.incrementAndGet();
	}
}
