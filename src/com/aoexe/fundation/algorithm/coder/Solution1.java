package com.aoexe.fundation.algorithm.coder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1 {

	public boolean isUnique(String astr) {
		Set<Character> set = new HashSet<>();
		for (char ch : astr.toCharArray()) {
			if (set.contains(ch)) {
				return false;
			} else {
				set.add(ch);
			}
		}
		return true;
	}

	public boolean CheckPermutation(String s1, String s2) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s1.toCharArray()) {
			Integer num = map.get(ch);
			if (map.containsKey(ch)) {
				map.put(ch, ++num);
			} else {
				map.put(ch, 1);
			}
		}
		for (char ch : s2.toCharArray()) {
			if (!map.containsKey(ch)) {
				return false;
			} else {
				int num = map.get(ch);
				if (num == 0) {
					return false;
				} else {
					map.put(ch, --num);
				}
			}
		}
		return true;
	}

	public String replaceSpaces(String S, int length) {
		char[] array = S.toCharArray();
		char[] result = new char[S.length()];
		int k = 0;
		for (int i = 0; i < length; i++) {
			if (array[i] == ' ') {
				result[k++] = '%';
				result[k++] = '2';
				result[k++] = '0';
			} else {
				result[k++] = array[i];
			}
		}
		return new String(result, 0, k);
	}

	public boolean canPermutePalindrome(String s) {
		Set<Character> set = new HashSet<>();
		for (char ch : s.toCharArray()) {
			if (set.contains(ch)) {
				set.remove(ch);
			} else {
				set.add(ch);
			}
		}
		return set.size() <= 1;
	}

	public boolean oneEditAway(String to, String second) {
		int len = to.length() - second.length();
		if (len == 0) {
			boolean flag = false;
			for (int i = 0; i < to.length(); i++) {
				if (to.charAt(i) != second.charAt(i)) {
					if (flag) {
						return false;
					}
					flag = true;
				}
			}
			return true;
		}

		if (Math.abs(len) == 1) {
			len = Math.min(to.length(), second.length());
			int l = 0;
			int s = 0;
			boolean flag = false;
			for (int i = 0; i < len; i++) {
				if (to.charAt(l) != second.charAt(s)) {
					i--;
					if (flag) {
						return false;
					}
					if (to.length() < second.length()) {
						s++;
					} else {
						l++;
					}
					flag = true;
					continue;
				}
				s++;
				l++;
			}
			return true;
		}
		return false;
	}

	public String compressString(String S) {
		if (S.isEmpty()) {
			return S;
		}
		int fast = 0;
		int slow = 0;
		StringBuilder builder = new StringBuilder();
		while (fast < S.length()) {
			if (S.charAt(slow) != S.charAt(fast)) {
				builder.append(S.charAt(slow));
				builder.append(fast - slow);
				slow = fast;
			}
			fast++;
		}
		builder.append(S.charAt(slow));
		builder.append(fast - slow);
		String result = builder.toString();
		if (result.length() < S.length()) {
			return result;
		} else {
			return S;
		}
	}

	public void rotate(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[i].length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix[i].length - j - 1];
				matrix[i][matrix[i].length - j - 1] = temp;
			}
		}
	}

	public void setZeroes(int[][] matrix) {
		int[] row = new int[matrix.length * matrix[0].length];
		int[] col = new int[matrix.length * matrix[0].length];
		int k = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					row[k] = i;
					col[k] = j;
					k++;
				}
			}
		}
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[row[i]][j] = 0;
			}
			for (int v = 0; v < matrix.length; v++) {
				matrix[v][col[i]] = 0;
			}
		}
	}

	public boolean isFlipedString(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		if (s1.equals(s2)) {
			return true;
		}
		return (s2 + s2).contains(s1);
	}

}

