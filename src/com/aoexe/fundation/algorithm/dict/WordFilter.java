package com.aoexe.fundation.algorithm.dict;

/**
 * 前缀和后缀搜索
 *
 * @author chenyuxian
 * @date 2021-10-19 21:14:59
 */
public class WordFilter {

	Trie root1;

	Trie root2;

	int length;

	public WordFilter(String[] words) {
		root1 = new Trie();
		root2 = new Trie();
		for (int i = 0; i < words.length; i++) {
			build(words[i], i);
		}
		length = words.length;
	}

	public int f(String prefix, String suffix) {
		Trie node1 = root1;
		Trie node2 = root2;
		for (int i = 0; i < prefix.length(); i++) {
			int index = prefix.charAt(i) - 'a';
			node1 = node1.next[index];
			if (node1 == null) {
				return -1;
			}
		}
		for (int i = suffix.length() - 1; i >= 0; i--) {
			int index = suffix.charAt(i) - 'a';
			node2 = node2.next[index];
			if (node2 == null) {
				return -1;
			}
		}
		int[] visited = new int[length];
		dfs(node1, visited);
		dfs(node2, visited);
		for (int i = visited.length - 1; i >= 0; i--) {
			if (visited[i] == 2) {
				return i;
			}
		}
		return -1;
	}

	private void dfs(Trie node, int[] visited) {
		if (node.isEnd) {
			if (visited[node.pos] == 1) {
				visited[node.pos] = 2;
			} else {
				visited[node.pos] = 1;
			}
		}

		for (Trie n : node.next) {
			if (n != null) {
				dfs(n, visited);
			}
		}
	}

	private void build(String word, int pos) {
		Trie n1 = root1, n2 = root2;
		int i1 = 0, i2 = word.length() - 1;
		while (i1 < word.length()) {
			int index1 = word.charAt(i1) - 'a';
			int index2 = word.charAt(i2) - 'a';
			if (n1.next[index1] == null) {
				n1.next[index1] = new Trie();
			}
			if (n2.next[index2] == null) {
				n2.next[index2] = new Trie();
			}
			n1 = n1.next[index1];
			n2 = n2.next[index2];
			i1++;
			i2--;
		}
		n1.isEnd = true;
		n2.isEnd = true;
		n1.pos = pos;
		n2.pos = pos;
	}

	class Trie {
		boolean isEnd;
		int pos;
		Trie[] next;

		public Trie() {
			isEnd = false;
			pos = -1;
			next = new Trie[26];
		}
	}
}
