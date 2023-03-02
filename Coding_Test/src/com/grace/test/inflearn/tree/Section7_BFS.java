package com.grace.test.inflearn.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Section7_BFS {

  public static void main(String[] args) {


    // 송아지 찾기
    // 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다
    System.out.println("송아지찾기 : " + searchCalf(5, 14));


  }

  public static int searchCalf(int S, int E) {
    int answer = 0;
    int[] dis = {1, -1, 5};
    int[] ch = new int[10001];
    Queue<Integer> queue = new LinkedList<>();
    // 방문 했는지 체크
    ch[S] = 1;
    queue.offer(S);
    int level = 0;
    while (!queue.isEmpty()) {
      int len = queue.size();
      for(int i=0; i<len; i++) {
        int x = queue.poll();
        for(int j =0; j<dis.length; j++) {
          int nextX = x + dis[j];
          if(nextX == E) return level + 1;
          if(nextX > 0 && nextX <= 10000 && ch[nextX] == 0) {
            ch[nextX] = 1;
            queue.offer(nextX);
          }
        }
      }
      level++;
    }

    return answer;
  }



}
