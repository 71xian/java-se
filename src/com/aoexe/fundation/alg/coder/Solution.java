package com.aoexe.fundation.alg.coder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution {

	public boolean isUnique(String astr) {
		Set<Character> set = new HashSet<>();
		for (char ch : astr.toCharArray()) {
			if (set.contains(ch)) {
				return false;
			} else {
				set.add(ch);
			}
		}
		return true;
	}

	public boolean CheckPermutation(String s1, String s2) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s1.toCharArray()) {
			Integer num = map.get(ch);
			if (map.containsKey(ch)) {
				map.put(ch, ++num);
			} else {
				map.put(ch, 1);
			}
		}
		for (char ch : s2.toCharArray()) {
			if (!map.containsKey(ch)) {
				return false;
			} else {
				int num = map.get(ch);
				if (num == 0) {
					return false;
				} else {
					map.put(ch, --num);
				}
			}
		}
		return true;
	}

	public String replaceSpaces(String S, int length) {
		char[] array = S.toCharArray();
		char[] result = new char[S.length()];
		int k = 0;
		for (int i = 0; i < length; i++) {
			if (array[i] == ' ') {
				result[k++] = '%';
				result[k++] = '2';
				result[k++] = '0';
			} else {
				result[k++] = array[i];
			}
		}
		return new String(result, 0, k);
	}

	public boolean canPermutePalindrome(String s) {
		Set<Character> set = new HashSet<>();
		for (char ch : s.toCharArray()) {
			if (set.contains(ch)) {
				set.remove(ch);
			} else {
				set.add(ch);
			}
		}
		return set.size() <= 1;
	}

	public boolean oneEditAway(String to, String second) {
		int len = to.length() - second.length();
		if (len == 0) {
			boolean flag = false;
			for (int i = 0; i < to.length(); i++) {
				if (to.charAt(i) != second.charAt(i)) {
					if (flag) {
						return false;
					}
					flag = true;
				}
			}
			return true;
		}

		if (Math.abs(len) == 1) {
			len = Math.min(to.length(), second.length());
			int l = 0;
			int s = 0;
			boolean flag = false;
			for (int i = 0; i < len; i++) {
				if (to.charAt(l) != second.charAt(s)) {
					i--;
					if (flag) {
						return false;
					}
					if (to.length() < second.length()) {
						s++;
					} else {
						l++;
					}
					flag = true;
					continue;
				}
				s++;
				l++;
			}
			return true;
		}
		return false;
	}

	public String compressString(String S) {
		if (S.isEmpty()) {
			return S;
		}
		int fast = 0;
		int slow = 0;
		StringBuilder builder = new StringBuilder();
		while (fast < S.length()) {
			if (S.charAt(slow) != S.charAt(fast)) {
				builder.append(S.charAt(slow));
				builder.append(fast - slow);
				slow = fast;
			}
			fast++;
		}
		builder.append(S.charAt(slow));
		builder.append(fast - slow);
		String result = builder.toString();
		if (result.length() < S.length()) {
			return result;
		} else {
			return S;
		}
	}

	public void rotate(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[i].length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix[i].length - j - 1];
				matrix[i][matrix[i].length - j - 1] = temp;
			}
		}
	}

	public void setZeroes(int[][] matrix) {
		int[] row = new int[matrix.length * matrix[0].length];
		int[] col = new int[matrix.length * matrix[0].length];
		int k = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					row[k] = i;
					col[k] = j;
					k++;
				}
			}
		}
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[row[i]][j] = 0;
			}
			for (int v = 0; v < matrix.length; v++) {
				matrix[v][col[i]] = 0;
			}
		}
	}

	public boolean isFlipedString(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		if (s1.equals(s2)) {
			return true;
		}
		return (s2 + s2).contains(s1);
	}

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

	public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
		if (start == target)
			return true;
		for (int[] edge : graph) {
			if (edge[1] == target) {
				return findWhetherExistsPath(n, graph, start, edge[0]);
			}
		}
		return false;
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 1) {
			return new TreeNode(nums[0]);
		}
		return buildTree(0, nums.length, nums);
	}

	private TreeNode buildTree(int left, int right, int[] nums) {
		if (right <= left) {
			return null;
		}
		int medium = left + (right - left) / 2;
		TreeNode root = new TreeNode(nums[medium]);
		root.left = buildTree(left, medium, nums);
		root.right = buildTree(medium + 1, right, nums);
		return root;
	}

	public ListNode[] listOfDepth(TreeNode tree) {
		List<ListNode> list = new ArrayList<>();
		ListNode node = new ListNode(tree.val);
		List<TreeNode> link = new ArrayList<>();
		link.add(tree);
		list.add(node);
		while (true) {
			link = buildLink(link);
			node = linkedDepth(link);
			if (node == null) {
				break;
			}
			list.add(node);
		}
		return list.toArray(new ListNode[1]);
	}

	private ListNode linkedDepth(List<TreeNode> root) {
		if (root.isEmpty()) {
			return null;
		}
		ListNode list = new ListNode(0);
		ListNode start = list;
		for (TreeNode node : root) {
			list.val = node.val;
			if (node == root.get(root.size() - 1)) {
				break;
			}
			list.next = new ListNode(0);
			list = list.next;
		}
		return start;
	}

	private List<TreeNode> buildLink(List<TreeNode> link) {
		List<TreeNode> result = new ArrayList<>();
		for (TreeNode node : link) {
			if (node.left != null) {
				result.add(node.left);
			}
			if (node.right != null) {
				result.add(node.right);
			}
		}
		return result;
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		int left = root.left == null ? 0 : treeDepth(root.left) + 1;
		int right = root.right == null ? 0 : treeDepth(root.right) + 1;
		if (left == -1 || right == -1) {
			return false;
		}
		return Math.abs(right - left) <= 1;
	}

	private int treeDepth(TreeNode node) {
		int leftDepth = node.left == null ? 0 : treeDepth(node.left) + 1;
		int rightDepth = node.right == null ? 0 : treeDepth(node.right) + 1;
		if (leftDepth == -1 || rightDepth == -1) {
			return -2;
		}
		if (Math.abs(rightDepth - leftDepth) > 1) {
			return -2;
		}
		return Math.max(leftDepth, rightDepth);
	}

	TreeNode prev = null;
	boolean flag = true;

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		validBST(root);
		return flag;
	}

	private void validBST(TreeNode node) {
		if (flag && node != null) {
			validBST(node.left);
			if (prev != null) {
				if (prev.val >= node.val) {
					flag = false;
				}
			}
			prev = node;
			validBST(node.right);
		}
	}

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		setPrev(root, p);
		return prev == p ? null : prev;
	}

	private void setPrev(TreeNode root, TreeNode p) {
		if (root != null) {
			setPrev(root.left, p);
			if (prev != null && prev != p) {
				return;
			}
			if (prev == p) {
				prev = root;
			}
			if (root == p) {
				prev = p;
			}
			setPrev(root.right, p);
		}
	}

	TreeNode ans = null;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root == p || root == q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}

	private List<List<Integer>> trees;

	public List<List<Integer>> BSTSequences(TreeNode root) {
		trees = new ArrayList<>();
		if (root == null) {
			trees.add(new ArrayList<>());
			return trees;
		}
		List<Integer> path = new ArrayList<>();
		path.add(root.val);
		List<TreeNode> sonNodes = new ArrayList<>();
		if (root.left != null) {
			sonNodes.add(root.left);
		}
		if (root.right != null) {
			sonNodes.add(root.right);
		}
		dfs(sonNodes, path);
		return trees;
	}

	private void dfs(List<TreeNode> sonNodes, List<Integer> path) {
		// 说明走完了路径，已经没有子节点了
		if(sonNodes.isEmpty()) {
			trees.add(new ArrayList<>(path));
			return;
		}
		List<TreeNode> temp = new ArrayList<>(sonNodes);
		for(int i = 0; i < sonNodes.size(); i++) {
			TreeNode son = sonNodes.get(i);
			path.add(son.val);
			// 子节点走过之后就变成了父节点，需要删掉
			sonNodes.remove(i);
			if(son.left != null) {
				sonNodes.add(son.left);
			}
			if(son.right != null) {
				sonNodes.add(son.right);
			}
			dfs(sonNodes, path);
			// 进行到这一步说明已经找到了一条路径了
			// 逐步恢复成原来的路径
			path.remove(path.size() - 1);
			sonNodes = new ArrayList<>(temp);
		}
	}

	boolean sub = true;

	TreeNode root = null;

	public boolean checkSubTree(TreeNode t1, TreeNode t2) {
		getTreeNode(t1, t2.val);
		if (root == null) {
			return false;
		}
		subTree(root, t2);
		return sub;
	}

	private void getTreeNode(TreeNode root, int val) {
		if (root != null && this.root == null) {
			if (root.val == val) {
				this.root = root;
			}
			getTreeNode(root.left, val);
			getTreeNode(root.right, val);
		}
	}

	private void subTree(TreeNode t1, TreeNode t2) {
		if (sub) {
			if (t1 != null && t2 != null) {
				if (t1.val != t2.val) {
					sub = false;
				} else {
					subTree(t1.left, t2.left);
					subTree(t1.right, t2.right);
				}
			} else {
				if (t1 == null && t2 == null) {

				} else {
					sub = false;
				}
			}
		}
	}

	private int treeSum = 0;

	public int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		eachNode(root, 0, sum);
		return treeSum;
	}

	private void getPathSum(TreeNode root, int val, int num) {
		if (root != null) {
			val += root.val;
			System.out.println(val);
			if (val == num) {
				treeSum++;
			}
			getPathSum(root.left, val, num);
			getPathSum(root.right, val, num);
		}
	}

	private void eachNode(TreeNode root, int val, int sum) {
		if (root != null) {
			getPathSum(root, val, sum);
			eachNode(root.left, val, sum);
			eachNode(root.right, val, sum);
		}
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
