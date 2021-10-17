package com.grace.test.etc;

import java.util.Scanner;

public class Test {
    public static void main(String [] args) {
        System.out.println("10개의 점수를 입력하세요");
        int[] scores = new int[10];
        int[] count = new int[11];

        for(int i=0;i<scores.length;i++) {
            Scanner scan = new Scanner(System.in);
            scores[i] = scan.nextInt();
        }
        System.out.println("[결과]");
        for(int i=0;i<scores.length;i++) {
            if(scores[i] >= 0 && scores[i] < 10) {
                count[0] ++;
            }else if(scores[i] >= 10 && scores[i] < 20){
                count[1] ++;
            }else if(scores[i] >= 20 && scores[i] < 30){
                count[2] ++;
            }else if(scores[i] >= 30 && scores[i] < 40){
                count[3] ++;
            }else if(scores[i] >= 40 && scores[i] < 50){
                count[4] ++;
            }else if(scores[i] >= 50 && scores[i] < 60){
                count[5] ++;
            }else if(scores[i] >= 60 && scores[i] < 70){
                count[6] ++;
            }else if(scores[i] >= 70 && scores[i] < 80){
                count[7] ++;
            }else if(scores[i] >= 80 && scores[i] < 90){
                count[8] ++;
            }else if(scores[i] >= 90 && scores[i] < 100){
                count[9] ++;
            }else{
                count[10] ++;
            }
        }

        for(int i= 0; i< count.length; i++ ){
            if(i==0){
                System.out.println("1점대:" + count[i]);
            }else{
                System.out.println(i*10+"점대:" + count[i]);
            }
        }
    }
}

