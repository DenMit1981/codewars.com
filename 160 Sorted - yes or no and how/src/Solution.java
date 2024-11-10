//Complete a method that takes an array of integers and returns one of the following values:
//"yes, ascending" - if the numbers in the array are sorted in an ascending order
//"yes, descending" - if the numbers in the array are sorted in a descending order
//"no" - otherwise

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        System.out.println(isSortedAndHow(new int[]{15, 7, 3, -8})); //yes, descending
        System.out.println(isSortedAndHow(new int[]{4, 2, 30})); //no
        System.out.println(isSortedAndHow(new int[]{1, 2, 3})); //yes, ascending

        System.out.println(isSortedAndHow2(new int[]{15, 7, 3, -8})); //yes, descending
        System.out.println(isSortedAndHow2(new int[]{4, 2, 30})); //no
        System.out.println(isSortedAndHow2(new int[]{1, 2, 3})); //yes, ascending
    }

    public static String isSortedAndHow(int[] array) {
        int[] ascendingSortedArr = Arrays.stream(array)
                .sorted()
                .toArray();

        int[] descendingSortedArr = IntStream.of(ascendingSortedArr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(i -> i)
                .toArray();

        if (Arrays.equals(array, ascendingSortedArr)) {
            return "yes, ascending";
        }

        return Arrays.equals(array, descendingSortedArr) ? "yes, descending" : "no";
    }

    public static String isSortedAndHow2(int[] array) {

        if (isAscendingSorted(array)) {
            return "yes, ascending";
        }

        return isDescendingSorted(array) ? "yes, descending" : "no";
    }

    private static boolean isAscendingSorted(int[] array) {
        return IntStream.range(0, array.length - 1).allMatch(i -> array[i] <= array[i + 1]);
    }

    private static boolean isDescendingSorted(int[] array) {
        return IntStream.range(0, array.length - 1).allMatch(i -> array[i] >= array[i + 1]);
    }
}
