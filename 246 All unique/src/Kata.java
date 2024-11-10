//Write a program to determine if a string contains only unique characters. Return true if it does and false otherwise.
//The string may contain any of the 128 ASCII characters. Characters are case-sensitive, e.g. 'a' and 'A' are
//considered different characters.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Kata {
    public static void main(String[] args) {
        System.out.println(hasUniqueChars("  nAa")); //false
        System.out.println(hasUniqueChars("abcde")); //true
        System.out.println(hasUniqueChars("++-")); //false
        System.out.println(hasUniqueChars("AaBbc")); //true
        System.out.println("______________________");

        System.out.println(hasUniqueChars2("  nAa")); //false
        System.out.println(hasUniqueChars2("abcde")); //true
        System.out.println(hasUniqueChars2("++-")); //false
        System.out.println(hasUniqueChars2("AaBbc")); //true
    }

    public static boolean hasUniqueChars(String str) {
        boolean hasUniqueChars = true;
        Map<String, Integer> counts = new HashMap<>();
        for (String el : str.split("")) {
            counts.put(el, counts.getOrDefault(el, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > 1) {
                hasUniqueChars = false;
                break;
            }
        }
        return hasUniqueChars;
    }

    public static boolean hasUniqueChars2(String str) {
        return Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .noneMatch(e -> e.getValue() > 1);
    }
}
