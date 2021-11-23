package fundation.algorithm.heap;

import java.util.Arrays;

/**
 * 单词的压缩编码
 *
 * @author chenyuxian
 * @date 2021-10-28 23:41:46
 */
public class ShortEncodingOfWords {

	public int minimumLengthEncoding(String[] words) {
		Node root = new Node();
		Arrays.sort(words, (a, b) -> a.length() - b.length());
		int[] indices = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			Node node = root;
			for (int j = words[i].length() - 1; j >= 0; j--) {
				int index = words[i].charAt(j) - 'a';
				if (node.children[index] == null) {
					node.children[index] = new Node();
				}
				node = node.children[index];
				if (node.index != -1) {
					indices[node.index] = -1;
				}
			}
			node.index = i;
		}
		int res = 0;
		for (int i = 0; i < words.length; i++) {
			if (indices[i] == -1) {
				continue;
			}
			res += words[i].length() + 1;
		}
		return res;
	}

	public boolean isSelfCrossing(int[] distance) {
		
		return false;
	}

	class Node {
		int index;
		Node[] children;

		public Node() {
			index = -1;
			children = new Node[26];
		}
	}
}
