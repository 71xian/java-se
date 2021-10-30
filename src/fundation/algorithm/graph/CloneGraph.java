package fundation.algorithm.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 深拷贝
 * 
 * @author Administrator
 * @date 2021-10-26 14:43:02
 */
public class CloneGraph {

	public Node cloneGraph(Node node) {
		if (node == null) {
			return node;
		}
		Map<Node, Node> visited = new HashMap<>();
		visited.put(node, new Node(node.val));
		Deque<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node n = queue.remove();
			for (Node neighbor : n.neighbors) {
				if (!visited.containsKey(neighbor)) {
					visited.put(neighbor, new Node(neighbor.val));
					queue.add(neighbor);
				}
				visited.get(n).neighbors.add(visited.get(neighbor));
			}
		}
		return visited.get(node);
	}
}

class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}