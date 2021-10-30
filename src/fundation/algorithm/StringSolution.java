package fundation.algorithm;

public class StringSolution {

	public String longestPalindrome(String s) {
		int left = 0;
		int right = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				int[] n = find(s, i, i + 1);
				if (n[1] - n[0] > right - left) {
					right = n[1];
					left = n[0];
				}
			}
			int[] n = find(s, i, i);
			if (n[1] - n[0] > right - left) {
				right = n[1];
				left = n[0];
			}
		}
		return s.substring(left, right + 1);
	}

	private int[] find(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return new int[] { left + 1, right - 1 };
	}

}
