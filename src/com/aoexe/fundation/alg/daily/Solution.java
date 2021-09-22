package com.aoexe.fundation.alg.daily;

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
	
	public static void main(String[] args) {
		Solution so = new Solution();
		so.lengthOfLastWord("   fly me   to   the moon  ");
	}
}

