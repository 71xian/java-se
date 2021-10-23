package fundation.algorithm.heap;

import java.util.PriorityQueue;

/**
 * 滑动窗口最大值
 *
 * @author chenyuxian
 * @date 2021-10-23 17:42:25
 */
public class SlidingWindowMaximum {

	public int[] maxSlidingWindow(int[] nums, int k) {
		PriorityQueue<Integer> deque = new PriorityQueue<>((o1, o2) -> o2 - o1);
		for(int i = 0; i < k; i++) {
			deque.add(nums[i]);
		}
		if (nums.length == k) {
			return new int[] { deque.peek() };
		}
		int[] res = new int[nums.length - k + 1];
		for(int i = k; i < nums.length; i++) {
			res[i - k] = deque.peek();
			if(deque.peek() <= nums[i - k]) {
				deque.remove(nums[i - k]);				
			}
			deque.add(nums[i]);
		}
		res[res.length - 1] = deque.peek();
		return res;
	}
}
