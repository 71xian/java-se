package fundation.algorithm.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 前k个高频元素
 * 
 * @author Administrator
 * @date 2021-10-24 09:35:21
 */
public class TopKFrequentElements {

	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		PriorityQueue<int[]> deque = new PriorityQueue<>((a, b) -> b[1] - a[1]);
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.compute(num, (key, value) -> value + 1);
			}else {
				map.put(num, 1);
			}
		}
		for(Integer key : map.keySet()) {
			deque.offer(new int[]{key, map.get(key)});
		}
		int[] res = new int[k];
		for(int i = 0; i < k; i++) {
			res[i] = deque.poll()[0];
		}
		return res;
	}

}
