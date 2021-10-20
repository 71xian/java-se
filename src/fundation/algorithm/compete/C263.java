package fundation.algorithm.compete;

import java.util.HashMap;
import java.util.Map;

public class C263 {

	public int countMaxOrSubsets(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = 1;
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.compute(num, (key, value) -> value + 1);
			} else {
				map.put(num, 1);
			}
			max = max | num;
		}
		int sum = 0;
		for(Integer key : map.keySet()) {
			sum += Math.pow(map.get(key), 2);
		}
		return sum;
	}
}
