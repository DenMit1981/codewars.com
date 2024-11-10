//Given a string, capitalize the letters that occupy even and odd indices separately and return,
//as shown below. Index 0 will be considered even.
//For example, capital ("abcdef") = ['AbCdEf', 'aBcDeF']. See the test cases for more examples.
//The input will be a lowercase string with no spaces.

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(capitalize("abcdef"))); //[AbCdEf, aBcDeF]
        System.out.println(Arrays.toString(capitalize("codewars"))); //[CoDeWaRs, cOdEwArS]
        System.out.println(Arrays.toString(capitalize("abracadabra"))); //[AbRaCaDaBrA, aBrAcAdAbRa]
        System.out.println(Arrays.toString(capitalize("codewarriors"))); //[CoDeWaRrIoRs, cOdEwArRiOrS]
        System.out.println();

        System.out.println(Arrays.toString(capitalize2("abcdef"))); //[AbCdEf, aBcDeF]
        System.out.println(Arrays.toString(capitalize2("codewars"))); //[CoDeWaRs, cOdEwArS]
        System.out.println(Arrays.toString(capitalize2("abracadabra"))); //[AbRaCaDaBrA, aBrAcAdAbRa]
        System.out.println(Arrays.toString(capitalize2("codewarriors"))); //[CoDeWaRrIoRs, cOdEwArRiOrS]
        System.out.println();

        System.out.println(Arrays.toString(capitalize3("abcdef"))); //[AbCdEf, aBcDeF]
        System.out.println(Arrays.toString(capitalize3("codewars"))); //[CoDeWaRs, cOdEwArS]
        System.out.println(Arrays.toString(capitalize3("abracadabra"))); //[AbRaCaDaBrA, aBrAcAdAbRa]
        System.out.println(Arrays.toString(capitalize3("codewarriors"))); //[CoDeWaRrIoRs, cOdEwArRiOrS]
    }

    public static String[] capitalize(String s) {
        String wordWithUpperCaseForEvenIndex = lettersInUpperCaseForEvenIndex(s);

        return new String[]{wordWithUpperCaseForEvenIndex,
                changeLetterCase(wordWithUpperCaseForEvenIndex)};
    }

    private static String lettersInUpperCaseForEvenIndex(String s) {
        StringBuilder sb = new StringBuilder();
        String[] str = s.split("");

        for (int i = 0; i < str.length; i++) {
            if (i % 2 == 0) {
                sb.append(str[i].toUpperCase());
            } else {
                sb.append(str[i]);
            }
        }

        return sb.toString();
    }

    private static String changeLetterCase(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (Character.isUpperCase(c)) {
                chars[i] = Character.toLowerCase(c);
            } else {
                chars[i] = Character.toUpperCase(c);
            }
        }

        return new String(chars);
    }

    public static String[] capitalize2(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        return new String[]{
                IntStream.range(0, chars.length)
                        .mapToObj(i -> String.valueOf(i % 2 == 0 ? Character.toUpperCase(chars[i]) : chars[i]))
                        .collect(Collectors.joining()),
                IntStream.range(0, chars.length)
                        .mapToObj(i -> String.valueOf(i % 2 == 1 ? Character.toUpperCase(chars[i]) : chars[i]))
                        .collect(Collectors.joining())

        };
    }

    public static String[] capitalize3(String s) {
        String first = IntStream.range(0, s.length())
                .map(x -> x % 2 == 0 ? Character.toUpperCase(s.charAt(x)) : s.charAt(x))
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
        String second = IntStream.range(0, s.length())
                .map(x -> x % 2 != 0 ? Character.toUpperCase(s.charAt(x)) : s.charAt(x))
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
        return new String[]{first, second};
    }
}

