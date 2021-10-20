package com.aoexe.fundation.algorithm.coder;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution2 {

	public ListNode removeDuplicateNodes(ListNode head) {
		ListNode node = head;
		ListNode prev = null;
		Set<Integer> set = new HashSet<>();
		while (node != null) {
			if (!set.contains(node.val)) {
				set.add(node.val);
				prev = node;
			} else {
				prev.next = node.next;
			}
			node = node.next;
		}
		return head;
	}

	public int kthTofrom(ListNode head, int k) {
		int sum = 0;
		ListNode slow = head;
		ListNode fast = head;
		while (sum != k) {
			sum++;
			fast = fast.next;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow.val;
	}

	// 删除node节点，不需要知道前缀节点
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode node = head;
		ListNode max = new ListNode(0);
		ListNode min = new ListNode(0);
		ListNode maxStart = max;
		ListNode minStart = min;
		while (node != null) {
			ListNode next = new ListNode(node.val);
			if (node.val < x) {
				min.next = next;
				min = min.next;
			} else {
				max.next = next;
				max = max.next;
			}
			node = node.next;
		}
		if (maxStart.next != null) {
			maxStart.val = maxStart.next.val;
			maxStart.next = maxStart.next.next;
			min.next = maxStart;
		}
		if (minStart.next != null) {
			minStart.val = minStart.next.val;
			minStart.next = minStart.next.next;
		}
		return minStart;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode head = result;
		ListNode prev = null;
		while (l1 != null && l2 != null) {
			prev = result;
			result.val += l1.val + l2.val;
			l1 = l1.next;
			l2 = l2.next;
			result.next = new ListNode(0);
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
			result.next = new ListNode(0);
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

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		Stack<Integer> stack = new Stack<>();
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			stack.push(head.val);
			head = head.next;
			fast = fast.next.next;
		}
		if (fast != null && fast.next == null) {
			head = head.next;
		}
		while (head != null) {
			if (stack.pop() != head.val) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode h1 = headA, h2 = headB;
		while (h1 != h2) {
			h1 = h1 == null ? headB : h1.next;
			h2 = h2 == null ? headA : h2.next;
		}
		return h1;
	}

	public ListNode detectCycle(ListNode head) {
		ListNode slow = head, fast = head;
		while (head != null) {
			if (slow == fast) {
				return slow;
			}
			slow = slow.next;
			fast = fast.next.next;
			head = head.next;
		}
		return null;
	}
}
