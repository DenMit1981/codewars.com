//Create a function with two arguments that returns an array of the first n multiples of x.
//Assume that both the given number and the count are positive numbers greater than 0.
//Return the results as an array or list (depending on the language).
//Examples
//countBy(1,10) // should return {1,2,3,4,5,6,7,8,9,10}
//countBy(2,5) // should return {2,4,6,8,10}

import java.util.Arrays;
import java.util.stream.IntStream;

public class CountByX {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBy(1, 10))); //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        System.out.println(Arrays.toString(countBy(2, 5))); //[2, 4, 6, 8, 10]
        System.out.println(Arrays.toString(countBy(3, 7))); //[3, 6, 9, 12, 15, 18, 21]
        System.out.println("__________________");

        System.out.println(Arrays.toString(countByStreamApi(1, 10))); //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        System.out.println(Arrays.toString(countByStreamApi(2, 5))); //[2, 4, 6, 8, 10]
        System.out.println(Arrays.toString(countByStreamApi(3, 7))); //[3, 6, 9, 12, 15, 18, 21]
    }

    public static int[] countBy(int x, int n) {
        int[] result = new int[n];

        for (int i = 0; i < result.length; i++) {
            result[i] = (i + 1) * x;
        }

        return result;
    }

    public static int[] countByStreamApi(int x, int n) {
        return IntStream.range(0, n)
                .map(i -> (i + 1) * x)
                .toArray();
    }
}
