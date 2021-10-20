package fundation.algorithm.dict;

import java.util.HashSet;
import java.util.Set;

public class MagicDictionary {

	private Trie root;

	private Set<String> set;

	public MagicDictionary() {
		root = new Trie();
		set = new HashSet<>();
	}

	public void buildDict(String[] dictionary) {
		for (String s : dictionary) {
			set.add(s);
			Trie node = root;
			for (char ch : s.toCharArray()) {
				int index = ch - 'a';
				if (node.children[index] == null) {
					node.children[index] = new Trie();
				}
				node = node.children[index];
			}
			node.isEnd = true;
		}
	}

	public boolean search(String searchWord) {
		char[] word = searchWord.toCharArray();
		if (set.contains(searchWord)) {
			return bfs(word, 0, root);
		} else {
			return dfs(word, 0, root, true);
		}
	}

	private boolean dfs(char[] word, int start, Trie node, boolean unused) {
		if (start == word.length) {
			return node.isEnd;
		}
		int index = word[start] - 'a';
		if (node.children[index] != null) {
			if(dfs(word, start + 1, node.children[index], unused)) {
				return true;
			}
		}
		if (unused) {
			unused = false;
			for (Trie child : node.children) {
				if (child != null) {
					if (dfs(word, start + 1, child, unused)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean bfs(char[] word, int depth, Trie node) {
		if (depth == word.length) {
			return false;
		}
		int index = word[depth] - 'a';
		for (int i = 0; i < 26; i++) {
			if (node.children[i] != null && i != index) {
				char ch = (char) ('a' + i);
				char temp = word[depth];
				word[depth] = ch;
				if (set.contains(String.valueOf(word))) {
					return true;
				}
				word[depth] = temp;
			}
		}
		return bfs(word, depth + 1, node.children[index]);
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
