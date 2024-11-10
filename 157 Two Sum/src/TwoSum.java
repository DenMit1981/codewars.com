//Write a function that takes an array of numbers (integers for tests) and a target number.
//It should find two distinct elements in the array that, when added together, yield the target value.
//The indices of these elements should then be returned as a tuple/list (depending on your language) as follows:
//(index1, index2).
//For the purposes of this kata, some tests may have multiple answers; any valid answers will be accepted.
//The input will always be valid (the numbers will be an array of length 2 or greater, and all elements will be numbers,
//the target will always be the sum of two distinct elements from that array).
//
//two_sum([1, 2, 3], 4) == {0, 2}

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3}, 4))); //[0, 2]
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 1}, 4))); //[1, 2]
        System.out.println(Arrays.toString(twoSum(new int[]{1234, 5678, 9012}, 14690))); //[1, 2]
        System.out.println(Arrays.toString(twoSum(new int[]{2, 2, 3}, 4))); //[0, 1]
    }

    public static int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];

                if (sum == target) {
                    index1 = i;
                    index2 = j;
                    break;
                }
            }
        }

        return new int[]{index1, index2};
    }
}
