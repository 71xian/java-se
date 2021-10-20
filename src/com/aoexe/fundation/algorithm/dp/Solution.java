package com.aoexe.fundation.algorithm.dp;

import java.util.Arrays;

public class Solution {

	public int fib(int n) {
		if (n <= 1) {
			return n;
		}
		int i = 2;
		int one = 0;
		int two = 1;
		int three = 0;
		while (i <= n) {
			three = one + two;
			one = two;
			two = three;
			i++;
		}
		return three;
	}

	public int tribonacci(int n) {
		if (n <= 1) {
			return n;
		}
		if (n == 2) {
			return 1;
		}
		int i = 3;
		int one = 0;
		int two = 1;
		int three = 1;
		int four = 0;
		while (i <= n) {
			four = three + two + one;
			one = two;
			two = three;
			three = four;
			i++;
		}
		return four;
	}

	public int climbStairs(int n) {
		if (n <= 2) {
			return n;
		}
		int a = 1;
		int b = 2;
		int k = 3;
		int temp;
		while (k <= n) {
			temp = b;
			b += a;
			a = temp;
			k++;
		}
		return b;
	}

	public int minCostClimbingStairs(int[] cost) {
		int a = cost[0];
		int b = cost[1];
		int temp;
		for (int i = 2; i < cost.length; i++) {
			temp = b;
			b = Math.min(a, b) + cost[i];
			a = temp;
		}
		return Math.min(a, b);
	}

	public int rob1(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int a = nums[0];
		int b = Math.max(nums[0], nums[1]);
		int temp;
		for (int i = 2; i < nums.length; i++) {
			temp = b;
			b = Math.max(a + nums[i], b);
			a = temp;
		}
		return Math.max(a, b);
	}

	public int rob2(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int[] one = Arrays.copyOfRange(nums, 0, nums.length - 1);
		int[] two = Arrays.copyOfRange(nums, 1, nums.length);
		return Math.max(rob1(one), rob1(two));
	}

	public int deleteAndEarn(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int[] sum = new int[10001];
		for (int num : nums) {
			sum[num]++;
		}
		int a = sum[1];
		int b = Math.max(a, sum[2] * 2);
		int temp;
		for (int i = 3; i < sum.length; i++) {
			temp = b;
			b = Math.max(a + sum[i] * i, b);
			a = temp;
		}
		return b;
	}

	public boolean canJump(int[] nums) {
		int max = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (i <= max) {
				max = Math.max(max, i + nums[i]);
			}
		}
		return max >= nums.length - 1;
	}

	public int jump(int[] nums) {
		int max = 0;
		int len = 0;
		int step = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > len) {
				len = max;
				step++;
			}
			max = Math.max(i + nums[i], max);
		}
		return step;
	}

	public int maxSubArray(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = nums[0];
		int max = nums[0];
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
