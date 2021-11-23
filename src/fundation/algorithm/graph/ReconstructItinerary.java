package fundation.algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 重新安排行程
 * 
 * @author Administrator
 * @date 2021-10-31 16:38:45
 */
public class ReconstructItinerary {

	public List<String> findItinerary(List<List<String>> tickets) {
		Map<String, Node> map = new HashMap<>();
		for (List<String> ticket : tickets) {
			if (!map.containsKey(ticket.get(0))) {
				map.put(ticket.get(0), new Node());
			}
			if (!map.containsKey(ticket.get(1))) {
				map.put(ticket.get(1), new Node());
			}
			map.get(ticket.get(1)).in.add(ticket.get(0));
			map.get(ticket.get(0)).out.add(ticket.get(1));
		}
		List<String> res = new ArrayList<>();
		res.add("JFK");
		while (!map.isEmpty()) {
			String s = map.get("JFK").out.poll();
		}
		return res;
	}

	class Node {
		PriorityQueue<String> in;
		PriorityQueue<String> out;

		public Node() {
			in = new PriorityQueue<>();
			out = new PriorityQueue<>();
		}
	}
}
