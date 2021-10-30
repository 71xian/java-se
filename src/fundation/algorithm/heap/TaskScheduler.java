package fundation.algorithm.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 任务调度器
 * 
 * @author Administrator
 * @date 2021-10-26 01:37:49
 */
public class TaskScheduler {

	public int leastInterval(char[] tasks, int n) {
		PriorityQueue<int[]> deque = new PriorityQueue<>((a, b) -> b[1] - a[1]);
		int[] map = new int[26];
		for (char ch : tasks) {
			map[ch - 'A']++;
		}
		for (int i = 0; i < map.length; i++) {
			if (map[i] != 0) {
				deque.offer(new int[] { i, map[i] });
			}
		}
		int sum = 0;
		int index = 0;
		while (true) {
			int size = 0;
			List<int[]> nodes = new ArrayList<>();
			while (!deque.isEmpty() && size <= n) {
				int[] max = deque.poll();
				size++;
				index++;
				if (max[1] > 1) {
					max[1]--;
					nodes.add(max);
				}
			}
			if (!nodes.isEmpty()) {
				deque.addAll(nodes);
			}
			if (index == tasks.length) {
				return sum + size;
			}
			sum += Math.max(size, n + 1);
		}
	}
}
