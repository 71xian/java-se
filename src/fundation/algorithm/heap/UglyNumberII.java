package fundation.algorithm.heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 丑数
 * 
 * @author Administrator
 * @date 2021-10-23 21:20:24
 */
public class UglyNumberII {

	public int nthUglyNumber(int n) {
		int[] num = { 2, 3, 5 };
		Set<Long> set = new HashSet<>();
		PriorityQueue<Long> queue = new PriorityQueue<>();
		set.add(1L);
		queue.add(1L);
		long cur = 0;
		int k = 1;
		while (k <= n) {
			cur = queue.poll();
			for (int i = 0; i < num.length; i++) {
				long next = cur * num[i];
				if (set.add(next)) {
					queue.offer(next);
				}
			}
			k++;
		}
		return (int) cur;
	}
}
