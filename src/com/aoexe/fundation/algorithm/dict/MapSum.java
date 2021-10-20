package com.aoexe.fundation.algorithm.dict;

/**
 * 键值映射
 * 
 * 输入： ["MapSum", "insert", "sum", "insert", "sum"] [[], ["apple", 3], ["ap"],
 * ["app", 2], ["ap"]] 输出： [null, null, 3, null, 5]
 * 
 *
 * @author chenyuxian
 * @date 2021-10-19 20:09:50
 */
public class MapSum {

	Trie root;

	public MapSum() {
		root = new Trie();
	}

	public void insert(String key, int val) {
		Trie node = root;
		for (char ch : key.toCharArray()) {
			int index = ch - 'a';
			if (node.children[index] == null) {
				node.children[index] = new Trie();
			}
			node = node.children[index];
		}
		node.isEnd = true;
		node.val = val;
	}

	public int sum(String prefix) {
		Trie node = root;
		for (int i = 0; i < prefix.length(); i++) {
			node = node.children[prefix.charAt(i) - 'a'];
			if (node == null) {
				return 0;
			}
		}
		return dfs(node);
	}

	private int dfs(Trie node) {
		int sum = node.val;
		for (Trie child : node.children) {
			if (child != null) {
				sum += dfs(child);
			}
		}
		return sum;
	}

	class Trie {
		boolean isEnd;
		int val;
		Trie[] children;

		public Trie() {
			isEnd = false;
			val = 0;
			children = new Trie[26];
		}
	}
}
