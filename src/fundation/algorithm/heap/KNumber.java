package fundation.algorithm.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KNumber {

	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> res = new ArrayList<>();
		PriorityQueue<int[]> deque = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		for (int i = 0; i < Math.min(k, nums1.length); i++) {
			for (int j = 0; j < Math.min(k, nums2.length); j++) {
				deque.offer(new int[] { nums1[i] + nums2[j], nums1[i], nums2[j] });
			}
		}
		int sum = 0;
		while (sum < k && !deque.isEmpty()) {
			int[] min = deque.poll();
			res.add(Arrays.asList(min[1], min[2]));
			sum++;
		}
		return res;
	}
}
