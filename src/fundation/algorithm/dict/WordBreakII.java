package fundation.algorithm.dict;

import java.util.ArrayList;
import java.util.List;

public class WordBreakII {

	Trie root = new Trie();

	List<String> res = new ArrayList<>();

	public List<String> wordBreak(String s, List<String> wordDict) {
		buildTrie(wordDict);
		dfs(s, 0, wordDict, new ArrayList<>());
		return res;
	}

	public void buildTrie(List<String> wordDict) {
		int i = 0;
		for (String word : wordDict) {
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
			i++;
		}
	}

	public void dfs(String s, int start, List<String> wordDict, List<Integer> list) {
		if (start == s.length()) {
			StringBuilder sb = new StringBuilder();
			for (Integer index : list) {
				sb.append(wordDict.get(index));
				sb.append(' ');
			}
			sb.deleteCharAt(sb.length() - 1);
			res.add(sb.toString());
			return;
		}
		Trie node = root;
		for (int i = start; i < s.length(); i++) {
			int index = s.charAt(i) - 'a';
			if (node.children[index] == null) {
				list.clear();
				return;
			}
			node = node.children[index];
			if (node.isEnd) {
				List<Integer> nextList = new ArrayList<>(list);
				nextList.add(node.index);
				dfs(s, i + 1, wordDict, nextList);
			}
		}
	}

	class Trie {
		boolean isEnd;
		Trie[] children;
		int index;

		public Trie() {
			isEnd = false;
			children = new Trie[26];
			index = -1;
		}
	}
}
