package fundation.thread.my;

public class TestThread {

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			new Thread(new TimeTask(i, i + "hello")).start();
		}
	}
}
