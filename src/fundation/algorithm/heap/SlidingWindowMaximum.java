package fundation.algorithm.heap;

import java.util.LinkedList;

/**
 * 滑动窗口最大值
 *
 * @author chenyuxian
 * @date 2021-10-23 17:42:25
 */
public class SlidingWindowMaximum {

	public int[] maxSlidingWindow(int[] nums, int k) {
		LinkedList<Integer> list = new LinkedList<>();
		int[] res = new int[nums.length - k + 1];
		list.offerFirst(0);
		for (int i = 0; i < nums.length; i++) {
			while (!list.isEmpty() && nums[list.getLast()] <= nums[i]) {
				list.removeLast();
			}
			list.offerLast(i);
			if(list.getFirst() <= i - k) {
				list.removeFirst();
			}
			if (i + 1 - k >= 0) {
				res[i + 1 - k] = nums[list.getFirst()];
			}
		}
		return res;
	}
}
