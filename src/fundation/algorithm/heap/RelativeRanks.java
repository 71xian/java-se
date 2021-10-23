package fundation.algorithm.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 相对名次
 *
 * @author chenyuxian
 * @date 2021-10-23 01:51:03
 */
public class RelativeRanks {

	public String[] findRelativeRanks(int[] score) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < score.length; i++) {
			map.put(score[i], i);
		}
		Arrays.sort(score);
		String[] result = new String[score.length];
		for (int i = score.length - 1; i >= 0; i--) {
			if (i < score.length - 3) {
				result[map.get(score[i])] = "" + (score.length - i);
			} else if (i == score.length - 1) {
				result[map.get(score[i])] = "Gold Medal";
			} else if (i == score.length - 2) {
				result[map.get(score[i])] = "Silver Medal";
			} else if (i == score.length - 3) {
				result[map.get(score[i])] = "Bronze Medal";
			}
		}
		return result;
	}

}
