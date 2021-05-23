package com.grace.test.programmers;

import java.util.*;

public class Q순위검색 {
	static Map<String, Integer> wordMap = new HashMap<>();
	static List<List<Integer>> scoreList = new ArrayList<>();
	public static void main(String[] args) {
		// https://programmers.co.kr/learn/courses/30/lessons/72412
		// 참고 https://www.youtube.com/watch?v=eBQtFteduyw&t=873s
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210",
							"python frontend senior chicken 150","cpp backend senior pizza 260",
							"java backend junior chicken 80","python backend senior chicken 50"};

		String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200",
						  "cpp and - and senior and pizza 250","- and backend and senior and - 150",
						  "- and - and - and chicken 100","- and - and - and - 150"};
	
		
		//public static int[] solution(String[] info, String[] query) {
			
			wordMap.put("-", 0);
			wordMap.put("cpp", 1);
			wordMap.put("java", 2);
			wordMap.put("phython", 3);
			wordMap.put("backend", 1);
			wordMap.put("frontend", 2);
			wordMap.put("junior", 1);
			wordMap.put("senior", 2);
			wordMap.put("chicken", 1);
			wordMap.put("pizza", 2);
			
			for(int i=0; i<4*3*3*3; i++) {
				scoreList.add(new ArrayList<>());
			}
			
			for(String str : info) {
				String[] word = str.split(" ");
				int[] arr = {wordMap.get(word[0])*3*3*3,
							 wordMap.get(word[1])*3*3,
							 wordMap.get(word[2])*3,
							 wordMap.get(word[3])};
				int score = Integer.parseInt(word[4]);
				
				for(int i=0; i<(1<<4); i++) {
					int idx = 0;
					for(int j=0; j<4; j++) {
						if((i & (1<<j)) != 0) {
							idx += arr[j];
						}
					}
					scoreList.get(idx).add(score);
				}
			}
			for(int i=0; i<4*3*3*3; i++) {
				Collections.sort(scoreList.get(i));
			}
			
	        int[] answer = new int[query.length];
	        
	        for(int i=0; i<query.length; i++) {
	        	String[] word = query[i].split(" ");
	        	int idx = wordMap.get(word[0]) *3*3*3 + 
	        			wordMap.get(word[2]) *3*3 +
	        			wordMap.get(word[4])*3 +
	        			wordMap.get(word[6]);
	        	int score = Integer.parseInt(word[7]);
	        	int ret = Collections.binarySearch(scoreList.get(idx),score);
	        	if(ret<0) {
	        		ret = -(ret +1);
	        	}else {
	        		for(int j=ret-1; j>=0; j--){
	        			if(scoreList.get(idx).get(j) == score) {
	        				ret = j;
	        			}else {
	        				break;
	        			}
	        		}
	        	}
	        	answer[i] = scoreList.get(idx).size() - ret;
	        }
	        
	        for(int i=0; i<answer.length; i++) {
	        	System.out.println(answer[i]);
	        }
	        
	        //return answer;
	   // }
		
	}
}
