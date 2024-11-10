//Find the missing letter
//Write a method that takes an array of consecutive (ascending) letters as input and returns the missing letter in the array.
//You will always get a valid array. And there will always be exactly one missing letter.
//The array length will always be at least 2.
//The array will always contain letters in only one case.
//Example:
//['a','b','c','d','f'] -> 'e' ['O','Q','R','S'] -> 'P'
//(Use the English alphabet of 26 letters!)

import java.util.stream.IntStream;

public class Kata {
    public static void main(String[] args) {
        System.out.println(findMissingLetter(new char[]{'a', 'b', 'c', 'd', 'f'}));
        System.out.println(findMissingLetter(new char[]{'O', 'Q', 'R', 'S'}));

        System.out.println(findMissingLetter2(new char[]{'a', 'b', 'c', 'd', 'f'}));
        System.out.println(findMissingLetter2(new char[]{'O', 'Q', 'R', 'S'}));
    }

    public static char findMissingLetter(char[] array) {
        char missingLetter = array[0];

        for (int i = 1; i < array.length; i++) {
            if ((int) array[i] - (int) array[i - 1] > 1) {
                missingLetter = (char) ((int) array[i] - 1);
            }
        }
        return missingLetter;
    }

    public static char findMissingLetter2(char[] chars) {
        int pos = IntStream.range(1, chars.length)
                .filter(index -> (chars[index] - chars[index - 1] != 1))
                .findFirst().getAsInt();

        return (char) (chars[pos] - 1);
    }
}
