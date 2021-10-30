package fundation.algorithm.graph;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * 课程表
 * 
 * @author Administrator
 * @date 2021-10-26 03:31:17
 */
public class CoucourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, Node> map = new HashMap<>();
		for (int i = 0; i < prerequisites.length; i++) {
			int in = prerequisites[i][0];
			int out = prerequisites[i][1];
			if (!map.containsKey(in)) {
				map.put(in, new Node(in));
			}
			if (!map.containsKey(out)) {
				map.put(out, new Node(out));
			}
			map.get(in).in.add(out);
			map.get(out).out.add(in);
		}
		if (map.isEmpty()) {
			return true;
		}
		Deque<Node> deque = new LinkedList<>();
		for (Integer key : map.keySet()) {
			if (map.get(key).in.isEmpty()) {
				deque.add(map.get(key));
			}
		}
		int sum = 0;
		while (!deque.isEmpty()) {
			Node n = deque.remove();
			for (Integer out : n.out) {
				map.get(out).in.remove(n.val);
				if (map.get(out).in.isEmpty()) {
					deque.add(map.get(out));
				}
			}
			sum++;
		}
		return sum == map.size();
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] res = new int[numCourses];
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < numCourses; i++) {
			set.add(i);
		}
		Map<Integer, Node> map = new HashMap<>();
		for (int i = 0; i < prerequisites.length; i++) {
			int in = prerequisites[i][0];
			int out = prerequisites[i][1];
			set.remove(in);
			set.remove(out);
			if (!map.containsKey(in)) {
				map.put(in, new Node(in));
			}
			if (!map.containsKey(out)) {
				map.put(out, new Node(out));
			}
			map.get(in).in.add(out);
			map.get(out).out.add(in);
		}
		int index = 0;
		for (Integer key : set) {
			res[index++] = key;
		}
		Deque<Node> deque = new LinkedList<>();
		for (Integer key : map.keySet()) {
			if (map.get(key).in.isEmpty()) {
				deque.add(map.get(key));
				res[index++] = key;
			}
		}
		while (!deque.isEmpty()) {
			Node n = deque.remove();
			for (Integer out : n.out) {
				map.get(out).in.remove(n.val);
				if (map.get(out).in.isEmpty()) {
					deque.add(map.get(out));
					res[index++] = out;
				}
			}
		}
		if (index == numCourses) {
			return res;
		} else {
			return new int[0];
		}

	}

	class Node {
		Set<Integer> in;
		Set<Integer> out;
		int val;

		public Node(int val) {
			in = new HashSet<>();
			out = new HashSet<>();
			this.val = val;
		}
	}
}
