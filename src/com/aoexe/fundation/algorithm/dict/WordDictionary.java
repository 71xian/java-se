package com.aoexe.fundation.algorithm.dict;

public class WordDictionary {

	Trie root;

	public WordDictionary() {
		root = new Trie();
	}

	public void addWord(String word) {
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

	public boolean search(String word) {
		return search(word.toCharArray(), 0, root);
	}

	private boolean search(char[] chs, int start, Trie node) {
		if (node == null) {
			return false;
		}
		if (start == chs.length) {
			return node.isEnd;
		}
		if (chs[start] == '.') {
			for (Trie child : node.children) {
				if (child != null) {
					if (search(chs, start + 1, child)) {
						return true;
					}
				}
			}
			return false;
		}
		int index = chs[start] - 'a';
		if (node.children[index] == null) {
			return false;
		}
		return search(chs, start + 1, node.children[index]);
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
