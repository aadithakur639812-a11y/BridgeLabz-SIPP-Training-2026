import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SortCharactersByFrequency {
    public static String frequencySort(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char ch : input.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        List<Character> characters = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(characters, (first, second) -> frequencyMap.get(second) - frequencyMap.get(first));

        StringBuilder result = new StringBuilder();
        for (char ch : characters) {
            for (int i = 0; i < frequencyMap.get(ch); i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string: ");
        String input = scanner.nextLine();

        System.out.println("Sorted by frequency: " + frequencySort(input));
        scanner.close();
    }
}
