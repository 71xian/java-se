package fundation.algorithm.daily;

public class Test {

	public static void main(String[] args) {
		System.out.println(0 >> 1);
		System.out.println(1 >> 1);
		System.out.println(toHex(16));
	}

	public static String toHex(int num) {
		char[] map = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		if (num == 0) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			if (num == 0) {
				break;
			}
			int bit = num & 0b1111;
			sb.append(map[(num & 0b1111)]);
			num = num >> 4;
		}
		return sb.reverse().toString();
	}
}
