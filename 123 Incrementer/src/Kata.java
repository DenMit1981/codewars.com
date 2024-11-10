//Given an input of an array of digits, return an array in which each digit is incremented by its position in the array:
//the first digit will be incremented by 1, the second digit by 2, and so on. Make sure you start counting your
//positions from 1 (not 0).
//Your result can only contain single-digit numbers, so if adding a digit with its position gives you a multi-digit
//number, only the last digit of the number should be returned.
//Notes:
//return an empty array if your array is empty
//arrays will only contain numbers, so don't worry about checking for this
//Examples:
//[1, 2, 3] --> [2, 4, 6] # [1+1, 2+2, 3+3]
//
//[4, 6, 9, 1, 3] --> [5, 8, 2, 5, 8] # [4+1, 6+2, 9+3, 1+4, 3+5]
//# 9+3 = 12 --> 2

import java.util.Arrays;

public class Kata {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(incrementer(new int[]{}))); //[]
        System.out.println(Arrays.toString(incrementer(new int[]{1, 2, 3}))); //[2, 4, 6]
        System.out.println(Arrays.toString(incrementer(new int[]{4, 6, 7, 1, 3}))); //[5, 8, 0, 5, 8]
        System.out.println(Arrays.toString(incrementer(new int[]{3, 6, 9, 8, 9}))); //[4, 8, 2, 2, 4]
        System.out.println(Arrays.toString(incrementer(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9, 9, 8}))); //[2, 4, 6, 8, 0, 2, 4, 6, 8, 9, 0, 1, 2, 2]
    }

    public static int[] incrementer(int[] numbers) {
        int[] arr = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = numbers[i] + i + 1;
            if (arr[i] > 9) {
                arr[i] = Integer.parseInt(String.valueOf(arr[i]).substring(String.valueOf(arr[i]).length() - 1));
            }
        }
        return arr;
    }
}
