package com.aoexe.fundation.algorithm.struct;

//不会就是不会，不写了
public class Operations {

	public Operations() {

	}

	public int minus(int a, int b) {
		return a + ~b + 1;
	}

	public int multiply(int a, int b) {
		int ans = 0;
		
		return ans;
	}

	public int divide(int a, int b) {
		int ans = 1;
		if (multiply(ans, b) > a) {
			return 0;
		}
		while (multiply(ans, b) <= a) {
			ans++;
		}
		return ans;
	}
}
