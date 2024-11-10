//Your task is to remove all repeated words from the string, leaving only single (first) words.
//Example:
//Input:
//'alpha beta beta gamma gamma gamma delta alpha beta beta gamma gamma gamma delta'
//Output:
//'alpha beta gamma delta'

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(removeDuplicateWords("alpha beta beta gamma gamma gamma delta alpha beta beta gamma gamma gamma delta")); //alpha beta gamma delta
        System.out.println(removeDuplicateWords("my cat is my cat fat")); //my cat is fat
        System.out.println();

        System.out.println(removeDuplicateWords2("alpha beta beta gamma gamma gamma delta alpha beta beta gamma gamma gamma delta")); //alpha beta gamma delta
        System.out.println(removeDuplicateWords2("my cat is my cat fat")); //my cat is fat
    }

    public static String removeDuplicateWords(String s) {
        String[] words = s.split(" ");

        Set<String> result = new LinkedHashSet<>(Arrays.asList(words));

        return String.join(" ", result);
    }

    public static String removeDuplicateWords2(String s) {
        return Arrays.stream(s.split(" "))
                .distinct()
                .collect(Collectors.joining(" "));
    }
}
