//Create a function that returns the sum of the two lowest positive numbers given an array of minimum 4 positive
//integers. No floats or non-positive integers will be passed.
//For Java, those integers will come as double precision (long).
//For example, when an array is passed like [19, 5, 42, 2, 77], the output should be 7.
//[10, 343445353, 3453445, 3453545353453] should return 3453455.

import java.util.Arrays;

public class Kata {

    public static void main(String[] args) {
        System.out.println(sumTwoSmallestNumbers(new long[]{19, 5, 42, 2, 77})); //7
        System.out.println(sumTwoSmallestNumbers(new long[]{10, 343445353, 3453445, 3453545353453L})); //3453455
        System.out.println(sumTwoSmallestNumbers(new long[]{5, 8, 12, 19, 22})); //13
        System.out.println(sumTwoSmallestNumbers(new long[]{15, 28, 4, 2, 43})); //6
        System.out.println(sumTwoSmallestNumbers(new long[]{3, 87, 3, 12, 7})); //6
        System.out.println(sumTwoSmallestNumbers(new long[]{23, 71, 33, 82, 1})); //24
        System.out.println(sumTwoSmallestNumbers(new long[]{52, 76, 14, 12, 4})); //16
        System.out.println("_____________________________________________");

        System.out.println(sumTwoSmallestNumbers2(new long[]{19, 5, 42, 2, 77})); //7
        System.out.println(sumTwoSmallestNumbers2(new long[]{10, 343445353, 3453445, 3453545353453L})); //3453455
        System.out.println(sumTwoSmallestNumbers2(new long[]{5, 8, 12, 19, 22})); //13
        System.out.println(sumTwoSmallestNumbers2(new long[]{15, 28, 4, 2, 43})); //6
        System.out.println(sumTwoSmallestNumbers2(new long[]{3, 87, 3, 12, 7})); //6
        System.out.println(sumTwoSmallestNumbers2(new long[]{23, 71, 33, 82, 1})); //24
        System.out.println(sumTwoSmallestNumbers2(new long[]{52, 76, 14, 12, 4})); //16
    }

    public static long sumTwoSmallestNumbers(long[] numbers) {
        return Arrays.stream(numbers).sorted().limit(2).sum();
    }

    public static long sumTwoSmallestNumbers2(long[] numbers) {
        long min1 = Long.MAX_VALUE;
        long min2 = 0;

        for (long number : numbers) {
            if (number <= min1) {
                min2 = min1;
                min1 = number;
            }
            if ((number > min1) && (number <= min2)) {
                min2 = number;
            }
        }

        return min1 + min2;
    }
}
