package com.aoexe.fundation.algorithm.dict;

import java.util.List;

/**
 * 单词替换
 * 
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery" 
 * 输出："the cat was rat by the bat"
 * 
 *
 * @author chenyuxian
 * @date 2021-10-19 13:32:34
 */
public class ReplaceWords {

	Trie root = new Trie();

	public String replaceWords(List<String> dictionary, String sentence) {
		for (int i = 0; i < dictionary.size(); i++) {
			build(dictionary.get(i), i);
		}
		String[] words = sentence.split(" ");
		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			Trie node = root;
			for (char ch : word.toCharArray()) {
				int index = ch - 'a';
				if (node.isEnd || node.children[index] == null) {
					break;
				}
				node = node.children[index];
			}
			if (node.isEnd) {
				sb.append(dictionary.get(node.index));
			}else {
				sb.append(word);
			}
			sb.append(' ');
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
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
		boolean isEnd = false;
		int index = -1;
		Trie[] children = new Trie[26];
	}
}
