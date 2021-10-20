package com.aoexe.fundation.algorithm.string;

public class Trie {

	private boolean isEnd;

	private Trie[] children;

	public Trie() {
		isEnd = false;
		children = new Trie[26];
	}

	public void insert(String word) {
		Trie node = this;
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
		Trie node = searchPrefix(word);
		return node != null && node.isEnd;
	}

	public boolean startsWith(String prefix) {
		return searchPrefix(prefix) != null;
	}

	private Trie searchPrefix(String prefix) {
		Trie node = this;
		for (int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
			int index = ch - 'a';
			if (node.children[index] == null) {
				return null;
			}
			node = node.children[index];
		}
		return node;
	}
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
