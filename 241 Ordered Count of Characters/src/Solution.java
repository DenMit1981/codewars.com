//Count the number of occurrences of each character and return it as a (list of tuples) in order of appearance.
//For empty output return (an empty list).
//Consult the solution set-up for the exact data structure implementation depending on your language.
//Example:
//ordered_count("abracadabra") == [('a', 5), ('b', 2), ('r', 2), ('c', 1), ('d', 1)]

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(orderedCount("abracadabra")); //[a=5, b=2, r=2, c=1, d=1]
        System.out.println(orderedCount("Code Wars")); //[C=1, o=1, d=1, e=1,  =1, W=1, a=1, r=1, s=1]
        System.out.println(orderedCount("233312")); //[2=2, 3=3, 1=1]
        System.out.println("___________________");

        System.out.println(orderedCount2("abracadabra")); //[a=5, b=2, r=2, c=1, d=1]
        System.out.println(orderedCount2("Code Wars")); //[C=1, o=1, d=1, e=1,  =1, W=1, a=1, r=1, s=1]
        System.out.println(orderedCount2("233312")); //[2=2, 3=3, 1=1]
    }

    public static List<Map.Entry<Character, Integer>> orderedCount(String text) {
        Map<Character, Integer> counts = new LinkedHashMap<>();

        for (char c : text.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        return new ArrayList<>(counts.entrySet());
    }

    public static List<Map.Entry<Character, Integer>> orderedCount2(String text) {
        return new ArrayList<>(text.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.summingInt(c -> 1)))
                .entrySet());
    }
}
