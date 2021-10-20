package fundation.thread.leetcode;

import java.util.ArrayList;
import java.util.List;

public class DiningPhilosophers {

	private List<Object> objects = new ArrayList<>();

	public DiningPhilosophers() {
		for (int i = 0; i < 5; i++) {
			objects.add(new Object());
		}
	}

	public void wantsToEat(int philosopher, 
			Runnable pickLeftFork, 
			Runnable pickRightFork, 
			Runnable eat,
			Runnable putLeftFork, 
			Runnable putRightFork) throws InterruptedException {
		

	}
}
