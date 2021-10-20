package com.aoexe.fundation.algorithm.dict;

/**
 * 数组中两个数的最大异或值
 * 
 * 输入：nums = [3,10,5,25,2,8] 输出：28
 *
 * 输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70] 输出：127
 *
 * @author chenyuxian
 * @date 2021-10-19 00:01:29
 */
public class MaximumXorOfTwoNumbersInAnArray {

	Trie root = new Trie();

	int max = 0;

	public int findMaximumXOR(int[] nums) {
		for (int num : nums) {
			build(num);
		}
		dfs(root, root, 30, 0);
		return max;
	}

	public void dfs(Trie xor, Trie original, int k, int sum) {
		if (xor == null || original == null) {
			return;
		}
		if (k == 0) {
			max = Math.max(max, sum);
			return;
		}

		boolean flag = true;
		if (xor.left != null && original.right != null) {
			flag = false;
			sum += 1 << k;
			dfs(xor.left, original.right, k - 1, sum);
			sum -= 1 << k;
		}

		if (xor.right != null && original.left != null) {
			flag = false;
			sum += 1 << k;
			dfs(xor.right, original.left, k - 1, sum);
			sum -= 1 << k;
		}

		if (flag) {
			if (xor.left != null && original.left != null) {
				dfs(xor.left, original.left, k - 1, sum);
			}
			
			if (xor.right != null && original.right != null) {
				dfs(xor.right, original.right, k - 1, sum);
			}
		}

	}

	public void build(int num) {
		Trie node = root;
		int k = 30;
		while (k >= 0) {
			if ((num & (1 << k)) == 1) {
				if (node.left == null) {
					node.left = new Trie();
				}
				node = node.left;
			} else {
				if (node.right == null) {
					node.right = new Trie();
				}
				node = node.right;
			}
			k--;
		}
	}

	class Trie {
		Trie left;
		Trie right;
	}
}
