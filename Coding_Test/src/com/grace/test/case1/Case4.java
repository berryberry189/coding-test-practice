package com.grace.test.case1;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Case4 {

    public static void main(String[] args) throws IOException {

        Pattern gifPattern = Pattern.compile("GET\\s+/[^\\s]+/(\\S+\\.gif)\\s+HTTP/1\\.0\"\\s+200\\s");
        HashSet<String> gifSet = new HashSet<>();
        List<String> lineList = new ArrayList<>();
        lineList.add("burger.letters.com - - [01/Jul/1995:00:00:11 -0400] \"GET /shuttle/countdown/liftoff.html HTTP/1.0\" 304 0");
        lineList.add("burger.letters.com - - [01/Jul/1995:00:00:12 -0400] \"GET /images/NASA-logosmall.gif HTTP/1.0\" 304 0");
        lineList.add("d104.aa.net - - [01/Jul/1995:00:00:15 -0400] \"GET /shuttle/countdown/count.gif HTTP/1.0\" 200 40310");
        lineList.add("d104.aa.net - - [01/Jul/1995:00:00:15 -0400] \"GET /shuttle/countdown/count.gif HTTP/1.0\" 200 40310");
        lineList.add("d104.aa.net - - [01/Jul/1995:00:00:15 -0400] \"GET /images/NASA-logosmall.gif HTTP/1.0\" 200 786");


        for (String line : lineList) {
            if (line.contains(" 200 ")) {
                Matcher matcher = gifPattern.matcher(line);
                if (matcher.find()) {
                    gifSet.add(matcher.group(1)); // group(1)로 수정
                }
            }
        }

        System.out.println("=======================");
        for (String line : gifSet) {
            System.out.println(line);
        }

    }

}
