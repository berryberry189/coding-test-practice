package com.grace.test.case1;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Case5 {

    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        String inputFilename = scan.nextLine();
        String outputFilename = "req_" + inputFilename;

        Map<String, Integer> timestampMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                String timestampStr = parts[3].substring(1);
                LocalDateTime timestamp = LocalDateTime.parse(timestampStr, DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss"));
                String timestampKey = timestamp.format(DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss"));
                timestampMap.put(timestampKey, timestampMap.getOrDefault(timestampKey, 0) + 1);
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename))) {
            timestampMap.entrySet().stream()
                    .filter(entry -> entry.getValue() > 1)
                    .map(Map.Entry::getKey)
                    .sorted()
                    .forEach(key -> {
                        try {
                            writer.write(key + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
