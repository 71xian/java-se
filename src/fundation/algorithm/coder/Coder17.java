package fundation.algorithm.coder;


public class Coder17 {

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
