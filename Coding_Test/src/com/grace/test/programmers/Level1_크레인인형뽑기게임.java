package com.grace.test.programmers;

import java.util.Stack;

public class Level1_크레인인형뽑기게임 {
    // https://programmers.co.kr/learn/courses/30/lessons/64061

    public static void main(String[] args) {

        int[][] board = {{0,0,0,0,0},
                         {0,0,1,0,3},
                         {0,2,5,0,1},
                         {4,2,4,4,2},
                         {3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> bucket = new Stack<>();
        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][move-1] == 0) {
                    continue;
                } else {
                    if (!bucket.isEmpty() && board[i][move-1] == bucket.peek()) {
                        answer += 2;  // 인형은 쌍으로 두개씩 사라짐
                        bucket.pop(); // 바구니에서 삭제
                    } else {
                        bucket.add(board[i][move-1]);
                    }
                    board[i][move-1] = 0; // 0(인형뽑은 상태)로 변경
                    break;
                }
            }
        }
        return answer;
    }

}
