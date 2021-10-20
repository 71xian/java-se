package fundation.thread.my;

import java.util.concurrent.Callable;

public class NewThread {
	
	public static void main(String[] args) {
		new MyThread().start();
		new Thread(new MyTask()).start();
	}
}

class MyThread extends Thread {

	@Override
	public void run() {
		System.out.println("hello my thread");
		super.run();
	}
}

class MyTask implements Runnable {

	@Override
	public void run() {
		System.out.println("hello my task");
	}

}

class MyCall implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println("hello my call");
		return 0;
	}

}
