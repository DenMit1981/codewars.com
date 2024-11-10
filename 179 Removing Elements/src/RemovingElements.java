//Take an array and remove every second element from the array. Always keep the first element and start removing from
//the next element. None of the arrays will be empty

import java.util.Arrays;
import java.util.stream.IntStream;

public class RemovingElements {
    public static void main(String[] args) {
        Object[] arr1 = {"Hello", "Goodbye", "Hello Again"};
        Object[] arr2 = {1, 2};
        Object[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Object[] arr4 = {"Goodbye"};
        Object[] arr5 = {};

        System.out.println(Arrays.toString(removeEveryOther(arr1))); //["Hello", "Hello Again"]
        System.out.println(Arrays.toString(removeEveryOther(arr2))); //[1]
        System.out.println(Arrays.toString(removeEveryOther(arr3))); //[1, 3, 5, 7, 9]
        System.out.println(Arrays.toString(removeEveryOther(arr4))); //["Goodbye"]
        System.out.println(Arrays.toString(removeEveryOther(arr5))); //[]
    }

    public static Object[] removeEveryOther(Object[] arr) {
        return IntStream.range(0, arr.length)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> arr[i]).toArray();
    }
}
