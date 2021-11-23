package fundation.project;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	boolean isEnd;
<<<<<<< HEAD:src/fundation/project/TrieNode.java
	
	int depth;
	
	Map<Character, TrieNode> children;
	
	TrieNode fail;
	
	public TrieNode() {
		// TODO Auto-generated constructor stub
=======

	int depth;

	Map<Character, TrieNode> children;

	TrieNode fail;

	public TrieNode() {
>>>>>>> f9d433d (one):src/fundation/util/TrieNode.java
		children = new HashMap<>(8);
	}
}
