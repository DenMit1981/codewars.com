//In this Kata, you will be given a string and your task will be to return a list of ints detailing the count of
//uppercase letters, lowercase, numbers and special characters (everything else), as follows.
//The order is: uppercase letters, lowercase letters, numbers and special characters.
//"*'&ABCDabcde12345" --> [ 4, 5, 5, 3 ]

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kata {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve("*'&ABCDabcde12345"))); //[4, 5, 5, 3]
        System.out.println(Arrays.toString(solve("@mw>0=QD-iAx!rp9TaG?o&M%l$34L.nbft"))); //[7, 13, 4, 10]
        System.out.println(Arrays.toString(solve("CbgA5<1d-tOwUZTS8yQ"))); //[8, 6, 3, 2]
        System.out.println(Arrays.toString(solve("$Cnl)Sr<7bBW-&qLHI!mY41ODe"))); //[10, 7, 3, 6]
        System.out.println("___________________________");

        System.out.println(Arrays.toString(solve2("*'&ABCDabcde12345"))); //[4, 5, 5, 3]
        System.out.println(Arrays.toString(solve2("@mw>0=QD-iAx!rp9TaG?o&M%l$34L.nbft"))); //[7, 13, 4, 10]
        System.out.println(Arrays.toString(solve2("CbgA5<1d-tOwUZTS8yQ"))); //[8, 6, 3, 2]
        System.out.println(Arrays.toString(solve2("$Cnl)Sr<7bBW-&qLHI!mY41ODe"))); //[10, 7, 3, 6]
        System.out.println("___________________________");

        System.out.println(Arrays.toString(solve3("*'&ABCDabcde12345"))); //[4, 5, 5, 3]
        System.out.println(Arrays.toString(solve3("@mw>0=QD-iAx!rp9TaG?o&M%l$34L.nbft"))); //[7, 13, 4, 10]
        System.out.println(Arrays.toString(solve3("CbgA5<1d-tOwUZTS8yQ"))); //[8, 6, 3, 2]
        System.out.println(Arrays.toString(solve3("$Cnl)Sr<7bBW-&qLHI!mY41ODe"))); //[10, 7, 3, 6]
        System.out.println("___________________________");

        System.out.println(Arrays.toString(solve4("*'&ABCDabcde12345"))); //[4, 5, 5, 3]
        System.out.println(Arrays.toString(solve4("@mw>0=QD-iAx!rp9TaG?o&M%l$34L.nbft"))); //[7, 13, 4, 10]
        System.out.println(Arrays.toString(solve4("CbgA5<1d-tOwUZTS8yQ"))); //[8, 6, 3, 2]
        System.out.println(Arrays.toString(solve4("$Cnl)Sr<7bBW-&qLHI!mY41ODe"))); //[10, 7, 3, 6]

    }

    public static int[] solve(String word) {
        int uppercaseCount = 0;
        int lowercaseCount = 0;
        int numbersCount = 0;
        int specialCount = 0;

        for (String el : word.split("")) {
            if (el.matches("[A-Z]")) {
                uppercaseCount++;
            }
            if (el.matches("[a-z]")) {
                lowercaseCount++;
            }
            if (el.matches("\\d")) {
                numbersCount++;
            }
            if (el.matches("[^a-zA-Z0-9]")) {
                specialCount++;
            }
        }

        return new int[]{uppercaseCount, lowercaseCount, numbersCount, specialCount};
    }

    public static int[] solve2(String word) {
        int uppercaseCount = 0;
        int lowercaseCount = 0;
        int numberCount = 0;
        int specialCharCount = 0;

        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                uppercaseCount++;
            } else if (Character.isLowerCase(c)) {
                lowercaseCount++;
            } else if (Character.isDigit(c)) {
                numberCount++;
            } else {
                specialCharCount++;
            }
        }

        return new int[]{uppercaseCount, lowercaseCount, numberCount, specialCharCount};
    }

    public static int[] solve3(String word) {
        int uppercaseCount = countMatches(word, "[A-Z]");
        int lowercaseCount = countMatches(word, "[a-z]");
        int numberCount = countMatches(word, "\\d");
        int specialCharCount = countMatches(word, "[^A-Za-z0-9]"); // Anything not alphanumeric

        return new int[]{uppercaseCount, lowercaseCount, numberCount, specialCharCount};
    }

    public static int[] solve4(String word) {
        long uppercaseCount = word.chars().filter(Character::isUpperCase).count();
        long lowercaseCount = word.chars().filter(Character::isLowerCase).count();
        long numberCount = word.chars().filter(Character::isDigit).count();
        long specialCharCount = word.chars().filter(c -> !Character.isLetterOrDigit(c)).count();

        return new int[]{(int) uppercaseCount, (int) lowercaseCount, (int) numberCount, (int) specialCharCount};
    }

    private static int countMatches(String text, String regex) {
        return (int) Pattern.compile(regex).matcher(text).results().count();
    }

    private static int countMatches2(String text, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}

