package fundation.project;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	boolean isEnd;
	
	int depth;
	
	Map<Character, TrieNode> children;
	
	TrieNode fail;
	
	public TrieNode() {
		// TODO Auto-generated constructor stub
		children = new HashMap<>(8);
	}
}
