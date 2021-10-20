package com.aoexe.fundation.algorithm.struct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二叉树的序列化与反序列化
 *
 * @author chenyuxian
 * @date 2021-10-20 17:25:50
 */
public class Codec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(root.val).append(',');
		bfs(Arrays.asList(root.left, root.right), sb);
		sb.deleteCharAt(sb.length() - 2);
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.isEmpty()) {
			return null;
		}
		String[] tree = data.split(",");
		TreeNode root = new TreeNode(Integer.valueOf(tree[0]));
		
		return root;
	}

	private void bfs(List<TreeNode> parents, StringBuilder sb) {
		List<TreeNode> children = new ArrayList<>();
		boolean next = false;
		for (TreeNode parent : parents) {
			if (parent == null) {
				sb.append("null").append(',');
			} else {
				if (parent.left != null || parent.right != null) {
					next = true;
				}
				children.add(parent.left);
				children.add(parent.right);
				sb.append(parent.val).append(',');
			}
		}
		if (next) {
			bfs(children, sb);
		}
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