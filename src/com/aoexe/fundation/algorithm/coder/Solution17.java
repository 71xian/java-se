package com.aoexe.fundation.algorithm.coder;


public class Solution17 {

	Trie root = new Trie();
	

	
	class Trie {
		boolean isEnd;
		Trie[] children;

		public Trie() {
			isEnd = false;
			children = new Trie[26];
		}
	}
}
