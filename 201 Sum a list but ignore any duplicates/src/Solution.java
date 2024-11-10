//Write a function that sums a list, but ignores any duplicate elements in the list.
//For example, for the list [3, 4, 3, 6], the function should return 10.

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDuplicate(new int[]{1, 1, 2, 3}, 2)); //false
        System.out.println(isDuplicate(new int[]{3, 4, 3, 6}, 3)); //true

        System.out.println(sumNoDuplicates(new int[]{1, 1, 2, 3})); //5
        System.out.println(sumNoDuplicates(new int[]{3, 4, 3, 6})); //10
        System.out.println(sumNoDuplicates(new int[]{1, 1, 2, 2, 3})); //3
        System.out.println(sumNoDuplicates(new int[]{1})); //1
        System.out.println(sumNoDuplicates(new int[]{})); //0
    }

    public static int sumNoDuplicates(int[] arr) {
        return Arrays.stream(arr).filter(n -> !isDuplicate(arr, n)).sum();
    }

    private static boolean isDuplicate(int[] arr, int element) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (i != j && arr[i] == element && arr[j] == element) {
                    count++;
                }
            }
        }
        return count > 0;
    }
}
