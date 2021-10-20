package com.aoexe.fundation.algorithm.dict;

import java.util.ArrayList;
import java.util.List;

public class WordBreak2 {

	Trie root;

	List<String> list = new ArrayList<>();

	public List<String> wordBreak(String s, List<String> wordDict) {
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
		return list;
	}

	public boolean dfs(String s, int start, StringBuilder sb) {
		if (start == s.length()) {
			list.add(sb.toString());
			return true;
		}
		Trie node = root;
		for (int i = start; i < s.length(); i++) {
			int index = s.charAt(i) - 'a';
			node = node.children[index];
			StringBuilder next = new StringBuilder(sb.toString());
			next.append(s.charAt(i));
			if (node.isEnd) {
				next.append(' ');
			}
			if (dfs(s, i + 1, next)) {
				return false;
			}
		}
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
