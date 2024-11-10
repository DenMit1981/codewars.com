//Given a two-dimensional array of integers, return a flattened version of the array with all the integers in sorted
//(ascending) order.
//Example:
//Given [[3, 2, 1], [4, 6, 5], [], [9, 7, 8]], your function should return [1, 2, 3, 4, 5, 6, 7, 8 , 9].

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kata {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(flattenAndSort(new int[][]{{3, 2, 1}, {7, 9, 8}, {6, 4, 5}}))); //[1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(Arrays.toString(flattenAndSort(new int[][]{{1, 3, 5}, {100}, {2, 4, 6}}))); //[1, 2, 3, 4, 5, 6, 100]
        System.out.println(Arrays.toString(flattenAndSort(new int[][]{{111, 999}, {222}}))); //[111, 222, 999]
        System.out.println(Arrays.toString(flattenAndSort(new int[][]{{}, {1}}))); //[1]
        System.out.println(Arrays.toString(flattenAndSort(new int[][]{}))); //[]
        System.out.println(Arrays.toString(flattenAndSort(new int[][]{{3, 2, 1}, {4, 6, 5}, {}, {9, 7, 8}}))); //[1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println("_________________________________");

        System.out.println(Arrays.toString(flattenAndSort2(new Integer[][]{{3, 2, 1}, {7, 9, 8}, {6, 4, 5}}))); //[1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(Arrays.toString(flattenAndSort2(new Integer[][]{{1, 3, 5}, {100}, {2, 4, 6}}))); //[1, 2, 3, 4, 5, 6, 100]
        System.out.println(Arrays.toString(flattenAndSort2(new Integer[][]{{111, 999}, {222}}))); //[111, 222, 999]
        System.out.println(Arrays.toString(flattenAndSort2(new Integer[][]{{}, {1}}))); //[1]
        System.out.println(Arrays.toString(flattenAndSort2(new Integer[][]{}))); //[]
        System.out.println(Arrays.toString(flattenAndSort2(new Integer[][]{{3, 2, 1}, {4, 6, 5}, {}, {9, 7, 8}}))); //[1, 2, 3, 4, 5, 6, 7, 8, 9]
    }

    public static int[] flattenAndSort(int[][] array) {
        return Arrays.stream(array).flatMapToInt(Arrays::stream).sorted().toArray();
    }

    public static <T> T[] flattenAndSort2(T[][] array) {
        final List<T> result = new ArrayList<>();
        for (T[] el : array) {
            result.addAll(Arrays.asList(el));
        }
        return (T[]) result.stream().sorted().toArray();
    }
}
