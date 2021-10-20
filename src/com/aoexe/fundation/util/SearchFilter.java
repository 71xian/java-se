package com.aoexe.fundation.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SearchFilter {

	TrieNode root;

	public void init(Collection<String> words) {
		if (root != null || words.isEmpty()) {
			return;
		}
		Set<Integer> set = new HashSet<>();
		set.con root = new TrieNode();
		for (String word : words) {
			if (word.isEmpty()) {
				continue;
			}
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				if (!node.children.containsKey(word.charAt(i))) {
					node.children.put(word.charAt(i), new TrieNode());
				}
				node = node.children.get(word.charAt(i));
			}
			node.isEnd = true;
		}
	}

	private SearchFilter() {

	}

	public static final SearchFilter INSTANCE = new SearchFilter();

	public boolean search(final String txt) {
		TrieNode node = root;
		for (int i = 0; i < txt.length(); i++) {
			if (node.children.containsKey(txt.charAt(i))) {

			}
		}
	}

}
