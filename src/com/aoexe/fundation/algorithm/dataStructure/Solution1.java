package com.aoexe.fundation.algorithm.dataStructure;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for(int i : nums) {
			int size = set.size();
			set.add(i);
			if(set.size() == size) {
				return true;
			}
		}
		return false;
	}
	
	public int maxSubArray(int[] nums) {
		
    }
	
	public static void main(String[] args) {
		Solution1 solution = new Solution1();
		int[] nums = new int[] {1,2,3,1};
		System.out.println(solution.containsDuplicate(nums));
	}
}
