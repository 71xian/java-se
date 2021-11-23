package fundation.algorithm;

import java.util.Arrays;
import java.util.Stack;

public class StringSolution {

	public String longestPalindrome(String s) {
		int left = 0;
		int right = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				int[] n = find(s, i, i + 1);
				if (n[1] - n[0] > right - left) {
					right = n[1];
					left = n[0];
				}
			}
			int[] n = find(s, i, i);
			if (n[1] - n[0] > right - left) {
				right = n[1];
				left = n[0];
			}
		}
		return s.substring(left, right + 1);
	}

	private int[] find(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return new int[] { left + 1, right - 1 };
	}

	public String longestCommonPrefix(String[] strs) {
		int start = 0;
		int end = strs[0].length();
		for (int i = 1; i < strs.length; i++) {
			end = Math.min(end, strs[i].length());
			for (int j = 0; j < end; j++) {
				if (strs[0].charAt(j) != strs[i].charAt(j)) {
					end = j;
					break;
				}
			}
			if (end == 0) {
				return "";
			}
		}
		return strs[0].substring(start, end);
	}

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (right > left) {
				int result = nums[right] + nums[left] + nums[i];
				if (result > target) {
					right--;
				} else if (result < target) {
					left++;
				} else {
					return target;
				}
			}
		}
		return 0;
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
				continue;
			}
			if (stack.isEmpty()) {
				if (ch == ')' || ch == '}' || ch == ']') {
					return false;
				}
			} else {
				if ((ch == ')' && stack.peek() == '(') || (ch == '}' && stack.peek() == '{')
						|| (ch == ']' && stack.peek() == '[')) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode res = null;
		if (l1.val < l2.val) {
			res = l1;
			while (l1.next != null && l2.next != null) {
				if (l2.val > l1.val) {
					l1 = l1.next;
				} else {
					ListNode temp = l2;
					l2 = l2.next;
					temp.next = l1;
				}
			}
		} else {
			res = l2;
		}
		return res;
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
