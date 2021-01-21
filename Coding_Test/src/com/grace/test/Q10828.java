package com.grace.test;

import java.io.*;
import java.util.*;
public class Q10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        String command = "";
        for(int i=0; i<N; i++) {
            command = br.readLine();
            if(command.contains("push")) {
                String arr[] = command.split(" ");
                stack.push(Integer.parseInt(arr[1]));
            }else if(command.equals("pop")) {
                System.out.println(stack.isEmpty() ? -1 : stack.pop());
            }else if(command.equals("size")) {
                System.out.println(stack.size());
            }else if(command.equals("empty")) {
                System.out.println(stack.isEmpty() ? 1 :0);
            }else { // top
               System.out.println(stack.isEmpty()? -1 : stack.peek()); 
            }
        }

    }
}
