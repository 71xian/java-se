package fundation.project.dat;

import java.util.TreeMap;

public class TrieNode {

	boolean end;

	int index;

	int left;

	int right;

	int depth;
	
	char ch;

	TreeMap<Character, TrieNode> children;

	TrieNode failure;

	public TrieNode() {
		children = new TreeMap<>();
		left = Integer.MAX_VALUE;
		right = Integer.MIN_VALUE;
	}
}
