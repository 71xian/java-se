package fundation.algorithm.string;

import java.util.HashSet;
import java.util.Set;

public class BM {

	public int[] buildNext(char[] chs) {
		int[] next = new int[chs.length];
		next[0] = -1;
		int k = 0;
		for (int i = 1; i < chs.length; i++) {
			if(chs[i] != chs[k]) {
				next[i] = -1;
				k = 0;
			}else {
				next[i] = k++;
			}
		}
		return next;
	}

	public boolean pattern(String target, String pattern) {
		char[] chs = pattern.toCharArray();
		Set<Character> set = new HashSet<>();
		for (char ch : chs) {
			set.add(ch);
		}
		int i = chs.length - 1;
		int k = i;
		while (i < target.length()) {
			if (!set.contains(target.charAt(i))) {
				i += chs.length;
				k = chs.length - 1;
				continue;
			}

		}
		return false;
	}
}
