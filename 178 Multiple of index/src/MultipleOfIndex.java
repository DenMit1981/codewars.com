//Returns a new array consisting of elements that are multiples of their own index in the input array (length > 1).

import java.util.Arrays;
import java.util.stream.IntStream;

public class MultipleOfIndex {
    public static void main(String[] args) {
        int[] arr1 = {22, -6, 32, 82, 9, 25};
        int[] arr2 = {68, -1, 1, -7, 10, 10};
        int[] arr3 = {-56, -85, 72, -26, -14, 76, -27, 72, 35, -21, -67, 87, 0, 21, 59, 27, -92, 68};
        int[] arr4 = {28, 38, -44, -99, -13, -54, 77, -51};
        int[] arr5 = {-1, -49, -1, 67, 8, -60, 39, 35};
        int[] arr6 = {0, 2, 3, 6, 9};

        System.out.println(Arrays.toString(multipleOfIndex(arr1))); // [-6, 32, 25]
        System.out.println(Arrays.toString(multipleOfIndex(arr2))); // [-1, 10]
        System.out.println(Arrays.toString(multipleOfIndex(arr3))); // [-85, 72, 0, 68]
        System.out.println(Arrays.toString(multipleOfIndex(arr4))); // [38, -44, -99]
        System.out.println(Arrays.toString(multipleOfIndex(arr5))); // [-49, 8, -60, 35]
        System.out.println(Arrays.toString(multipleOfIndex(arr6))); // [0, 2, 6]
    }

    public static int[] multipleOfIndex(int[] array) {
        return IntStream.range(0, array.length)
                .filter(i -> ifElementMultipleOfIndex(array[i], i))
                .map(i -> array[i])
                .toArray();
    }

    private static boolean ifElementMultipleOfIndex(int number, int index) {
        if (number != 0) {
            if (index != 0) {
                return number % index == 0;
            }
            return false;
        }
        return true;
    }
}
