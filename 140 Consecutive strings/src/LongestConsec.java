//Sequential Strings
//You are given an array (list) of strings and an integer k. Your task is to return the first longest string consisting
//of k
//sequential strings taken from the array.
//Examples:
//strarr = ["tree", "foling", "trash", "blue", "abcdef", "uvwxyz"], k = 2
//Concatenating consecutive strarr strings by 2 gives:
//treefoling (length 10) concatenation of strarr[0] and strarr[1]
//folingtrashy (" 12) concatenation of strarr[1] and strarr[2]
//trashyblue (" 10) concatenation of strarr[2] and strarr[3]
//blueabcdef (" 10) concatenation of strarr[3] and strarr[4]
//abcdefuvwxyz (" 12) concatenation of strarr[4] and strarr[5]
//The two longest strings are "folingtrashy" and "abcdefuvwxyz".
//The first thing that came up was "folingtrash" so
//longest_consec(strarr, 2) should return "folingtrashy".
//Likewise:
//longest_consec(["zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"], 2) --> "abigailtheta"
//n is the length of the string array, if n = 0 or k > n or k <= 0, return "" (return Nothing in Elm).
//Note
//consecutive strings: follow one after another without a break

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestConsec {
    public static void main(String[] args) {
        System.out.println(longestConsec(new String[]{"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2)); // "abigailtheta"
        System.out.println(longestConsec(new String[]{"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"}, 1)); // "oocccffuucccjjjkkkjyyyeehh"
        System.out.println(longestConsec(new String[]{}, 3)); // ""
        System.out.println(longestConsec(new String[]{"itvayloxrp", "wkppqsztdkmvcuwvereiupccauycnjutlv", "vweqilsfytihvrzlaodfixoyxvyuyvgpck"}, 2)); // "wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck"
        System.out.println(longestConsec(new String[]{"wlwsasphmxx", "owiaxujylentrklctozmymu", "wpgozvxxiu"}, 2)); // "wlwsasphmxxowiaxujylentrklctozmymu"
        System.out.println(longestConsec(new String[]{"zone", "abigail", "theta", "form", "libe", "zas"}, -2)); // ""
        System.out.println(longestConsec(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 3)); // "ixoyx3452zzzzzzzzzzzz"
        System.out.println(longestConsec(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 15)); // ""
        System.out.println(longestConsec(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 0)); // ""
        System.out.println("___________________________");

        System.out.println(longestConsec2(new String[]{"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2)); // "abigailtheta"
        System.out.println(longestConsec2(new String[]{"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"}, 1)); // "oocccffuucccjjjkkkjyyyeehh"
        System.out.println(longestConsec2(new String[]{}, 3)); // ""
        System.out.println(longestConsec2(new String[]{"itvayloxrp", "wkppqsztdkmvcuwvereiupccauycnjutlv", "vweqilsfytihvrzlaodfixoyxvyuyvgpck"}, 2)); // "wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck"
        System.out.println(longestConsec2(new String[]{"wlwsasphmxx", "owiaxujylentrklctozmymu", "wpgozvxxiu"}, 2)); // "wlwsasphmxxowiaxujylentrklctozmymu"
        System.out.println(longestConsec2(new String[]{"zone", "abigail", "theta", "form", "libe", "zas"}, -2)); // ""
        System.out.println(longestConsec2(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 3)); // "ixoyx3452zzzzzzzzzzzz"
        System.out.println(longestConsec2(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 15)); // ""
        System.out.println(longestConsec2(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 0)); // ""
        System.out.println("___________________________");

        System.out.println(longestConsec3(new String[]{"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2)); // "abigailtheta"
        System.out.println(longestConsec3(new String[]{"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"}, 1)); // "oocccffuucccjjjkkkjyyyeehh"
        System.out.println(longestConsec3(new String[]{}, 3)); // ""
        System.out.println(longestConsec3(new String[]{"itvayloxrp", "wkppqsztdkmvcuwvereiupccauycnjutlv", "vweqilsfytihvrzlaodfixoyxvyuyvgpck"}, 2)); // "wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck"
        System.out.println(longestConsec3(new String[]{"wlwsasphmxx", "owiaxujylentrklctozmymu", "wpgozvxxiu"}, 2)); // "wlwsasphmxxowiaxujylentrklctozmymu"
        System.out.println(longestConsec3(new String[]{"zone", "abigail", "theta", "form", "libe", "zas"}, -2)); // ""
        System.out.println(longestConsec3(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 3)); // "ixoyx3452zzzzzzzzzzzz"
        System.out.println(longestConsec3(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 15)); // ""
        System.out.println(longestConsec3(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 0)); // ""
        System.out.println("___________________________");

        System.out.println(longestConsec2Strings(new String[]{"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"})); // "abigailtheta"
        System.out.println(longestConsec2Strings(new String[]{"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"})); // "dqqqaaabbboocccffuucccjjjkkkjyyyeehh"
        System.out.println(longestConsec2Strings(new String[]{})); // ""
        System.out.println(longestConsec2Strings(new String[]{"itvayloxrp", "wkppqsztdkmvcuwvereiupccauycnjutlv", "vweqilsfytihvrzlaodfixoyxvyuyvgpck"})); // "wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck"
        System.out.println(longestConsec2Strings(new String[]{"wlwsasphmxx", "owiaxujylentrklctozmymu", "wpgozvxxiu"})); // "wlwsasphmxxowiaxujylentrklctozmymu"
        System.out.println(longestConsec2Strings(new String[]{"zone", "abigail", "theta", "form", "libe", "zas"})); // "abigailtheta"
        System.out.println(longestConsec2Strings(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"})); // "3452zzzzzzzzzzzz"
        System.out.println(longestConsec2Strings(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"})); // "3452zzzzzzzzzzzz"
        System.out.println(longestConsec2Strings(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"})); // "3452zzzzzzzzzzzz"
    }

    public static String longestConsec(String[] strArr, int k) {
        if (k > strArr.length || k <= 0)
            return "";

        String longestStr = "";
        for (int index = 0; index < strArr.length - k + 1; index++) {
            StringBuilder sb = new StringBuilder();
            for (int i = index; i < index + k; i++) {
                sb.append(strArr[i]);
            }
            if (sb.toString().length() > longestStr.length()) {
                longestStr = sb.toString();
            }
        }
        return longestStr;
    }

    public static String longestConsec2(String[] strarr, int k) {
        if (k <= 0) {
            return "";
        }

        return IntStream.rangeClosed(0, strarr.length - k)
                .mapToObj(i -> Arrays.stream(strarr, i, i + k).collect(Collectors.joining()))
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }

    public static String longestConsec3(String[] strarr, int k) {

        if (k < 1 || strarr.length < k) {
            return "";
        }

        int startIndex = 0;
        int max = strarr[0].length();
        int sum = 0;

        for (int i = 0; i < strarr.length; i++) {
            sum += strarr[i].length();

            if (i > k - 1) {
                sum -= strarr[i - k].length();
            }

            if (sum > max) {
                max = sum;
                startIndex = i - k + 1;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = startIndex; i < startIndex + k; i++) {
            result.append(strarr[i]);
        }
        return result.toString();
    }

    public static String longestConsec2Strings(String[] strArr) {
        if (strArr.length < 2) {
            return "";
        }

        String first = concatStrings(strArr[0], strArr[1]);

        for (int i = 1; i < strArr.length; i++) {
            if (concatStrings(strArr[i - 1], strArr[i]).length() > first.length()) {
                first = concatStrings(strArr[i - 1], strArr[i]);
            }
        }
        return first;
    }

    private static String concatStrings(String one, String two) {
        return one + two;
    }
}
