package com.grace.test.case1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Case3 {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String inputFilename = scan.nextLine();

        String outputFileName = "gifs_" + inputFilename;

        Pattern gifPattern = Pattern.compile("GET\\s+/[^\\s]+/(\\S+\\.gif)\\s+HTTP/1\\.0\"\\s+200\\s");
        HashSet<String> gifSet = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = gifPattern.matcher(line);
                if (matcher.find()) {
                    gifSet.add(matcher.group(1));
                }
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (String gif : gifSet) {
                writer.write(gif);
                writer.newLine();
            }
        }
    }

}
