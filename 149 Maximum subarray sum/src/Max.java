//The subarray max sum problem is to find the maximum sum of a contiguous subsequence
//in an array or list of integers:
//Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
//must be 6: {4, -1, 2, 1}
//The simple case is when the list consists only of positive numbers,
//and the maximum sum is the sum of the entire array.
//If the list consists only of negative numbers, return 0 instead.
//The empty list is considered to have a zero largest sum. Note that
//the empty list or array is also a valid sublist/subarray.

import java.util.Arrays;

public class Max {
    public static void main(String[] args) {
        System.out.println(sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); //6
        System.out.println(sequence(new int[]{})); //0
        System.out.println(sequence(new int[]{-2, -1, -3, -4, -1, -2, -1, -5, -4})); //0
        System.out.println("______________________");

        System.out.println(sequence2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); //6
        System.out.println(sequence2(new int[]{})); //0
        System.out.println(sequence2(new int[]{-2, -1, -3, -4, -1, -2, -1, -5, -4})); //0
    }

    public static int sequence(int[] arr) {
        if (arr.length < 1 || isArrHasOnlyNegativeNumbers(arr)) {
            return 0;
        }

        int maximumSubArraySum = Integer.MIN_VALUE;

        for (int left = 0; left < arr.length; left++) {
            int runningWindowSum = 0;

            for (int right = left; right < arr.length; right++) {
                runningWindowSum += arr[right];

                if (runningWindowSum > maximumSubArraySum) {
                    maximumSubArraySum = runningWindowSum;
                }
            }
        }
        return maximumSubArraySum;
    }

    public static int sequence2(int[] arr) {
        if (arr.length < 1 || isArrHasOnlyNegativeNumbers(arr)) {
            return 0;
        }

        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
        }
        return maxSoFar;
    }

    private static boolean isArrHasOnlyNegativeNumbers(int[] arr) {
        return Arrays.stream(arr).allMatch(n -> n < 0);
    }
}
