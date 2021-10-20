package com.aoexe.fundation.algorithm.coder;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {

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
		if (sonNodes.isEmpty()) {
			trees.add(new ArrayList<>(path));
			return;
		}
		List<TreeNode> temp = new ArrayList<>(sonNodes);
		for (int i = 0; i < sonNodes.size(); i++) {
			TreeNode son = sonNodes.get(i);
			path.add(son.val);
			// 子节点走过之后就变成了父节点，需要删掉
			sonNodes.remove(i);
			if (son.left != null) {
				sonNodes.add(son.left);
			}
			if (son.right != null) {
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
