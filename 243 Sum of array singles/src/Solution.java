//In this Kata, you will be given an array of numbers in which two numbers occur once and the rest occur only twice.
//Your task will be to return the sum of the numbers that occur only once.
//For example, repeats([4,5,7,5,4,8]) = 15 because only the numbers 7 and 8 occur once, and their sum is 15.
//Every other number occurs twice.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(repeats(new int[]{4, 5, 7, 5, 4, 8})); //15
        System.out.println(repeats(new int[]{9, 10, 19, 13, 19, 13})); //19
        System.out.println(repeats(new int[]{16, 0, 11, 4, 8, 16, 0, 11})); //12
        System.out.println("___________________________");

        System.out.println(repeats2(new int[]{4, 5, 7, 5, 4, 8})); //15
        System.out.println(repeats2(new int[]{9, 10, 19, 13, 19, 13})); //19
        System.out.println(repeats2(new int[]{16, 0, 11, 4, 8, 16, 0, 11})); //12
    }

    public static int repeats(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                sum += entry.getKey();
            }
        }
        return sum;
    }

    public static int repeats2(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .mapToInt(Map.Entry::getKey)
                .sum();
    }
}

