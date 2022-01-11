package com.grace.test.programmers;

public class Level1_키패드누르기 {

    // https://programmers.co.kr/learn/courses/30/lessons/67256/questions

    // 1, 2, 3
    // 4, 5, 6
    // 7, 8, 9
    // *, 0, #  (10, 11, 12)

    static int left = 10;
    static int right = 12;

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(solution(numbers, hand));
    }

    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        for (int num : numbers) {
            if(num == 1 || num == 4 || num == 7){
                sb.append("L");
                left = num;
            }else if(num == 3 || num == 6 || num == 7){
                sb.append("R");
                right = num;
            }else{
                if(num == 0) num = 11;
                sb.append(getSide(num, left, right, hand));
            }
        }
        String answer = sb.toString();
        return answer;
    }

    private static String getSide(int num, int l, int r, String hand) {
        int leftDistance  = getDistance(l, num);
        int rightDistance = getDistance(r, num);

        if(leftDistance > rightDistance){
            right = num;
            return "R";
        } else if(leftDistance < rightDistance){
            left = num;
            return "L";
        }else{
            if(hand.equals("right")) {
                right = num;
                return "R";
            }else {
                left = num;
                return "L";
            }
        }
    }

    private static int getDistance(int location, int num) {
        location = (location == 0) ? 11 : location;
        num = (num == 0) ? 11 : num;
        int x1 = (location-1)/3;
        int y1 = (location-1)%3;
        int x2 = (num-1)/3;
        int y2 = (num-1)%3;

        return Math.abs(x1 - x2) +  Math.abs(y1 - y2);
    }
}
