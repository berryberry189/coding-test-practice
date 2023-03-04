package com.grace.test.case1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Case2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int gridRows = Integer.parseInt(bufferedReader.readLine().trim());
        int gridColumns = Integer.parseInt(bufferedReader.readLine().trim());

        int[][] grid = new int[gridRows][gridRows];

        for(int i=0; i<gridRows; i++) {
            String[] strArr = bufferedReader.readLine().split(" ");
            for(int k=0; k<gridColumns; k++) {
                grid[i][k] = Integer.parseInt(strArr[k]);
            }
        }

        int maxSum = Integer.parseInt(bufferedReader.readLine().trim());

        int result = ResultCase2.largestSubgrid(grid, maxSum);

        bufferedWriter.write(String.valueOf(result));

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


class ResultCase2 {

    public static int largestSubgrid(int[][] grid, int maxSum) {
        int n = grid.length;
        int[][] subGrid = new int[n+1][n+1];

        // 2차원 배열 prefix를 사용하여 전체 그리드를 초기화합니다.
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= n; k++) {
                subGrid[i][k] = grid[i-1][k-1] + subGrid[i-1][k] + subGrid[i][k-1] - subGrid[i-1][k-1];
            }
        }

        // 서브 그리드의 크기를 늘려가며 가능한 모든 값을 비교합니다.
        for (int i = n; i >= 1; i--) {
            int maxSumPossible = i*i*maxSum;
            if (maxSumPossible < subGrid[i][i]) {
                continue;
            }
            for (int j = i; j <= n; j++) {
                for (int k = i; k <= n; k++) {
                    int sum = subGrid[j][k] - subGrid[j-i][k] - subGrid[j][k-i] + subGrid[j-i][k-i];
                    if (sum <= maxSum) {
                        return i;
                    }
                }
            }
        }
        return 0;
    }



}



