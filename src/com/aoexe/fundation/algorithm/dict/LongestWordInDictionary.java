package com.aoexe.fundation.algorithm.dict;

/**
 * 词典中最长的单词
 * 
 * 输入： words = ["w","wo","wor","worl", "world"] 输出："world"
 *
 * 输入： words = ["a", "banana", "app", "appl", "ap", "apply", "apple"] 输出："apple"
 * 
 * @author chenyuxian
 * @date 2021-10-18 21:35:49
 */
public class LongestWordInDictionary {

	Trie root = new Trie();

	String result = "";

	public String longestWord(String[] words) {
		for (int i = 0; i < words.length; i++) {
			build(words[i], i);
		}
		dfs(root, words);
		return result;
	}

	public void dfs(Trie node, String[] words) {
		if (!node.isEnd && node != root) {
			return;
		}

		if (node.index != -1 && words[node.index].length() > result.length()) {
			result = words[node.index];
		}

		for (Trie child : node.children) {
			if (child != null) {
				dfs(child, words);
			}
		}
	}

	public void build(String word, int i) {
		Trie node = root;
		for (char ch : word.toCharArray()) {
			int index = ch - 'a';
			if (node.children[index] == null) {
				node.children[index] = new Trie();
			}
			node = node.children[index];
		}
		node.isEnd = true;
		node.index = i;
	}

	class Trie {
		boolean isEnd;
		int index;
		Trie[] children;

		public Trie() {
			isEnd = false;
			index = -1;
			children = new Trie[26];
		}
	}
}
