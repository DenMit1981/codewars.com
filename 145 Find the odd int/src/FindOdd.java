//Given an array of integers, find the one that occurs an odd number of times.
//There will always be exactly one integer that occurs an odd number of times.
//Examples
//[7] should return 7 because it occurs 1 time (which is odd).
//[0] should return 0 because it occurs 1 time (which is odd).
//[1,1,2] should return 2 because it occurs 1 time (which is odd).
//[0,1,0,1,0] should return 0 because it occurs 3 times (which is odd).
//[1,2,2,3,3,3,4,3,3,3,2,2,1] should return 4 because it occurs 1 time (which is odd).

import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class FindOdd {
    public static void main(String[] args) {
        System.out.println(findIt(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5})); //5
        System.out.println(findIt(new int[]{1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5})); //-1
        System.out.println(findIt(new int[]{20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5})); //5
        System.out.println(findIt(new int[]{10})); //10
        System.out.println(findIt(new int[]{1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1})); //10
        System.out.println(findIt(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10})); //1
        System.out.println("____________________");

        System.out.println(findIt2(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5})); //5
        System.out.println(findIt2(new int[]{1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5})); //-1
        System.out.println(findIt2(new int[]{20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5})); //5
        System.out.println(findIt2(new int[]{10})); //10
        System.out.println(findIt2(new int[]{1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1})); //10
        System.out.println(findIt2(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10})); //1
        System.out.println("____________________");

        System.out.println(findIt3(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5})); //5
        System.out.println(findIt3(new int[]{1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5})); //-1
        System.out.println(findIt3(new int[]{20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5})); //5
        System.out.println(findIt3(new int[]{10})); //10
        System.out.println(findIt3(new int[]{1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1})); //10
        System.out.println(findIt3(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10})); //1
        System.out.println("____________________");

        System.out.println(findIt4(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5})); //5
        System.out.println(findIt4(new int[]{1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5})); //-1
        System.out.println(findIt4(new int[]{20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5})); //5
        System.out.println(findIt4(new int[]{10})); //10
        System.out.println(findIt4(new int[]{1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1})); //10
        System.out.println(findIt4(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10})); //1
    }

    public static int findIt(int[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int el : arr) {
            sb.append(el).append(" ");
        }

        Map<String, Long> numbersCount = Stream.of(sb.toString().split(" "))
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));

        return Integer.parseInt(numbersCount.entrySet().stream().filter(p -> p.getValue() % 2 != 0)
                .map(Map.Entry::getKey).collect(Collectors.joining()));
    }

    public static int findIt2(int[] arr) {
        return stream(arr).reduce(0, (x, y) -> x ^ y);
    }

    public static int findIt3(int[] arr) {
        int odd = 0;

        for (int el : arr) {
            odd ^= el;
        }

        return odd;
    }

    public static int findIt4(int[] arr) {
        final TreeSet<Integer> set = new TreeSet<>();
        for (int el : arr) {
            if (set.contains(el)) {
                set.remove(el);
            } else {
                set.add(el);
            }
        }
        return set.first();
    }
}




