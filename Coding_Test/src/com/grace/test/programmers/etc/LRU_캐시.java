package com.grace.test.programmers.etc;

import java.util.LinkedList;

public class LRU_캐시 {
	
	public static void main(String[] args) {
		System.out.println(Solution());
	}

	static int Solution() {
		// TODO Auto-generated method stub
		int answer = 0;
		int cacheSize = 5;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		int CACHE_HIT = 1;
        int CACHE_MISS = 5;
        
        if(cacheSize == 0) {
        	return CACHE_MISS* cities.length;
        }
        
        LinkedList<String> cache = new LinkedList<String>();
        
        for(String item : cities) {
        	String city = item.toLowerCase();
        	int idx = cache.indexOf(city);
        	// hit
        	if(idx != -1) {
        		answer += CACHE_HIT;
        		cache.remove(idx);
        		cache.add(city);
    		// miss
        	}else {
        		answer += CACHE_MISS;
        		if(cache.size() >= cacheSize) cache.removeFirst();
        		cache.add(city);
        	}
        }
       return answer;

	}

}
