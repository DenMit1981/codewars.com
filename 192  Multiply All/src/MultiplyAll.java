//To complete this Kata, you need to create a function multiplyAll that takes an array of integers as an
//argument. This function must return another function that takes a single integer as an
//argument and returns a new array.
//The returned array must consist of each element from the first array multiplied by an integer.
//Example:
//multiplyAll([1, 2, 3])(2) = [2, 4, 6];
//You must not modify the original array

import java.util.Arrays;
import java.util.function.Function;

public class MultiplyAll {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(multiplyAll(new int[]{1, 2, 3}, 2)));
        System.out.println(Arrays.toString(multiplyAll(new int[]{1, 2, 3}, 1)));
        System.out.println(Arrays.toString(multiplyAll(new int[]{1}, 1)));
        System.out.println(Arrays.toString(multiplyAll(new int[]{1, 2}, 1)));
        System.out.println(Arrays.toString(multiplyAll(new int[]{1, 2, 3}, 0)));
        System.out.println(Arrays.toString(multiplyAll(new int[]{0}, 10)));
    }

    public static int[] multiplyAll(int[] array, int apply) {
        return Arrays.stream(array).map(i -> i * apply).toArray();
    }

    public static Function<Integer, int[]> multiplyAll(int[] array) {
        return factor -> Arrays.stream(array).map(i -> i * factor).toArray();
    }
}
