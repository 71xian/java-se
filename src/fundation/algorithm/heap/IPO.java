package fundation.algorithm.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class IPO {

	public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
		PriorityQueue<int[]> deque = new PriorityQueue<>((a, b) -> b[1] - a[1]);
		for (int i = 0; i < profits.length; i++) {
			if (!map.containsKey(capital[i])) {
				map.put(capital[i], new PriorityQueue<>((a, b) -> b - a));
			}
			map.get(capital[i]).offer(profits[i]);
		}
		Integer[] sort = map.keySet().toArray(new Integer[1]);
		Arrays.sort(sort);
		int cur = 0;
		for (int i = 0; i < k; i++) {
			while (cur < sort.length && sort[cur] <= w) {
				int cap = sort[cur];
				deque.offer(new int[] { cap, map.get(cap).poll() });
				cur++;
			}
			if (deque.isEmpty()) {
				return w;
			}
			int[] max = deque.poll();
			w += max[1];
			if (!map.get(max[0]).isEmpty()) {
				deque.offer(new int[] { max[0], map.get(max[0]).poll() });
			}
		}
		return w;
	}
}
