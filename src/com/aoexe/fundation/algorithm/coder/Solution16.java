package com.aoexe.fundation.algorithm.coder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution16 {

	public int[] swapNumbers(int[] numbers) {
		numbers[0] ^= numbers[1];
		numbers[1] ^= numbers[0];
		numbers[0] ^= numbers[1];
		return numbers;
	}

	// 不想写了
	public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
		double k1, c1, k2, c2;
		if (end1[0] == start1[0]) {
			if (end2[0] == start2[0]) {
				if (start1[0] == start2[0]) {
				}
			}
		}
		k1 = (end1[1] - start1[1]) / end1[0] - start1[0];
		c1 = end1[0] - start1[0] * k1;
		k2 = (end2[1] - start2[1]) / end2[0] - start2[0];
		c2 = end2[0] - start2[0] * k2;
		if (k1 == k2) {
			if (c1 == c2) {
				if (end1[1] <= end2[1] && end1[1] >= start2[1]) {
					double[] ans = new double[2];
					ans[0] = start2[0];
					ans[1] = start2[1];
					return ans;
				}
			} else {
				return new double[0];
			}
		}
		double x = (c2 - c1) / (k1 - k2);
		double y = k1 * x + c1;
		if (y - start1[1] >= 1e-6 && end1[1] - y <= 1e-6) {
			double[] ans = new double[2];
			ans[0] = x;
			ans[1] = y;
			return ans;
		} else {
			return new double[0];
		}
	}

	public String tictactoe(String[] board) {
		int empty = 0;
		char[][] map = new char[board.length][board.length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = board[i].charAt(j);
			}
		}
		for (int i = 0; i < map.length; i++) {
			int XCol = 0;
			int XRow = 0;
			int OCol = 0;
			int ORow = 0;
			int XDiv = 0;
			int XOrDiv = 0;
			int ODiv = 0;
			int OOrDiv = 0;
			for (int j = 0; j < map.length; j++) {
				if (map[j][i] == ' ') {
					empty++;
				}
				if (map[i][j] == 'X') {
					XRow++;
				}
				if (map[j][i] == 'X') {
					XCol++;
				}
				if (map[j][j] == 'X') {
					XDiv++;
				}
				if (map[j][map.length - 1 - j] == 'X') {
					XOrDiv++;
				}
				if (map[i][j] == 'O') {
					ORow++;
				}
				if (map[j][i] == 'O') {
					OCol++;
				}
				if (map[j][j] == 'O') {
					ODiv++;
				}
				if (map[j][map.length - 1 - j] == 'O') {
					OOrDiv++;
				}
			}
			if (XCol == map.length || XRow == map.length || XDiv == map.length || XOrDiv == map.length) {
				return "X";
			}
			if (OCol == map.length || ORow == map.length || ODiv == map.length || OOrDiv == map.length) {
				return "O";
			}
		}
		if (empty > 0) {
			return "Pending";
		}
		return "Draw";
	}

	public int trailingZeroes(int n) {
		int sum = 0;
		while (n != 0) {
			n /= 5;
			sum += n;
		}
		return sum;
	}

	public int smallestDifference(int[] a, int[] b) {
		Arrays.sort(a);
		Arrays.sort(b);
		long min = Long.MAX_VALUE;
		long diff = 0;
		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] == b[j]) {
				return 0;
			}
			diff = a[i] - b[j];
			min = Math.min(Math.abs(diff), min);
			if (a[i] < b[j]) {
				i++;
			} else {
				j++;
			}
		}
		return (int) min;
	}

	public int maximum(int a, int b) {
		long diff = (long) a - (long) b;
		int k = (int) (diff >> 63);
		return (1 + k) * a - b * k;
	}

	public int maxAliveYear(int[] birth, int[] death) {
		int[] change = new int[102];
		for (int i = 0; i < birth.length; i++) {
			change[birth[i] - 1900]++;
			change[death[i] - 1899]--;
		}
		int maxAlive = 0;
		int curAlive = 0;
		int theYear = 1900;
		for (int i = 0; i < 101; i++) {
			curAlive += change[i];
			if (curAlive > maxAlive) {
				maxAlive = curAlive;
				theYear = 1900 + i;
			}
		}
		return theYear;
	}

	public int[] divingBoard(int shorter, int longer, int k) {
		if (k == 0) {
			return new int[0];
		}
		if (shorter == longer) {
			int[] ans = new int[1];
			ans[0] = k * shorter;
			return ans;
		}
		int[] ans = new int[k + 1];
		for (int i = k; i >= 0; i--) {
			ans[k - i] = shorter * i + longer * (k - i);
		}
		return ans;
	}

	public double[] cutSquares(int[] square1, int[] square2) {
		return null;
	}

	public int[] bestLine(int[][] points) {
		return null;
	}

	public int[] masterMind(String solution, String guess) {
		int[] ans = new int[2];
		int[] map = new int[26];
		for (int i = 0; i < solution.length(); i++) {
			if (solution.charAt(i) == guess.charAt(i)) {
				ans[0]++;
			} else {
				map[solution.charAt(i) - 65]++;
			}
		}
		for (int i = 0; i < guess.length(); i++) {
			if (solution.charAt(i) != guess.charAt(i)) {
				if (map[guess.charAt(i) - 65] != 0) {
					ans[1]++;
					map[guess.charAt(i) - 65]--;
				}
			}
		}
		return ans;
	}

	public int[] subSort(int[] array) {
		int[] ans = new int[2];
		int max = 0;
		int min = Integer.MAX_VALUE;
		Map<Integer, Integer> map = new HashMap<>();
		Map<Integer, Integer> mapNo = new HashMap<>();
		for (int i = 1; i < array.length; i++) {
			if (array[i - 1] > array[i]) {
				mapNo.put(array[i], i);
				max = Math.max(array[i], max);
				min = Math.min(array[i], i);
			} else {
				map.put(array[i], i);
			}
		}
		//未写完
		return null;
	}

}
