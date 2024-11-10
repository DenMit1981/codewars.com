//You will be given an array of numbers.
//You must sort the odd numbers in ascending order, leaving the even numbers in their original positions.

import java.util.Arrays;
import java.util.stream.IntStream;

public class Kata {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{5, 3, 2, 8, 1, 4}))); //[1, 3, 2, 8, 5, 4]
        System.out.println(Arrays.toString(sortArray(new int[]{5, 3, 1, 8, 0}))); //[1, 3, 5, 8, 0]
        System.out.println(Arrays.toString(sortArray(new int[]{}))); //[]
        System.out.println(Arrays.toString(sortArray(new int[]{7, 1}))); //[1, 7]

        System.out.println(Arrays.toString(sortArray2(new int[]{5, 3, 2, 8, 1, 4}))); //[1, 3, 2, 8, 5, 4]
        System.out.println(Arrays.toString(sortArray2(new int[]{5, 3, 1, 8, 0}))); //[1, 3, 5, 8, 0]
        System.out.println(Arrays.toString(sortArray2(new int[]{}))); //[]
        System.out.println(Arrays.toString(sortArray2(new int[]{7, 1}))); //[1, 7]
    }

    public static int[] sortArray(int[] array) {
        int[] sortedArray = new int[array.length];
        System.arraycopy(array, 0, sortedArray, 0, array.length);

        for (int i = 0; i < sortedArray.length - 1; i++) {
            if (sortedArray[i] % 2 != 0) {
                for (int j = i + 1; j < sortedArray.length; j++) {
                    if ((sortedArray[j] % 2 != 0) && (sortedArray[i] > sortedArray[j])) {
                        swap(sortedArray, i, j);
                    }
                }
            }
        }
        return sortedArray;
    }

    public static int[] sortArray2(int[] src) {
        int[] filtered = IntStream.of(src).filter(n -> n % 2 != 0).sorted().toArray();
        int[] dst = new int[src.length];
        for (int i = 0, j = 0; i < src.length; i++) {
            dst[i] = src[i] % 2 != 0 ? filtered[j++] : src[i];
        }
        return dst;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
