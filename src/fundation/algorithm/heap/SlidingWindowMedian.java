package fundation.algorithm.heap;

import java.util.PriorityQueue;

/**
 * 滑动窗口中位数
 * 
 * @author Administrator
 * @date 2021-10-25 14:29:10
 */
public class SlidingWindowMedian {

	public double[] medianSlidingWindow(int[] nums, int k) {
		PriorityQueue<int[]> left = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		PriorityQueue<int[]> right = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		double[] res = new double[nums.length - k + 1];
		for (int i = 0; i < k; i++) {
			right.offer(new int[] { nums[i], i });
			if (!left.isEmpty() && left.peek()[0] > right.peek()[0]) {
				left.offer(right.poll());
				right.offer(left.poll());
			}
			if (right.size() == left.size() + 2) {
				left.offer(right.poll());
			}
		}
		if ((k & 1) == 1) {
			res[0] = right.peek()[0];
		} else {
			res[0] = (left.peek()[0] + right.peek()[0]) / 2.0;
		}
		for (int i = k; i < nums.length; i++) {
			right.offer(new int[] { nums[i], i });
			left.offer(right.poll());
			while (!left.isEmpty() && i >= left.peek()[1] + k) {
				left.poll();
			}
			while (!right.isEmpty() && i >= right.peek()[1] + k) {
				right.poll();
			}
			if ((k & 1) == 1) {
				res[i - k + 1] = right.peek()[0];
			} else {
				res[i - k + 1] = (left.peek()[0] + right.peek()[0]) / 2.0;
			}
		}
		return res;
	}
}
