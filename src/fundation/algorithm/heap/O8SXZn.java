package fundation.algorithm.heap;

/**
 * 蓄水
 *
 * @author chenyuxian
 * @date 2021-10-23 10:17:19
 */
public class O8SXZn {

	public int storeWater(int[] bucket, int[] vat) {
		int sum = 0;
		int max = 0;
		for (int i = 0; i < bucket.length; i++) {
			if (bucket[i] != vat[i] && bucket[i] == 0) {
				bucket[i] = 1;
				sum++;
			}
			if(bucket[i] != vat[i] && bucket[i] != 0) {
				max = Math.max(max, vat[i] / bucket[i]);
			}
		}
		
		return sum;
	}
}
