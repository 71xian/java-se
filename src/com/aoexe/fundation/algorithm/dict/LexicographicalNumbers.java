package com.aoexe.fundation.algorithm.dict;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典序排数
 * 
 * 输入：n = 13 输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
 *
 * 输入：n = 2 输出：[1,2]
 *
 * @author chenyuxian
 * @date 2021-10-18 15:12:43
 */
public class LexicographicalNumbers {

	public List<Integer> lexicalOrder(int n) {
		List<Integer> list = new ArrayList<>(n);
		if (n < 10) {
			for (int i = 1; i <= n; i++) {
				list.add(i);
			}
			return list;
		}
		for (int i = 1; i < 10; i++) {
			dfs(i, n, list);
		}
		return list;
	}

	public void dfs(int start, int n, List<Integer> list) {
		list.add(start);
		int next = start * 10;
		for (int i = 0; i < 10; i++) {
			if (next + i > n) {
				return;
			}
			dfs(next + i, n, list);
		}
	}

}
