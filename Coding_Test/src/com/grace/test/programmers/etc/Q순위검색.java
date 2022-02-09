package com.grace.test.programmers.etc;

import java.util.*;

public class Q순위검색 {

	public static void main(String[] args) {
		// https://programmers.co.kr/learn/courses/30/lessons/72412
		// 참고   https://www.youtube.com/watch?v=eBQtFteduyw&t=873s
		//     https://girawhale.tistory.com/94
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210",
							"python frontend senior chicken 150","cpp backend senior pizza 260",
							"java backend junior chicken 80","python backend senior chicken 50"};

		String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200",
						  "cpp and - and senior and pizza 250","- and backend and senior and - 150",
						  "- and - and - and chicken 100","- and - and - and - 150"};
	   
		int[] result = Solution.solution(info,query);
		for(int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
		
	
	}
	static class Solution {	
		public static int[] solution(String[] info, String[] query) {
			Map<String, List<Integer>> map = new HashMap<>();
			for(String str : info) {
				String[] arr = str.split(" ");
				int score = Integer.parseInt(arr[4]);
				
				for(int i=0; i<(1<<4); i++) { // 1<<4 = 1 * 2^4 
					StringBuilder key = new StringBuilder();
					for(int j=0; j<4; j++) {
						if((i & (1 << j)) > 0) key.append(arr[j]);
					}
					// Value value = map.computeIfAbsent(key, k -> getNewValue(key));
					// Key 값에 해당하는 Value가 존재하면 가져와서 사용하고 없으면 새로 만들어줌
					// => value가 없다면 새로운 ArrayList를 생성하고 생성한 List에 점수를 넣어주기
					map.computeIfAbsent(key.toString(), s -> new ArrayList<>()).add(score);
				}
			}
			
			List<Integer> empty = new ArrayList<>();
			
		
			// entrySet : map에 저장된 key-value값을 엔트리(키와 값 결합)의 형태로 set에 저장하여 반환
	        for (Map.Entry<String, List<Integer>> entry : map.entrySet())
	        	// list 정렬
	            entry.getValue().sort(null);

	        int[] answer = new int[query.length];
	        for (int i = 0; i < query.length; i++) {
	            String[] split = query[i].replaceAll("-", "").split(" and | ");
	            String key = String.join("", split[0], split[1], split[2], split[3]);
	            int score = Integer.parseInt(split[4]);
	           
	            // getOrDefault : 찾는 키가 존재하면 키의 값 반환, 없으면 기본값(아래의 empty) 반환
	            List<Integer> list = map.getOrDefault(key, empty);

	            int s = 0, e = list.size();

	            while (s < e) {
	                int mid = (s + e) / 2;

	                if (list.get(mid) < score) s = mid + 1;
	                else e = mid;
	            }

	            answer[i] = list.size() - s;
	        }

	        return answer;
	   }
		
	}
}
