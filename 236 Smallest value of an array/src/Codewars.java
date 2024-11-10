//Write a function that can return the smallest value of an array or the index of that value.
//The function's 2nd parameter will tell whether it should return the value or the index.
//Assume the first parameter will always be an array filled with at least 1 number and no duplicates.
//Assume the second parameter will be a string holding one of two values: 'value' and 'index'.
//Some examples:
//([1,2,3,4,5], "value") should return 1
//([1,2,3,4,5], "index") should return 0

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Codewars {
    public static void main(String[] args) {
        System.out.println(findSmallest(new int[]{1, 2, 3, 4, 5}, "value")); //1
        System.out.println(findSmallest(new int[]{1, 2, 3, 4, 5}, "index")); //0
        System.out.println(findSmallest(new int[]{5, 4, 3, 2, 1}, "value")); //1
        System.out.println(findSmallest(new int[]{5, 4, 3, 2, 1}, "index")); //4
        System.out.println(findSmallest(new int[]{Integer.MAX_VALUE}, "value")); //2147483647
        System.out.println(findSmallest(new int[]{0, Integer.MIN_VALUE}, "value")); //-2147483648
        System.out.println("______________________________");

        System.out.println(findSmallest2(new int[]{1, 2, 3, 4, 5}, "value")); //1
        System.out.println(findSmallest2(new int[]{1, 2, 3, 4, 5}, "index")); //0
        System.out.println(findSmallest2(new int[]{5, 4, 3, 2, 1}, "value")); //1
        System.out.println(findSmallest2(new int[]{5, 4, 3, 2, 1}, "index")); //4
        System.out.println(findSmallest2(new int[]{Integer.MAX_VALUE}, "value")); //2147483647
        System.out.println(findSmallest2(new int[]{0, Integer.MIN_VALUE}, "value")); //-2147483648
    }

    public static int findSmallest(int[] numbers, String mode) {
        return mode.equals("value") ? Arrays.stream(numbers).min().getAsInt() :
                IntStream.range(0, numbers.length).boxed().min(Comparator.comparingInt(i -> numbers[i])).get();
    }

    public static int findSmallest2(int[] arr, String mode) {
        int minIndex = IntStream.range(0, arr.length)
                .reduce(0, (i, j) -> arr[i] < arr[j] ? i : j);

        return mode.equals("value") ? arr[minIndex] : minIndex;
    }
}

