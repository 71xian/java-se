package com.aoexe.fundation.algorithm.dict;

import java.util.ArrayList;
import java.util.List;

/**
 * 搜索推荐系统
 * 
 * 输入：products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * 输出：[ 
 * 		["mobile","moneypot","monitor"],
 * 		["mobile","moneypot","monitor"], 
 * 		["mouse","mousepad"], 
 * 		["mouse","mousepad"],
 * 		["mouse","mousepad"] 
 * ]
 *
 * 
 * @author chenyuxian
 * @date 2021-10-19 12:29:35
 */
public class SearchSuggestionsSystem {

	Trie root = new Trie();

	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		Trie node = root;
		for (int i = 0; i < products.length; i++) {
			build(products[i], i);
		}
		List<List<String>> result = new ArrayList<>();
		for (char ch : searchWord.toCharArray()) {
			List<String> list = new ArrayList<>();
			if (node != null) {
				Trie next = node.children[ch - 'a'];
				if (next != null) {
					dfs(next, products, list);
				}
				node = next;
			}
			result.add(list);
		}
		return result;
	}

	public void dfs(Trie node, String[] words, List<String> list) {
		if (node.isEnd && list.size() < 3) {
			list.add(words[node.index]);
		}

		for (Trie child : node.children) {
			if (child != null) {
				if (list.size() == 3) {
					return;
				}
				dfs(child, words, list);
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
