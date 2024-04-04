import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to count words:");
        String input = scanner.nextLine();

        String normalized = input.toLowerCase();

        String[] words = normalized.split("\\s+");

        Map<String, Integer> wordCounts = countWords(words);

        System.out.println("Word counts:");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static Map<String, Integer> countWords(String[] words) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        
        for (String word : words) {
            if (!word.isEmpty()) { 
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }
        
        return wordCountMap;
    }
}