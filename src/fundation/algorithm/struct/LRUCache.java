package fundation.algorithm.struct;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	private Map<Integer, Node> cache;

	private Node first;

	private Node last;

	private int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		cache = new HashMap<>(capacity);
	}

	public int get(int key) {
		Node node = cache.get(key);
		if (node == null) {
			return -1;
		}
		moveToFirst(node);
		return node.val;
	}

	public void put(int key, int value) {
		Node node = cache.get(key);
		if (node != null) {
			node.val = value;
			moveToFirst(node);
			return;
		}
		if (cache.size() == capacity) {
			cache.remove(last.key);
			removeLast();
		}
		node = new Node(key, value);
		addToFirst(node);
		cache.put(key, node);
	}

	private void moveToFirst(Node node) {
		if (node == first) {
			return;
		}
		if (node == last) {
			removeLast();
			addToFirst(node);
			return;
		}
		node.prev.next = node.next;
		node.next.prev = node.prev;
		node.prev = first;
		first.next = node;
		first = node;
	}

	private void addToFirst(Node node) {
		if (first == null || last == null) {
			first = node;
			last = node;
			return;
		}
		node.prev = first;
		first.next = node;
		first = node;
	}

	private void removeLast() {
		last = last.next;
		if (last != null) {
			last.prev = null;
		}
	}

	class Node {
		int key;
		int val;
		Node prev;
		Node next;

		public Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
}
