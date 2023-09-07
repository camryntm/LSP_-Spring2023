package org.howard.edu.lsp.assignment2;

/**
*  Name: Camryn Turner-Markes
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCounter {
    public static void main(String[] args) {
        try {
            File inputFile = new File("src/org/howard/edu/lsp/assignment2/word.txt");
            Scanner scanner = new Scanner(inputFile);

            Map<String, Integer> wordCountMap = new TreeMap<>(); // Use TreeMap for sorting

            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase(); // Convert to lowercase
                // Remove punctuation from the word
                word = word.replaceAll("[^a-zA-Z']", "");
                // Check if the word is not numeric and has more than 3 characters
                if (!isNumeric(word) && word.length() > 3) {
                    // Count the word
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }

            // Close the scanner when done
            scanner.close();

            // Write word counts to an output file
            writeWordCountsToFile(wordCountMap, "src/org/howard/edu/lsp/assignment2/word_counts.txt");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Helper method to check if a string is numeric
    public static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    // Helper method to write word counts to a file
    public static void writeWordCountsToFile(Map<String, Integer> wordCountMap, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
