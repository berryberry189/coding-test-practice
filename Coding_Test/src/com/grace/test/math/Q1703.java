package com.grace.test.math;

import java.io.*;
public class Q1703 {
	public static void main(String[] args) throws Exception{
		//골드바흐 파티션
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int max = 1000000;
		boolean[] check = new boolean[max+1];
		check[0] = check[1] = true;
		for(int i=2; i<=max; i++) {
			if(!check[i]) {
				for(int j=i*2; j<=max; j+=i) {
					check[j] = true;
				}
			}
		}
		int n = Integer.parseInt(br.readLine());
		while(n-- > 0) {
			int m = Integer.parseInt(br.readLine());
			int cnt = 0;
			for(int i=2; i<=m/2; i++) {
				if(!check[i] && !check[m-i]) cnt++;
			}
			bw.write(cnt + "\n");
		}
		bw.flush();
	}
}

/**
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> primes = new ArrayList<>();
    boolean[] check = new boolean[1000001];
    for (int i=2; i<=1000000; i++) {
        if (check[i] == false) {
            primes.add(i);
            for (int j=i+i; j<=1000000; j+=i) {
                check[j] = true;
            }
        }
    }
    int t = sc.nextInt();
    while (t-- > 0) {
        int n = sc.nextInt();
        int ans = 0;
        for (int p : primes) {
            if (n-p >= 2 && p <= n-p) {
                if (check[n-p] == false) {
                    ans += 1;
                }
            } else {
                break;
            }
        }
        System.out.println(ans);
    }
}
 **/
