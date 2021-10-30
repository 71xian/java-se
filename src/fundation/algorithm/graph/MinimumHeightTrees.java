package fundation.algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 最小高度树
 * 
 * @author Administrator
 * @date 2021-10-27 01:04:16
 */
public class MinimumHeightTrees {

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < edges.length; i++) {
			if (!map.containsKey(edges[i][0])) {
				map.put(edges[i][0], new HashSet<>());
			}
			if (!map.containsKey(edges[i][1])) {
				map.put(edges[i][1], new HashSet<>());
			}
			map.get(edges[i][0]).add(edges[i][1]);
			map.get(edges[i][1]).add(edges[i][0]);
		}
		List<Integer> list = new LinkedList<>();
		for (Integer key : map.keySet()) {
			if (map.get(key).size() == 1) {
				list.add(key);
			}
		}
		List<Integer> res = new ArrayList<>();
		while (!list.isEmpty()) {
			res = new ArrayList<>(list);
			List<Integer> children = new ArrayList<>();
			for (Integer key : list) {
				for (Integer next : map.get(key)) {
					if (!map.get(next).isEmpty()) {
						map.get(next).remove(key);
						if (map.get(next).size() == 1) {
							children.add(next);
						}
					}
				}
			}
			list = new ArrayList<>(children);
		}
		if (res.isEmpty()) {
			res.add(0);
		}
		return res;
	}

}
