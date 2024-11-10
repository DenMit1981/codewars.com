//Complete a function that takes an array of integers as input and finds the sum of the squares of the elements in even
//positions (i.e. 2nd, 4th, etc.) plus the sum of the remaining elements in odd positions.
//For empty arrays, the result should be zero (except in Haskell).
//Note
//The values in even positions need to be squared. For a language with zero-based indices, this will
//happen at odd-index locations. For example, in Python, the values at indices 1, 3, 5, etc. should be squared, since
//these are the second, fourth, and sixth positions in the list.
//Example
//[11, 12, 13, 14, 15] --> 379
//# 1. 2. 3. 4. 5. position
//11 + 12^2 + 13 + 14^2 + 15 = 379
//Explanation:
//The elements with indices 0, 2, 4 are 11, 13, 15, and they are in odd positions: 11 is in position #1, 13 is in
//position #3, and 15 is in position #5.
//The elements with indices 1, 3 are 12 and 14, and they are in even positions. So, we need to add 11, 13, 15 as is
//and square 12 and 14.

import java.util.stream.IntStream;

public class Kata {
    public static void main(String[] args) {
        System.out.println(alternateSqSum(new int[]{11, 12, 13, 14, 15})); //379
        System.out.println(alternateSqSum2(new int[]{11, 12, 13, 14, 15})); //379
    }

    public static int alternateSqSum(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 != 0) {
                arr[i] *= arr[i];
            }
            sum += arr[i];
        }

        return sum;
    }

    public static int alternateSqSum2(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        return IntStream.range(0, arr.length)
                .map(i -> i % 2 != 0 ? arr[i] * arr[i] : arr[i])
                .sum();
    }
}
