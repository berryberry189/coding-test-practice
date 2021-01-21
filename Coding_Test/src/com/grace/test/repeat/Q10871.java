package com.grace.test.repeat;

import java.io.*;
import java.util.*;

public class Q10871 {

	public static void main(String[] args) throws IOException {
		// X보다 작은 수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int N = Integer.parseInt(strs[0]);
        int X = Integer.parseInt(strs[1]);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            int A = Integer.parseInt(st.nextToken());
            if (A < X) System.out.print(A + "\n");
        }
        br.close();

	}

}
