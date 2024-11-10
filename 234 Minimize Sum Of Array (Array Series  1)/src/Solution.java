//Given an array of integers , Find the minimum sum which is obtained from summing each Two integers product.
//Notes
//Array/list will contain positives only.
//Array/list will always have even size
//minSum({5,4,2,3}) ==> return (22)
//Explanation:
//The minimum sum obtained from summing each two integers product ,  5*2 + 3*4 = 22
//minSum({12,6,10,26,3,24}) ==> return (342)
//Explanation:
//The minimum sum obtained from summing each two integers product ,  26*3 + 24*6 + 12*10 = 342
//minSum({9,2,8,7,5,4,0,6}) ==> return (74)
//Explanation:
//The minimum sum obtained from summing each two integers product ,  9*0 + 8*2 +7*4 +6*5 = 74

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        System.out.println(minSum(new int[]{5, 4, 2, 3})); //22
        System.out.println(minSum(new int[]{12, 6, 10, 26, 3, 24})); //342
        System.out.println(minSum(new int[]{9, 2, 8, 7, 5, 4, 0, 6})); //74
        System.out.println("______________________________");

        System.out.println(minSum2(new int[]{5, 4, 2, 3})); //22
        System.out.println(minSum2(new int[]{12, 6, 10, 26, 3, 24})); //342
        System.out.println(minSum2(new int[]{9, 2, 8, 7, 5, 4, 0, 6})); //74
    }

    public static int minSum(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            sum += arr[i] * arr[arr.length - 1 - i];
        }
        return sum;
    }

    public static int minSum2(int[] arr) {
        Arrays.sort(arr);
        return IntStream.range(0, arr.length / 2)
                .map(i -> arr[i] * arr[arr.length - 1 - i])
                .sum();
    }
}
