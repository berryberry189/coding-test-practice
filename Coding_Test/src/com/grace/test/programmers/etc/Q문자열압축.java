package com.grace.test.programmers.etc;

public class Q문자열압축 {

    public static void main(String[] args) {
        System.out.println("Answer: " + solution("ababababc"));
    }

    public static int solution(String s){
        int min = s.length();
        if(s.length() == 1) return 1;

        for(int i = 1; i<=s.length()/2; i++){
            StringBuilder sb= new StringBuilder();
            String temp = "";
            int cnt = 0;

            for(int j=0; j<Math.ceil((double)s.length()/i); j++){
                String val = s.substring(j*i, i*(j+1) >= s.length() ? s.length() : i*(j+1));
                if(!temp.equals(val)) {
                    if(cnt != 1) {
                        sb.append(cnt);
                        cnt = 1;
                    }
                    sb.append(temp);
                    temp = val;
                }
                else{
                    cnt ++;
                }
            }
            if(cnt != 1) sb.append(cnt);
            sb.append(temp);

            min = Math.min(min, sb.toString().length());
        }
        return min;
    }

}


