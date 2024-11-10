//In this Kata you will be given a string that may contain mixed uppercase and lowercase letters,
//and your task is to convert this string to either all lowercase or all uppercase based on:
//make as few changes as possible.
//if the string contains the same number of uppercase and lowercase letters, convert the string to lowercase.
//For example:
//solve("coDe") = "code". Lowercase characters > uppercase. Change only the "D" to lowercase.
//solve("CODe") = "CODE". Uppercase characters > lowercase. Change only the "e" to uppercase.
//solve("coDE") = "code". Upper == lowercase. Change all to lowercase.

import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solve("code")); //"code"
        System.out.println(solve("CODe")); //"CODE"
        System.out.println(solve("COde")); //"code"
        System.out.println(solve("Code")); //"code"
        System.out.println(solve("")); //""

        System.out.println(solve2("code")); //"code"
        System.out.println(solve2("CODe")); //"CODE"
        System.out.println(solve2("COde")); //"code"
        System.out.println(solve2("Code")); //"code"
        System.out.println(solve2("")); //""
    }

    public static String solve(final String str) {
        int upperLettersCount = 0;
        int lowerLettersCount = 0;

        char[] symbols = str.toCharArray();

        for (char symbol : symbols) {
            if (Character.isUpperCase(symbol)) {
                upperLettersCount++;
            } else {
                lowerLettersCount++;
            }
        }
        return lowerLettersCount >= upperLettersCount ? str.toLowerCase() : str.toUpperCase();
    }

    public static String solve2(final String str) {
        Character[] symbols = str.chars().mapToObj(i -> (char) i).toArray(Character[]::new);

        long upperLettersCount = Stream.of(symbols).filter(Character::isUpperCase).count();
        long lowerLettersCount = Stream.of(symbols).filter(Character::isLowerCase).count();

        return lowerLettersCount >= upperLettersCount ? str.toLowerCase() : str.toUpperCase();
    }
}
