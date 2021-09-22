package com.aoexe.fundation.alg.ds;

import java.util.HashMap;
import java.util.Map;

public class WordsFrequency {

	private Map<String, Integer> map = new HashMap<>();
	
	public WordsFrequency(String[] book) {
		for(String s : book) {
			if(map.containsKey(s)) {
				map.compute(s, (key, value) -> value + 1);
			}else {
				map.put(s, 1);
			}
		}
    }
    
    public int get(String word) {
    	if(!map.containsKey(word)) {
    		return 0;
    	}
    	return map.get(word);
    }
}
