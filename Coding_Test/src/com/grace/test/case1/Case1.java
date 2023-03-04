package com.grace.test.case1;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Case1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int rotateCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> rotate = IntStream.range(0, rotateCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = ResultCase1.getMaxElementIndexes(a, rotate);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


class ResultCase1 {

    public static List<Integer> getMaxElementIndexes(List<Integer> a, List<Integer> rotate) {
        List<Integer> result = new ArrayList<>();

        int maxValue = Collections.max(a);
        for (Integer rotateValue : rotate) {
            List<Integer> copyA = new ArrayList<>(a);
            if(rotateValue != 0) {
                //Collections.rotate(copyA, rotateValue * -1);
                rotateList(copyA, rotateValue);
            }

            result.add(copyA.indexOf(maxValue));
        }

        return result;
    }

    public static void rotateList(List<Integer> list, int k) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int n = list.size();
        k = k % n;
        if (k == 0) {
            return;
        }
        List<Integer> temp = new ArrayList<>(list.subList(0, k));
        list.subList(0, k).clear();
        list.addAll(temp);
    }

}



