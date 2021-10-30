package fundation.algorithm.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 查找和最小的k对数字
 * 
 * @author Administrator
 * @date 2021-10-24 23:33:37
 */
public class FindKPairsWithSmallestSums {

	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> res = new ArrayList<>();
		PriorityQueue<int[]> deque = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				deque.offer(new int[] { nums1[i] + nums2[j], i, j });
			}
		}
		int sum = 0;
		while (sum < k && !deque.isEmpty()) {
			int[] min = deque.poll();
			res.add(Arrays.asList(nums1[min[1]], nums2[min[2]]));
			sum++;
		}
		return res;
	}

}
