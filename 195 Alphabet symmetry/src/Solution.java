//Consider the word "abode". We see that the letter a is in position 1 and the letter b is in position 2.
//In the alphabet, the letters a and b are also in positions 1 and 2. Also note that the d and e in the word abode
//occupy the same positions as in the alphabet, which are positions 4 and 5.
//Given an array of words, return an array of the number of letters that occupy their positions in the alphabet for each word.
//For example,
//solve(["abode","ABc","xyzD"]) = [4, 3, 1]
//The input will consist of letters of the alphabet, both upper and lower case. There are no spaces.

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new String[]{"abode", "ABc", "xyzD"}))); //[4, 3, 1]
        System.out.println(Arrays.toString(solve(new String[]{"abide", "ABc", "xyz"}))); //[4, 3, 0]
        System.out.println(Arrays.toString(solve(new String[]{"IAMDEFANDJKL", "thedefgh", "xyzDEFghijabc"}))); //[6, 5, 7]
        System.out.println(Arrays.toString(solve(new String[]{"encode", "abc", "xyzD", "ABmD"}))); //[1, 3, 1, 3]
    }

    public static int[] solve(String[] arr) {
        int[] countArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            countArr[i] = getLettersCount(arr[i]);
        }

        return countArr;
    }

    private static int getNumberOfLetter(char letter) {
        return Character.getNumericValue(letter) - 9;
    }

    private static int getLettersCount(String word) {
        int count = 0;

        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (getNumberOfLetter(chars[i]) == i + 1) {
                count++;
            }
        }
        return count;
    }
}
