//Given two arrays of strings a1 and a2, returns a sorted array r in lexicographic order of the strings of a1,
//which are substrings of a2.
//Example 1:
//a1 = ["arp", "live", "strong"]
//a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
//returns ["arp", "live", "strong"]
//
//Example 2:
//a1 = ["tarp", "mice", "bull"]
//a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
//returns []

import java.util.Arrays;

public class WhichAreIn {

    public static void main(String[] args) {

        System.out.println(isArrayContainsString(new String[]{"lively", "alive", "harp", "sharp", "armstrong"}, "live")); //true
        System.out.println(isArrayContainsString(new String[]{"lively", "alive", "harp", "sharp", "armstrong"}, "tarp")); //false

        System.out.println(Arrays.toString(inArray(new String[]{"arp", "live", "strong"},
                new String[]{"lively", "alive", "harp", "sharp", "armstrong"})));

        System.out.println(Arrays.toString(inArray(new String[]{"tarp", "mice", "bull"},
                new String[]{"lively", "alive", "harp", "sharp", "armstrong"})));
    }

    public static String[] inArray(String[] array1, String[] array2) {
        return Arrays.stream(array1)
                .sorted()
                .filter(s -> isArrayContainsString(array2, s))
                .toArray(String[]::new);
    }

    private static boolean isArrayContainsString(String[] array, String str) {
        return Arrays.stream(array).anyMatch(el -> el.contains(str));
    }
}
