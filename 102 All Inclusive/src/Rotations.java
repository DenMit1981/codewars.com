//Input: string, array of strings arr
//Output of contain_all_rots(string, arr) (or containAllRots, or contain-all-rots):
//Boolean true if all rotations of string are included in arr (C returns 1)
//otherwise false (C returns 0)
//Examples:
//contain_all_rots(
//"bsjq", ["bsjq", "qbsj", "sjqb", "twZNsslC", "jqbs"]) -> true
//contain_all_rots(
//"Ajylvpy", ["Ajylvpy", "ylvpyAj", "jylvpyA", "lvpyAjy", "pyAjylv", "vpyAjyl", "ipywee"]) -> false)
//Note:
//Although it is not correct in the mathematical sense
//we will assume that there is no rotation of string == ""
//and for any array arr: contain_all_rots ("", arr) -> true

import java.util.Arrays;
import java.util.*;

public class Rotations {
    public static void main(String[] args) {
        List<String> arr1 = Arrays.asList("bsjq", "qbsj", "sjqb", "twZNsslC", "jqbs");
        List<String> arr2 = Arrays.asList("TzYxlgfnhf", "yqVAuoLjMLy", "BhRXjYA", "YABhRXj", "hRXjYAB", "jYABhRX", "XjYABhR", "ABhRXjY");
        List<String> arr3 = Arrays.asList("bsjq", "qbsj");

        System.out.println(containAllRots("bsjq", arr1)); //true
        System.out.println(containAllRots("XjYABhR", arr2)); //false
        System.out.println(containAllRots("", arr3)); //true

        System.out.println(containAllRots1("bsjq", arr1)); //true
        System.out.println(containAllRots1("XjYABhR", arr2)); //false
        System.out.println(containAllRots1("", arr3)); //true

    }

    public static boolean containAllRots(String s, List<String> arr) {
        if (s.length() == 0) return true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int cursor = s.length() - i;
            sb.append(s.substring(cursor)).append(s.substring(0, cursor)).append(" "); //циклический сдвиг вправо
        }
        String[] str = sb.toString().split(" ");
        int count = 0;
        for (String el : arr) {
            for (String ss : str) {
                if (el.contains(ss)) {
                    count++;
                }
            }
        }
        return count == str.length;
    }

    public static boolean containAllRots1(String s, List<String> arr) {
        if (s.length() == 0) return true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int cursor = s.length() - i;
            sb.append(s.substring(cursor)).append(s.substring(0, cursor)).append(" "); //циклический сдвиг вправо
        }
        String[] str = sb.toString().split(" ");
        return arr.containsAll(Arrays.asList(str));
    }
}
