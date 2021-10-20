package fundation.algorithm.coder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution8 {

	public int waysToStep(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (n == 3) {
			return 4;
		}
		int[] dp = new int[3];
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 4;
		int i = 3;
		while (i < n) {
			int temp = dp[2] + ((dp[1] + dp[0]) % 1000000007);
			dp[0] = dp[1] % 1000000007;
			dp[1] = dp[2] % 1000000007;
			dp[2] = temp % 1000000007;
			i++;
		}
		return dp[2];
	}

	public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
		LinkedList<List<Integer>> list = new LinkedList<>();
		if (obstacleGrid.length == 0) {
			return list;
		}
		search(0, 0, obstacleGrid, list);
		return list;
	}

	private boolean search(int x, int y, int[][] map, LinkedList<List<Integer>> list) {
		if (x == map.length || y == map[0].length || map[x][y] == 1) {
			return false;
		}
		map[x][y] = 1;
		list.add(Arrays.asList(x, y));
		if (x == map.length - 1 && y == map[0].length - 1) {
			return true;
		}
		if (search(x, y + 1, map, list)) {
			return true;
		}
		if (search(x + 1, y, map, list)) {
			return true;
		}
		list.removeLast();
		return false;
	}

	public int findMagicIndex(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == i) {
				return i;
			}
		}
		return -1;
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		list.add(new ArrayList<>());
		int i = 0;
		while (i < nums.length) {
			List<List<Integer>> sonList = new ArrayList<>();
			for (List<Integer> son : list) {
				List<Integer> each = new ArrayList<>(son);
				each.add(nums[i]);
				sonList.add(each);
			}
			for (List<Integer> son : sonList) {
				list.add(son);
			}
			i++;
		}
		return list;
	}

	public int multiply(int A, int B) {
		if (B == 0) {
			return 0;
		}
		return (B & 1) == 1 ? A + multiply(A << 1, B >> 1) : multiply(A << 1, B >> 1);
	}

	public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
		int n = A.size();
		move(n, A, B, C);
	}

	private void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
		if (n == 1) {
			C.add(A.remove(A.size() - 1));
		} else {
			move(n - 1, A, C, B);
			C.add(A.remove(A.size() - 1));
			move(n - 1, B, A, C);
		}
	}

	int index = 0;

	public String[] permutation(String S) {
		int sum = 1;
		int i = S.length();
		while (i > 1) {
			sum *= i;
			i--;
		}
		String[] str = new String[sum];
		sort(S.toCharArray(), str, 0);
		return str;
	}

	public String[] permutationRepeat(String S) {
		int sum = 1;
		int i = S.length();
		while (i > 1) {
			sum *= i;
			i--;
		}
		String[] str = new String[sum];
		sort(S.toCharArray(), str, 0);
		int num = 0;
		for (String s : str) {
			if (s == null) {
				break;
			}
			num++;
		}
		String[] result = new String[num];
		System.arraycopy(str, 0, result, 0, result.length);
		return result;
	}

	private void sort(char[] chs, String[] str, int start) {
		if (start == chs.length) {
			str[index++] = String.valueOf(chs);
			return;
		}
		Set<Character> curSet = new HashSet<>();
		for (int i = start; i < chs.length; i++) {
			char ch = chs[i];
			if (curSet.contains(ch)) {
				continue;
			}
			curSet.add(ch);
			chs[i] = chs[start];
			chs[start] = ch;
			sort(chs, str, start + 1);
			ch = chs[start];
			chs[start] = chs[i];
			chs[i] = ch;
		}

	}

	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		char[] chs = new char[n * 2];
		pattern(chs, 0, 0, 0, list);
		System.out.println(list.size());
		return list;
	}

	private void pattern(char[] chs, int index, int left, int right, List<String> list) {
		if (right > left) {
			return;
		}
		if (index == chs.length) {
			if (left == right) {
				list.add(String.valueOf(chs));
			}
			return;
		}
		chs[index] = '(';
		pattern(chs, index + 1, left + 1, right, list);
		chs[index] = ')';
		pattern(chs, index + 1, left, right + 1, list);
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		fill(image, sr, sc, newColor, image[sr][sc]);
		return image;
	}

	private void fill(int[][] image, int sr, int sc, int newColor, int oldColor) {
		if (sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length && image[sr][sc] != newColor
				&& image[sr][sc] == oldColor) {
			image[sr][sc] = newColor;
			fill(image, sr, sc - 1, newColor, oldColor);
			fill(image, sr + 1, sc, newColor, oldColor);
			fill(image, sr, sc + 1, newColor, oldColor);
			fill(image, sr - 1, sc, newColor, oldColor);
		}
	}

	public int waysToChange(int n) {
		int ans = 0;
		int mod = 1000000007;
		for (int i = 0; i * 25 <= n; ++i) {
			int rest = n - i * 25;
			int a = rest / 10;
			int b = rest % 10 / 5;
			ans = (ans + (int) ((long) (a + 1) * (a + b + 1) % mod)) % mod;
		}
		return ans;

	}

	private List<List<String>> list = new ArrayList<>();

	public List<List<String>> solveNQueens(int n) {
		char[][] init = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				init[i][j] = '.';
			}
		}
		List<List<Integer>> enable = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			path.add(i);
		}
		for (int i = 0; i < n; i++) {
			enable.add(new ArrayList<>(path));
		}
		path.clear();
		buildMap(init, enable, path, 0);
		return list;
	}

	private void buildMap(char[][] map, List<List<Integer>> enable, List<Integer> path, int row) {
		if (row == enable.size()) {
			List<String> end = new ArrayList<>();
			for (int i = 0; i < path.size(); i++) {
				map[i][path.get(i)] = 'Q';
				end.add(String.valueOf(map[i]));
				map[i][path.get(i)] = '.';
			}
			list.add(end);
			return;
		}

		List<Integer> cols = enable.get(row);
		for (int i = 0; i < cols.size(); i++) {
			int col = cols.get(i);
			path.add(col);
			int left = 0;
			int right = 0;
			int k = 1;
			for (int j = row + 1; j < enable.size(); j++) {
				List<Integer> rows = enable.get(j);
				rows.remove(Integer.valueOf(col));
				left = col - k;
				if (left >= 0) {
					rows.remove(Integer.valueOf(left));
				}
				right = col + k;
				if (right < enable.size()) {
					rows.remove(Integer.valueOf(right));
				}
				k++;
			}
			buildMap(map, enable, path, row + 1);
			path.remove(Integer.valueOf(col));
		}
	}

	public int pileBox(int[][] box) {
		int sum = 0;
		int wi = 0;
		int di = 0;
		int hi = 0;
		for (int i = 0; i < box.length; i++) {
			if (box[i][0] > wi && box[i][1] > di && box[i][2] > hi) {
				wi = box[i][0];
				di = box[i][1];
				hi = box[i][2];
				sum += hi;
			}
		}
		return sum;
	}

	public int countEval(String s, int result) {
		return 0;
	}

	public static void main(String[] args) {
		Solution8 so = new Solution8();
		so.generateParenthesis(15);

	}

}
