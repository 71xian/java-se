package fundation.algorithm.string;

public class KMP {

	public static void main(String[] args) {
		String pattern = "abaabcac";
		buildNext(pattern.toCharArray());
	}

	public static int[] buildNext(char[] pattern) {
		final int[] next = new int[pattern.length];
		int k = 0;
		int i = 1;
		while(i < pattern.length - 1) {
			if (pattern[i] == pattern[k]) {
				next[i++] = ++k;
			} else {
				if(k == 0) {
					i++;
				}
				k = 0;
			}
		}

		return next;
	}

	public static boolean pattern(String target, String pattern) {
		final int length = pattern.length();
		final int[] next = buildNext(pattern.toCharArray());
		int k = 0;
		for (char ch : target.toCharArray()) {
			if (ch == pattern.charAt(k)) {
				if (k == length - 1) {
					return true;
				}
				k++;
			} else {
				k = next[k];
			}
		}
		return false;
	}
}
