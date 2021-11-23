package fundation.project.ac;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	Map<Character, TrieNode> children;

	TrieNode fail;

	int max;

	int min;

	int index;

	public TrieNode() {
		// TODO Auto-generated constructor stub
		children = new HashMap<>();
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		index = -1;
	}
}
