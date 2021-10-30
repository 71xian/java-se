package fundation.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArraySolution {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Map<Integer, Integer> ge = new HashMap<>();
		Map<Integer, Integer> ne = new HashMap<>();
		for (int num : nums) {
			if (num >= 0) {
				ge.putIfAbsent(num, 0);
				ge.compute(num, (key, value) -> value + 1);
			} else {
				ne.putIfAbsent(num, 0);
				ne.compute(num, (key, value) -> value + 1);
			}
		}
		if (ge.containsKey(0) && ge.get(0) >= 3) {
			res.add(Arrays.asList(0, 0, 0));
		}
		List<Integer> geList = new ArrayList<>(ge.keySet());
		List<Integer> neList = new ArrayList<>(ne.keySet());
		for (int i = 0; i < Math.max(geList.size(), neList.size()); i++) {
			for (int j = i; j < Math.max(geList.size(), neList.size()); j++) {
				if (j < geList.size()) {
					int one = geList.get(i);
					int two = geList.get(j);
					if (ne.containsKey(-(one + two))) {
						if (one == two) {
							if (ge.get(one) >= 2) {
								res.add(Arrays.asList(one, two, -(one + two)));
							}
						} else {
							res.add(Arrays.asList(one, two, -(one + two)));
						}
					}
				}
				if (j < neList.size()) {
					int one = neList.get(i);
					int two = neList.get(j);
					if (ge.containsKey(-(one + two))) {
						if (one == two) {
							if (ne.get(one) >= 2) {
								res.add(Arrays.asList(one, two, -(one + two)));
							}
						} else {
							res.add(Arrays.asList(one, two, -(one + two)));
						}
					}
				}
			}
		}
		return res;
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] res = new int[nums1.length + nums2.length];
		int i = 0, j = 0, k = 0;
		while (i + j <= res.length / 2) {
			if (i == nums1.length) {
				res[k++] = nums2[j++];
				continue;
			}
			if (j == nums2.length) {
				res[k++] = nums1[i++];
				continue;
			}
			if (nums1[i] <= nums2[j]) {
				res[k++] = nums1[i];
				i++;
			} else {
				res[k++] = nums2[j];
				j++;
			}
		}
		if (res.length % 2 == 0) {
			return (res[res.length / 2] + res[res.length / 2 - 1]) / 2.0;
		} else {
			return res[res.length / 2];
		}
	}

}
