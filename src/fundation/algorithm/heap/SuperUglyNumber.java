package fundation.algorithm.heap;

import java.util.Arrays;

/**
 * 超级丑数
 * 
 * @author Administrator
 * @date 2021-10-24 09:22:01
 */
public class SuperUglyNumber {

	public int nthSuperUglyNumber(int n, int[] primes) {
		 int[] dp = new int[n + 1];
	        int m = primes.length;
	        int[] pointers = new int[m];
	        int[] nums = new int[m];
	        Arrays.fill(nums, 1);
	        for (int i = 1; i <= n; i++) {
	            int minNum = Arrays.stream(nums).min().getAsInt();
	            dp[i] = minNum;
	            for (int j = 0; j < m; j++) {
	                if (nums[j] == minNum) {
	                    pointers[j]++;
	                    nums[j] = dp[pointers[j]] * primes[j];
	                }
	            }
	        }
	        return dp[n];
	}
}


