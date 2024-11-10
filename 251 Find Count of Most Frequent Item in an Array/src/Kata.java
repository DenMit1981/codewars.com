//Complete the function to find the count of the most frequent item of an array. You can assume that input is an
//array of integers. For an empty array return 0
//Example
//input array: [3, -1, -1, -1, 2, 3, -1, 3, -1, 2, 4, 9, 3]
//ouptut: 5
//The most frequent number in the array is -1 and it occurs 5 times.

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Kata {
    public static void main(String[] args) {
        System.out.println(mostFrequentItemCount(new int[]{3, -1, -1})); //2
        System.out.println(mostFrequentItemCount(new int[]{3, -1, -1, -1, 2, 3, -1, 3, -1, 2, 4, 9, 3})); //5
        System.out.println("_______________________");

        System.out.println(mostFrequentItemCount2(new int[]{3, -1, -1})); //2
        System.out.println(mostFrequentItemCount2(new int[]{3, -1, -1, -1, 2, 3, -1, 3, -1, 2, 4, 9, 3})); //5
    }

    public static int mostFrequentItemCount(int[] collection) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int number : collection) {
            counter.put(number, counter.getOrDefault(number, 0) + 1);
        }

        int max = 0;

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        return max;
    }

    public static int mostFrequentItemCount2(int[] collection) {
        return Arrays.stream(collection)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().stream()
                .max(Comparator.naturalOrder())
                .orElse(0L)
                .intValue();
    }
}
