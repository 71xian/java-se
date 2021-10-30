package fundation.algorithm.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 根据字符出现频率排序
 * @author Administrator
 * @date 2021-10-25 14:27:14
 */
public class SortCharactersByFrequency {

	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			if (!map.containsKey(ch)) {
				map.put(ch, 1);
			}else {
				map.compute(ch, (key, value) -> value + 1);				
			}
		}
		PriorityQueue<int[]> deque = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		for (Character key : map.keySet()) {
			deque.offer(new int[] { map.get(key), key });
		}
		StringBuilder sb = new StringBuilder();
		while(!deque.isEmpty()) {
			int[] max = deque.poll();
			for(int i = 0; i < max[0]; i++) {
				sb.append((char) max[1]);
			}
		}
		return sb.toString();
	}
}
