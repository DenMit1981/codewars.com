//Given a string, you must return a string in which each character (case-sensitive) is repeated once.

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(doubleChar("String")); //SSttrriinngg
    }

    public static String doubleChar(String s) {
        return Arrays.stream(s.split(""))
                .map(el -> el + el)
                .collect(Collectors.joining());
    }
}
