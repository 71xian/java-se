package com.aoexe.fundation.algorithm.coder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution10 {

	public void merge(int[] A, int m, int[] B, int n) {
		int a = m - 1;
		int b = n - 1;
		int k = A.length - 1;
		while (a >= 0 && b >= 0) {
			if (A[a] > B[b]) {
				A[k] = A[a];
				a--;
			} else {
				A[k] = B[b];
				b--;
			}
			k--;
		}
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> list = new ArrayList<>();
		Map<Integer, List<String>> listMap = new HashMap<>();
		int[] chs = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83,
				89, 97, 101 };
		for (String s : strs) {
			int key = 1;
			for (char ch : s.toCharArray()) {
				key *= chs[ch - 97];
			}
			if (listMap.containsKey(key)) {
				listMap.get(key).add(s);
			} else {
				List<String> l = new ArrayList<>();
				l.add(s);
				listMap.put(key, l);
			}
		}
		listMap.keySet().forEach(e -> list.add(listMap.get(e)));
		return list;
	}

	public int search(int[] arr, int target) {
		if (arr[0] == target) {
			return 0;
		}
		int prev = -1;
		for (int i = 0; i < arr.length; i++) {
			if (prev > arr[i]) {
				prev = i;
				break;
			}
			prev = arr[i];
		}
		if (arr[0] > target) {
			int left = prev;
			int right = arr.length - 1;
			while (left < right) {
				int middle = (left + right) / 2;
				if (target > arr[middle]) {
					left = middle;
				} else if (target < arr[middle]) {
					right = middle;
				} else {
					int i = middle;
					while (arr[--i] != target) {
						return i + 1;
					}
				}
			}
		} else {
			int left = 0;
			int right = prev;
			while (left < right) {
				int middle = (left + right) / 2;
				if (target > arr[middle]) {
					left = middle;
				} else if (target < arr[middle]) {
					right = middle;
				} else {
					int i = middle;
					while (arr[--i] != target) {
						return i + 1;
					}
				}
			}
		}
		return -1;
	}

	public int findString(String[] words, String s) {
		return binarySearch(words, s, 0, words.length);
	}

	public int binarySearch(String[] words, String s, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			int ans;
			while (middle < right && words[middle].equals("")) {
				middle++;
			}
			if (middle == right) {
				ans = binarySearch(words, s, left, (left + right) / 2);
				if (ans != -1) {
					return ans;
				}
				return -1;
			}
			if (s.compareTo(words[middle]) < 0) {
				ans = binarySearch(words, s, left, middle);
				if (ans != -1) {
					return ans;
				}
			} else if (s.compareTo(words[middle]) > 0) {
				ans = binarySearch(words, s, middle + 1, right);
				if (ans != -1) {
					return ans;
				}
			} else {
				return middle;
			}
		}
		return -1;
	}

	int prev = 0;

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0) {
			return false;
		}
		prev = matrix[0].length;
		for (int i = 0; i < matrix.length; i++) {
			if (binaryMatrix(matrix[i], target, 0, prev)) {
				return true;
			}
		}
		return false;
	}

	private boolean binaryMatrix(int[] array, int target, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			if (target < array[middle]) {
				prev = middle;
				if (binaryMatrix(array, target, left, middle)) {
					return true;
				}
			} else if (target > array[middle]) {
				if (binaryMatrix(array, target, middle + 1, right)) {
					return true;
				}
			} else {
				return true;
			}
		}
		return false;
	}

	public void wiggleSort(int[] nums) {
		
	}
	
}
