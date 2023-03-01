package com.grace.test.hacker_rank;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.stream.Stream;

public class ClimbingTheLeaderboard {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    List<Integer> result = ResultClimbingTheLeaderboard.climbingLeaderboard(ranked, player);

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


class ResultClimbingTheLeaderboard {

  public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    List<Integer> resultList = new ArrayList<>();

    TreeSet<Integer> rankedTreeSet = new TreeSet<>(ranked);
    // 내림차순 정렬 (현재 리더보드의 순위)
    NavigableSet<Integer> descendingRankedSet = rankedTreeSet.descendingSet();

    Map<Integer, Integer> rankMap = new HashMap();
    int rank = 1;
    for (Integer score : descendingRankedSet) {
      rankMap.put(score, rank);
      rank++;
    }

    for (Integer score : player) {
      if(score > descendingRankedSet.first()) {
        resultList.add(1);
        continue;
      }
      if(score < descendingRankedSet.last()) {
        resultList.add(rankMap.get(descendingRankedSet.last())  + 1);
        continue;
      }
      resultList.add(rankMap.get(descendingRankedSet.ceiling(score)));
    }

    return resultList;
  }
}



