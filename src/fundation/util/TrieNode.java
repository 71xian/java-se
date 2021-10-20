package fundation.util;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	boolean isEnd;

	Map<Character, TrieNode> children;

	public TrieNode() {
		isEnd = false;
		children = new HashMap<>(8);
	}
}
