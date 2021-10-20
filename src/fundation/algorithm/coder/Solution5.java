package fundation.algorithm.coder;

public class Solution5 {

	public int insertBits(int N, int M, int i, int j) {
		int l = N >> j >> 1 << j << 1;
		int m = M << i;
		int r = N & ((1 << i) - 1);
		return l | m | r;
	}

	public String printBin(double num) {
		StringBuilder sb = new StringBuilder();
		int number;
		sb.append("0.");
		while (sb.length() <= 34 && num % 1 != 0) {
			num *= 2;
			number = (int) num;
			number /= 1;
			sb.append(number);
			num -= number;
		}
		if (sb.length() > 34) {
			return "ERROR";
		}
		return sb.toString();
	}

	public int reverseBits(int num) {
		int start = 0;
		int end = 0;
		int zero = -1;
		int prev = -1;
		if (num == -1) {
			end--;
		}
		while (true) {
			if ((num & 1) == 0) {
				if (prev != -1) {
					zero = prev;
				}
				prev = end;
			}
			if (zero >= start) {
				start++;
			}
			end++;
			if (num == 0) {
				break;
			}
			num = num >>> 1;
		}
		return end - start;
	}

	public int[] findClosedNumbers(int num) {
		int[] res = new int[2];
		if (num <= 0 || num >= Integer.MAX_VALUE) {
			res[0] = -1;
			res[1] = -1;
		} else {
			res[0] = getNext(num);
			res[1] = getPrev(num);
		}
		return res;
	}

	// 取得前一个较小的数
	private int getPrev(int n) {
		int temp = n;
		int c0 = 0;
		int c1 = 0;
		while ((temp & 1) == 1) {
			c1++;
			temp >>= 1;
		}

		if (temp == 0)
			return -1;

		while (((temp & 1) == 0) && (temp != 0)) {
			c0++;
			temp >>= 1;
		}

		int p = c0 + c1; // 最右边，非拖尾1的位置
		n &= ((~0) << (p + 1)); // 将位0到位p清零

		int mask = (1 << (c1 + 1)) - 1; // (c1+1)个1
		n |= mask << (c0 - 1);

		return n;
	}

	// 取得后一个较大的数
	private int getNext(int n) {
		// 计算c0和c1，用于找到最右边非拖尾0的下标p
		int c = n;
		int c0 = 0;
		int c1 = 0;
		while (((c & 1) == 0) && (c != 0)) {
			c0++;
			c >>= 1;
		}
		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}

		// 错误：若n=111111...000, 那么就没有更大的数字
		// 如果是n的二进制不存在可翻转的0，或者n就是0
		if (c0 + c1 == 31 || c0 + c1 == 0) {
			return -1;
		}

		int p = c0 + c1; // 前提：最右边，非拖尾0的位置
		n |= (1 << p); // 步骤1：翻转最右边，非拖尾0
		n &= ~((1 << p) - 1); // 步骤2：将p右方的所有位清零
		n |= (1 << (c1 - 1)) - 1; // 步骤3：在右方插入(c1-1)个1

		return n;
	}

	public int convertInteger(int A, int B) {
		int sum = 0;
		while (true) {
			if ((A & 1) != (B & 1)) {
				sum++;
			}
			A = A >>> 1;
			B = B >>> 1;
			if (A == 0 && B == 0) {
				break;
			}
		}
		return sum;
	}

	public int exchangeBits(int num) {
		return ((num & 0x55555555) << 1) | ((num & 0xaaaaaaaa) >> 1);
	}

	public int[] drawLine(int length, int w, int x1, int x2, int y) {
		int[] ans = new int[length];
		int low = (y * w + x1) / 32;
		int high = (y * w + x2) / 32;
		for (int i = low; i <= high; i++) {
			ans[i] = -1;
		}
		ans[low] = ans[low] >>> x1 % 32;
		// >>: 如果最高位是1，则补齐1，如果最高位是0，则补齐0
		ans[high] = (ans[high] & Integer.MIN_VALUE) >> x2 % 32;
		return ans;
	}
	
}
