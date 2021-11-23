package fundation.project.dat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DoubleArrayTrie {

	private boolean[] map;

	private TrieNode root;

	private Node[] dat;

	private int size = 1 << 16;

	public DoubleArrayTrie() {
		map = new boolean[size];
		dat = new Node[size];
	}

	public void buildTrie(Collection<String> collection) {
		root = new TrieNode();
		for (String s : collection) {
			TrieNode node = root;
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if (!node.children.containsKey(ch)) {
					node.children.put(ch, new TrieNode());
					node.children.get(ch).ch = ch;
					node.children.get(ch).depth = i;
					if (!map[ch]) {
						map[ch] = true;
					}
				}
				node = node.children.get(ch);
			}
			node.end = true;
		}
	}

	public void buildFail() {
		Deque<TrieNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TrieNode node = queue.remove();
			TrieNode failure = node.failure;
			for (TrieNode e : node.children.values()) {
				while (failure != null) {
					if (failure.children.containsKey(e.ch)) {
						e.failure = failure.children.get(e.ch);
						break;
					}
					failure = failure.failure;
				}
				if (failure == null) {
					e.failure = root;
				}
				queue.add(e);
			}
		}
	}

	public void buildDAT() {
		Deque<TrieNode> queue = new LinkedList<>();
		dat[0] = new Node();
		dat[0].base = 1;
		queue.add(root);
		while (!queue.isEmpty()) {
			TrieNode node = queue.remove();
			Collection<TrieNode> values = node.children.values();
			if (values.isEmpty()) {
				continue;
			}
			int offset = 0;
			boolean success = false;
			while (!success) {
				success = true;
				for (TrieNode e : values) {
					int index = node.index + offset + e.ch;
					while (index >= dat.length) {
						grow();
					}
					if (dat[index] != null) {
						offset++;
						success = false;
						break;
					}
				}
				if (success) {
					dat[node.index].base = offset;
					for (TrieNode e : values) {
						int index = node.index + offset + e.ch;
						dat[index] = new Node();
						dat[index].depth = (byte) (e.end ? -e.depth : e.depth);
						dat[index].check = node.index;
						dat[index].fail = e.failure.index;
						e.index = index;
						queue.add(e);
					}
				}
			}

		}
	}

	public Map<String, List<Integer>> match(String text) {
		Map<String, List<Integer>> res = new HashMap<>();
		int index = 0;
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			if (!map[ch]) {
				index = 0;
				continue;
			}
			int next = index + dat[index].base + ch;
			while (dat[next].check != index && index != 0) {
				index = dat[index].fail;
				next = index + dat[index].base + ch;
			}
			if (dat[next].check == index) {
				index = next;
			}
			int temp = index;
			while (temp != 0) {
				if (dat[temp].depth < 0) {
					String key = text.substring(i + dat[temp].depth, i + 1);
					if (!res.containsKey(key)) {
						res.put(key, new LinkedList<>());
					}
					res.get(key).add(i + dat[temp].depth);
				}
				temp = dat[temp].fail;
			}
		}
		return res;
	}

	private void grow() {
		Node[] dat1 = new Node[dat.length << 1];
		System.arraycopy(dat, 0, dat1, 0, dat.length);
		dat = dat1;
	}

	public static void main(String[] args) throws IOException {
		DoubleArrayTrie dat = new DoubleArrayTrie();
		List<String> list = new ArrayList<>();
		File tex = new File("D:\\dieverwandlung.txt");
		File dic = new File("D:\\german.txt");
		BufferedReader br = new BufferedReader(new FileReader(dic));
		String str = null;
		while ((str = br.readLine()) != null) {
			list.add(str);
		}
		StringBuilder sb = new StringBuilder();
		br = new BufferedReader(new FileReader(tex));
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		dat.buildTrie(list);
		dat.buildFail();
		dat.buildDAT();
		Map<String, List<Integer>> match = dat.match(sb.toString());
		match.entrySet().forEach(e -> {
			System.out.println(e.getKey() + ":" + e.getValue());
		});
	}

}
