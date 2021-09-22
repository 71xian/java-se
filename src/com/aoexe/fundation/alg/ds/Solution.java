package com.aoexe.fundation.alg.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			int size = set.size();
			set.add(i);
			if (set.size() == size) {
				return true;
			}
		}
		return false;
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

	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[nums.length];
		int k = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				result[k++] = map.get(target - nums[i]);
				result[k++] = i;
			}
			map.put(nums[i], i);
			if (!map.containsKey(nums[i])) {
			}
		}
		return Arrays.copyOf(result, k);
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if (m == 0) {
			System.arraycopy(nums2, 0, nums1, 0, n);
			return;
		}
		if (n == 0) {
			return;
		}
		int one = m - 1;
		int two = n - 1;
		int i = nums1.length - 1;
		while (i >= 0) {
			if (nums2[two] >= nums1[one]) {
				nums1[i] = nums2[two];
				two--;
			} else {
				nums1[i] = nums1[one];
				one--;
			}
			if (two < 0) {
				return;
			}
			if (one < 0) {
				System.arraycopy(nums2, 0, nums1, 0, two + 1);
				return;
			}
			i--;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode();
		ListNode head = result;
		ListNode prev = null;
		while (l1 != null && l2 != null) {
			prev = result;
			result.val += l1.val + l2.val;
			l1 = l1.next;
			l2 = l2.next;
			result.next = new ListNode();
			if (result.val >= 10) {
				result.val -= 10;
				result.next.val += 1;
			}
			result = result.next;
		}
		ListNode end = l1 == null ? l2 : l1;
		while (end != null) {
			prev = result;
			result.val += end.val;
			end = end.next;
			result.next = new ListNode();
			if (result.val >= 10) {
				result.val -= 10;
				result.next.val += 1;
			}
			result = result.next;
		}
		if (result.val == 0) {
			prev.next = null;
		}
		return head;
	}

	public int lengthOfLongestSubstring(String s) {
		if (s.length() <= 1) {
			return s.length();
		}
		int max = 0;
		int start = 0;
		int end = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			if (map.containsKey(ch)) {
				max = Math.max(end - start, max);
				start = map.get(ch) + 1;
				map.clear();
				int j = start;
				while (j < end) {
					map.put(s.charAt(j), j);
					j++;
				}
			}
			map.put(ch, end);
			end++;
		}
		return Math.max(end - start, max);
	}

	public int[] intersect(int[] nums1, int[] nums2) {
		int[] max, min;
		max = nums1.length > nums2.length ? nums1 : nums2;
		min = nums1.length <= nums2.length ? nums1 : nums2;
		int[] result = new int[min.length];
		int size = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : min) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		for (int i : max) {
			if (map.containsKey(i)) {
				result[size++] = i;
				int value = map.get(i) - 1;
				map.put(i, value);
				if (value == 0) {
					map.remove(i);
				}
			}
		}
		if (size == min.length) {
			return min;
		}
		return Arrays.copyOf(result, size);
	}

	public int maxProfit(int[] prices) {
		if (prices.length <= 1) {
			return 0;
		}
		int min = prices[0];
		int max = 0;
		for (int i = 1; i < prices.length; i++) {
			min = Math.min(prices[i], min);
			max = Math.max(prices[i] - min, max);
		}
		return max;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int len = solution.lengthOfLongestSubstring("abcabcbb");
		System.out.println(len);
	}

	public int[][] matrixReshape(int[][] mat, int r, int c) {
		int mr = mat.length;
		int mc = mat[0].length;
		if (r * c != mr * mc) {
			return mat;
		}
		int kr = 0;
		int kc = 0;
		int[][] result = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (kc == mc) {
					kr++;
					kc = 0;
				}
				result[i][j] = mat[kr][kc];
				kc++;
			}
		}
		return result;
	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		if (numRows == 0) {
			return result;
		}
		List<Integer> start = new ArrayList<>();
		start.add(1);
		result.add(start);
		List<Integer> prev = start;
		for (int i = 1; i < numRows; i++) {
			List<Integer> row = new ArrayList<>();
			for (int j = 0; j < i + 1; j++) {
				int l = j - 1 >= 0 ? prev.get(j - 1) : 0;
				int r = j < i ? prev.get(j + 1) : 0;
				row.add(l + r);
			}
			prev = row;
			result.add(row);
		}
		return result;
	}

	public boolean isValidSudoku(char[][] board) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				if (set.contains(board[i][j])) {
					return false;
				} else {
					set.add(board[i][j]);
				}
			}
			set.clear();
		}
		for (int j = 0; j < board[0].length; j++) {
			for (int i = 0; i < board.length; i++) {
				if (board[i][j] == '.') {
					continue;
				}
				if (set.contains(board[i][j])) {
					return false;
				} else {
					set.add(board[i][j]);
				}
			}
			set.clear();
		}
		int r = 0;
		int c = 0;
		for (int k = 0; k < 9; k++) {
			for (int i = r * 3; i < 3 + r * 3; i++) {
				for (int j = c * 3; j < 3 + c * 3; j++) {
					if (board[i][j] == '.') {
						continue;
					}
					if (set.contains(board[i][j])) {
						return false;
					} else {
						set.add(board[i][j]);
					}
				}
			}
			c++;
			if (c == 3) {
				c = 0;
				r++;
			}
			set.clear();
		}
		return true;
	}

	public void setZeroes(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		boolean flagCol0 = false;
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0) {
				flagCol0 = true;
			}
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = matrix[0][j] = 0;
				}
			}
		}
		for (int i = m - 1; i >= 0; i--) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
			if (flagCol0) {
				matrix[i][0] = 0;
			}
		}
	}

	public boolean canConstruct(String ransomNote, String magazine) {
		Map<Character, Integer> map = new HashMap<>();
		for(char ch : ransomNote.toCharArray()) {
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			}else {
				map.put(ch, 1);
			}
		}
		for(char ch : magazine.toCharArray()) {
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch) - 1);
				if(map.get(ch) == 0) {
					map.remove(ch);
				}
			}else {
				return false;
			}
		}
		return map.isEmpty();
	}
	
	 public boolean isAnagram(String s, String t) {
		 if(s.length() != t.length()) {
			 return false;
		 }
		 int[] chs = new int[26];
		 int index = 0;
		 for(int i = 0; i < s.length(); i++) {
			 index = s.charAt(i) - 97;
			 chs[index]++;
			 index = t.charAt(i) - 97;
			 chs[index]--;
		 }
		 for(int i : chs) {
			 if(i != 0) {
				 return false;
			 }
		 }
		 return true;
	 }
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
