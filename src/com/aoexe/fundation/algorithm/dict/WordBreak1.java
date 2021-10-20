package com.aoexe.fundation.algorithm.dict;

import java.util.List;

public class WordBreak1 {

	Trie root;

	public boolean wordBreak(String s, List<String> wordDict) {
		root = new Trie();
		for (String word : wordDict) {
			Trie node = root;
			for (char ch : word.toCharArray()) {
				int index = ch - 'a';
				if (node.children[index] == null) {
					node.children[index] = new Trie();
				}
				node = node.children[index];
			}
			node.isEnd = true;
		}
		return dfs(s, 0, new boolean[300]);
	}

	public boolean dfs(String s, int start, boolean[] failMemo) {
		if (failMemo[start]) {
			return false;
		}
		if (start == s.length()) {
			return true;
		}
		Trie node = root;
		for (int i = start; i < s.length(); i++) {
			int index = s.charAt(i) - 'a';
			if (node.children[index] == null) {
				break;
			}
			node = node.children[index];
			if (node.isEnd && dfs(s, i + 1, failMemo)) {
				return true;
			}
		}
		failMemo[start] = true;
		return false;
	}

	class Trie {
		boolean isEnd;
		Trie[] children;

		public Trie() {
			isEnd = false;
			children = new Trie[26];
		}
	}

}
