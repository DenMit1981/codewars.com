//Given a sequence of numbers, find the largest sum of pairs in the sequence.
//For example
//[10, 14, 2, 23, 19] --> 42 (= 23 + 19)
//[99, 2, 2, 23, 19] --> 122 (= 99 + 23)
//The input sequence contains at least two elements, and each element is an integer.

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(largestPairSum(new int[]{10, 14, 2, 23, 19})); //42
        System.out.println(largestPairSum(new int[]{-100, -29, -24, -19, 19})); //0
        System.out.println(largestPairSum(new int[]{1, 2, 3, 4, 6, -1, 2})); //10
        System.out.println(largestPairSum(new int[]{-10, -8, -16, -18, -19})); //-18
    }

    public static int largestPairSum(int[] numbers) {
        Arrays.sort(numbers);

        return numbers[numbers.length - 2] + numbers[numbers.length - 1];
    }
}
