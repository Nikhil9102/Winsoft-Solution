import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCharacters {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        
        Map<Character, Integer> duplicates = findDuplicateCharacters(input);
        
        System.out.println("Duplicate characters:");
        for (Map.Entry<Character, Integer> entry : duplicates.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
            }
        }
    }
    
    public static Map<Character, Integer> findDuplicateCharacters(String str) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        char[] chars = str.toCharArray();
        
        for (char c : chars) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        
        return charCountMap;
    }
}