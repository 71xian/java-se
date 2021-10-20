package fundation.thread.my;

import java.util.concurrent.TimeUnit;

public class TimeTask implements Runnable {

	private int n;

	private String message;

	public TimeTask(int n, String message) {
		this.n = n;
		this.message = message;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(message);
			try {
				TimeUnit.SECONDS.sleep(n);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
