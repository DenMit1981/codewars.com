//Given an array of integers, find the maximum product obtained by multiplying two adjacent numbers in the array.
//Notes
//The array/list size must be at least 2.
//The numbers in the array/list can be positive, negative, or zero.
//Input >> Output Examples
//adjacentElementsProduct([1, 2, 3]); ==> return 6
//Explanation:
//The maximum product obtained from multiplying 2 * 3 = 6, and they're adjacent numbers in the array.
//adjacentElementsProduct([9, 5, 10, 2, 24, -1, -48]); ==> return 50
//Explanation:
//Max product obtained from multiplying 5 * 10 = 50 .
//
//adjacentElementsProduct([-23, 4, -5, 99, -27, 329, -2, 7, -921]) ==> return -14 Explanation: The maximum product
//obtained from multiplying -2 * 7 = -14, and they're adjacent numbers in the array.

import java.util.stream.IntStream;

public class MaxProduct {
    public static void main(String[] args) {
        System.out.println(adjacentElementsProduct(new int[]{5, 8})); //40
        System.out.println(adjacentElementsProduct(new int[]{1, 2, 3})); //6
        System.out.println(adjacentElementsProduct(new int[]{1, 5, 10, 9})); //90
        System.out.println(adjacentElementsProduct(new int[]{3, 6, -2, -5, 7, 3})); //21
        System.out.println(adjacentElementsProduct(new int[]{1, 0, 1, 0, 1000})); //0
        System.out.println(adjacentElementsProduct(new int[]{-23, 4, -5, 99, -27, 329, -2, 7, -921})); //-14
        System.out.println("_______________________");

        System.out.println(adjacentElementsProductByStream(new int[]{5, 8})); //40
        System.out.println(adjacentElementsProductByStream(new int[]{1, 2, 3})); //6
        System.out.println(adjacentElementsProductByStream(new int[]{1, 5, 10, 9})); //90
        System.out.println(adjacentElementsProductByStream(new int[]{3, 6, -2, -5, 7, 3})); //21
        System.out.println(adjacentElementsProductByStream(new int[]{1, 0, 1, 0, 1000})); //0
        System.out.println(adjacentElementsProductByStream(new int[]{-23, 4, -5, 99, -27, 329, -2, 7, -921})); //-14
    }

    public static int adjacentElementsProduct(int[] array) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length - 1; i++) {
            int mul = array[i] * array[i + 1];

            if (mul >= max) {
                max = mul;
            }
        }

        return max;
    }

    public static int adjacentElementsProductByStream(int[] array) {
        return IntStream.range(0, array.length - 1)
                .map(i -> array[i] * array[i + 1])
                .max()
                .getAsInt();
    }
}
