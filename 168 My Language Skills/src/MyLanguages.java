//You are given a dictionary/hash/object containing several languages and your test scores in those languages.
//Return a list of languages where your test score is at least 60, in descending score order.
//Note: Scores will always be unique (so there will be no duplicate values).
//Examples:
//{"Java" => 10, "Ruby" => 80, "Python" => 65} --> ["Ruby", "Python"]
//{"Hindi" => 60, "Dutch" => 93, "Greek" => 71} --> ["Dutch", "Greek", "Hindi"]
//{"C++" => 50, "ASM" => 10, "Haskell" => 20} --> []

import java.util.*;
import java.util.stream.Collectors;

public class MyLanguages {

    public static void main(String[] args) {
        Map<String, Integer> map1 = Map.of("Java", 10, "Ruby", 80, "Python", 65); //[Ruby, Python]
        Map<String, Integer> map2 = Map.of("Hindi", 60, "Dutch", 93, "Greek", 71); //[Dutch, Greek, Hindi]
        Map<String, Integer> map3 = Map.of("C++", 50, "ASM", 10, "Haskell", 20); //[]

        System.out.println(myLanguages(map1));
        System.out.println(myLanguages(map2));
        System.out.println(myLanguages(map3));
    }

    public static List<String> myLanguages(final Map<String, Integer> results) {
        return results.entrySet()
                .stream()
                .filter(s -> s.getValue() >= 60)
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
