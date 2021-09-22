package com.aoexe.fundation.alg.dp;

public class Solution {

	public int fib(int n) {
		if (n <= 1) {
			return n;
		}
		int i = 2;
		int one = 0;
		int two = 1;
		int three = 0;
		while (i <= n) {
			three = one + two;
			one = two;
			two = three;
			i++;
		}
		return three;
	}
	
	public int tribonacci(int n) {
		if(n <= 1) {
			return n;
		}
		if(n == 2) {
			return 1;
		}
		int i = 3;
		int one = 0;
		int two = 1;
		int three = 1;
		int four = 0;
		while (i <= n) {
			four = three + two + one;
			one = two;
			two = three;
			three = four;
			i++;
		}
		return four;
    }
}
