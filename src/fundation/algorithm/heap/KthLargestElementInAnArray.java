package fundation.algorithm.heap;

import java.util.PriorityQueue;

/**
 * 数组中的第k个最大元素
 *
 * @author chenyuxian
 * @date 2021-10-23 17:26:58
 */
public class KthLargestElementInAnArray {

	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
		for(int num : nums) {
			queue.add(num);
		}
		for(int i = 0; i < k; i++) {
			queue.remove();
		}
		return queue.remove();
	}
}
