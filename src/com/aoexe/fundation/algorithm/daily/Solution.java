package com.aoexe.fundation.algorithm.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public int lengthOfLastWord(String s) {
		int start = -1;
		int end = -1;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ' && start != -1) {
				end = i;
				return start - end;
			}

			if (s.charAt(i) != ' ' && start == -1) {
				start = i;
			}
		}
		if (start == -1) {
			return 0;
		}
		if (end == -1) {
			return start + 1;
		}
		return start - end;
	}

	public boolean isPowerOfThree(int n) {
		if (n <= 0) {
			return false;
		}
		if (n == 1) {
			return true;
		}
		while (n > 1) {
			if (n % 3 != 0) {
				return false;
			}
			n = n / 3;
		}
		return true;
	}

	public Node flatten(Node head) {
		if (head == null) {
			return null;
		}
		Node first = head;
		setChildren(head);
		return first;
	}

	public void setChildren(Node parent) {
		while (parent != null) {
			Node nextParent = parent.next;
			if (parent.child != null) {
				Node child = parent.child;
				parent.child = null;
				parent.next = child;
				child.prev = parent;
				Node prev = child;
				while (child != null) {
					prev = child;
					if (child.child != null) {
						setChildren(child);
					}
					child = child.next;
				}
				prev.next = nextParent;
				if (nextParent != null) {
					nextParent.prev = prev;
				}
			}
			parent = nextParent;
		}
	}

	public int minDistance(String word1, String word2) {
		int m = word1.length(), n = word2.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			char c1 = word1.charAt(i - 1);
			for (int j = 1; j <= n; j++) {
				char c2 = word2.charAt(j - 1);
				if (c1 == c2) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		int lcs = dp[m][n];
		return m - lcs + n - lcs;
	}

	public int getSum(int a, int b) {
		// b为0也就是没有需要进位的数字了
		while (b != 0) {
			// 将都是1的向左移，也就是进位
			int add = (a & b) << 1;
			// 保存没有进位的，用于下一次计算
			a = a ^ b;
			// 将b设为add也就是说将未进位的和已进位的进行计算
			b = add;
		}
		return a;
	}

	public int numDecodings1(String s) {
		if (s.charAt(0) == '0') {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		int[] num = new int[s.length()];
		num[0] = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				if (s.charAt(i - 1) > '2' || s.charAt(i - 1) == '0') {
					return 0;
				}
				num[i] = i >= 2 ? num[i - 2] : num[0];
			} else {
				if (s.charAt(i - 1) == '0' || s.charAt(i - 1) > '2') {
					num[i] = num[i - 1];
					continue;
				}
				if ((s.charAt(i - 1) == '2' && s.charAt(i) <= '6') || s.charAt(i - 1) == '1') {
					if (i >= 2) {
						num[i] = num[i - 1] + num[i - 2];
					} else {
						num[i] = 2;
					}
				} else {
					num[i] = num[i - 1];
				}
			}
		}
		return num[s.length() - 1];
	}

	public int numDecodings2(String s) {
		if (s.charAt(0) == '0') {
			return 0;
		}
		int[] num = new int[s.length()];
		if (s.charAt(0) == '*') {
			num[0] = 9;
		} else {
			num[0] = 1;
		}
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '*') {
				if (s.charAt(i - 1) == '0') {
					num[i] = num[i - 2];
				} else {
					if (s.charAt(i - 1) == '1') {
						num[i] = num[i - 1] + num[i - 2] + 9;
					} else if (s.charAt(i - 1) == '2') {
						num[i] = num[i - 1] + 6;
					} else {
						num[i] = num[i - 1] + 9;
					}
				}
			} else {

			}
		}

		return num[s.length() - 1];
	}

	public int findMinMoves(int[] machines) {
		int total = Arrays.stream(machines).sum();
		if (total % machines.length != 0) {
			return -1;
		}
		int avg = total / machines.length;
		int ans = 0, sum = 0;
		for (int num : machines) {
			num -= avg;
			sum += num;
			ans = Math.max(ans, Math.max(Math.abs(sum), num));
		}
		return ans;

	}

	// 别人巧妙的运用0计算
	public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
		int X = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
		int Y = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
		return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) - X * Y;
	}

	public String destCity(List<List<String>> paths) {
		Map<String, String> arrive = new HashMap<>();
		paths.forEach(path -> {
			arrive.put(path.get(0), path.get(1));
		});
		for (String path : arrive.keySet()) {
			if (!arrive.containsKey(arrive.get(path))) {
				return arrive.get(path);
			}
		}
		return null;
	}

	public int countSegments(String s) {
		int sum = 0;
		int k = 0;
		for (char ch : s.toCharArray()) {
			if (ch != ' ') {
				k++;
			} else {
				if (k != 0) {
					sum++;
					k = 0;
				}
			}
		}
		if (k != 0) {
			sum++;
		}
		return sum;
	}

	public List<String> findRepeatedDnaSequences(String s) {
		List<String> list = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i <= s.length() - 10; i++) {
			String str = s.substring(i, i + 10);
			if (map.containsKey(str)) {
				// 如果使用value++,那么返回值还是value
				map.compute(str, (key, value) -> value + 1);
			} else {
				map.put(str, 1);
			}
		}
		map.keySet().forEach(key -> {
			if (map.get(key) > 1) {
				list.add(key);
			}
		});
		return list;
	}

	public int findComplement(int num) {
		int length = 0;
		int start = num;
		while (start > 0) {
			length++;
			start = start >> 1;
		}
		num = ~num;
		num = num << (32 - length);
		num = num >> (32 - length);
		return num;
	}
}

class Node {
	public int val;
	public Node prev;
	public Node next;
	public Node child;
}
