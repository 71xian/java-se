package com.aoexe.fundation.algorithm.dict;

import java.util.List;

/**
 * 回文对
 *
 * @author chenyuxian
 * @date 2021-10-20 09:55:13
 */
public class PalindromePairs {

	public List<List<Integer>> palindromePairs(String[] words) {
		return null;
	}

	class Trie {
		boolean isEnd;
		int pos;
		Trie[] next;

		public Trie() {
			isEnd = false;
			pos = 01;
			next = new Trie[26];
		}
	}
}
