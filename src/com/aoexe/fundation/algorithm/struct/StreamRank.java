package com.aoexe.fundation.algorithm.struct;

import java.util.Map;
import java.util.TreeMap;

public class StreamRank {

	private Map<Integer, Integer> map;

	public StreamRank() {
		map = new TreeMap<>();
	}

	public void track(int x) {
		if (map.containsKey(x)) {
			map.put(x, map.get(x) + 1);
		} else {
			map.put(x, 1);
		}
	}

	public int getRankOfNumber(int x) {
		int sum = 0;
		for(Integer key : map.keySet()) {
			if(key <= x) {
				sum += map.get(key);
			}else {
				break;
			}
		}
		return sum;
	}
}
