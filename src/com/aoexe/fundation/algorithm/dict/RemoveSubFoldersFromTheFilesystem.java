package com.aoexe.fundation.algorithm.dict;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 删除子文件夹
 *
 * @author chenyuxian
 * @date 2021-10-20 10:08:34
 */
public class RemoveSubFoldersFromTheFilesystem {

	Trie root = new Trie();
	
	public List<String> removeSubfolders(String[] folder) {
		for (int i = 0; i < folder.length; i++) {
			build(folder[i].split("/"), root, i);
		}
		List<String> list = new ArrayList<>();
		dfs(root, folder, list);
		return list;
	}

	private void dfs(Trie node, String[] folder, List<String> list) {
		for (String key : node.next.keySet()) {
			if (node.next.get(key).isEnd) {
				list.add(folder[node.next.get(key).pos]);
			} else {
				dfs(node.next.get(key), folder, list);
			}
		}
	}

	private void build(String[] split, Trie node, int pos) {
		Trie n = node;
		for (String s : split) {
			if (!n.next.containsKey(s)) {
				n.next.put(s, new Trie());
			}
			n = n.next.get(s);
		}
		n.isEnd = true;
		n.pos = pos;
	}

	class Trie {
		boolean isEnd;
		int pos;
		Map<String, Trie> next;

		public Trie() {
			isEnd = false;
			pos = -1;
			next = new HashMap<>();
		}
	}
}
