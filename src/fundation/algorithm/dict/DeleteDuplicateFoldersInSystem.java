package fundation.algorithm.dict;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 删除系统中的重复文件夹
 *
 * @author chenyuxian
 * @date 2021-10-20 11:46:07
 */
public class DeleteDuplicateFoldersInSystem {

	Trie root = new Trie();

	public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
		for (List<String> path : paths) {
			build(root, path);
		}
		return null;
	}

	private void dfs(Trie node) {
		if (node.children.isEmpty()) {
			return;
		}
		for (String key : node.children.keySet()) {
			
		}
	}

	private void build(Trie root, List<String> path) {
		Trie node = root;
		for (String key : path) {
			if (!node.children.containsKey(key)) {
				node.children.put(key, new Trie());
			}
			node = node.children.get(key);
		}
		node.isEnd = true;
	}

	class Trie {
		boolean isEnd;
		Map<String, Trie> children;

		public Trie() {
			isEnd = false;
			children = new HashMap<>();
		}
	}
}
