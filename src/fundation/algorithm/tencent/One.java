package fundation.algorithm.tencent;

public class One {

	public int myAtoi(String s) {
		if (s.isEmpty()) {
			return 0;
		}
		int index = 0;
		while (index < s.length() && s.charAt(index) == ' ') {
			index++;
		}
		if (index == s.length()) {
			return 0;
		}
		boolean flag = true;
		if (s.charAt(index) == '-' || s.charAt(index) == '+') {
			flag = s.charAt(index) == '+';
			index++;
		}
		while (index < s.length() && s.charAt(index) == '0') {
			index++;
		}
		if (index == s.length()) {
			return 0;
		}
		int end = index;
		for (int i = index; i < s.length(); i++) {
			if (s.charAt(i) < '0' || s.charAt(i) > '9') {
				break;
			}
			end++;
		}
		if (end == index) {
			return 0;
		}
		if (end - index > 10) {
			return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		}
		String res = s.substring(index, end);
		Long val = Long.valueOf(res);
		if (val > Integer.MAX_VALUE) {
			return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		}
		return flag ? Integer.valueOf(res) : -Integer.valueOf(res);
	}

	public static void main(String[] args) {
		System.out.println(String.valueOf(Integer.MAX_VALUE).length());
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}
}
