//Your goal in this kata is to implement a difference function that subtracts one list from another and returns the result.
//It should remove all values from list a that are present in list b, preserving their order.
//Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}
//If a value is present in b, all occurrences of it should be removed from the other:
//Kata.arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2}) => new int[] {1, 3}

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        int[] a = {1, 2, 2};
        int[] b = {1};
        System.out.println(Arrays.toString(arrayDiff(a, b))); //[2, 2]
        System.out.println(Arrays.toString(arrayDiff1(a, b))); //[2, 2]
        System.out.println(Arrays.toString(arrayDiff2(a, b))); //[2, 2]
        System.out.println(Arrays.toString(arrayDiff3(a, b))); //[2, 2]
    }

    public static int[] arrayDiff(int[] a, int[] b) {
        List<Integer> list = Arrays.stream(b).boxed().collect(Collectors.toList());
        return Arrays.stream(a).filter(num -> !list.contains(num)).toArray();
    }

    public static int[] arrayDiff1(int[] a, int[] b) {
        return Arrays.stream(a)
                .filter(o -> Arrays.stream(b).noneMatch(bb -> o == bb))
                .toArray();
    }

    public static int[] arrayDiff2(int[] a, int[] b) {
        List<Integer> listA = Arrays.stream(a).boxed().collect(Collectors.toList());
        List<Integer> listB = Arrays.stream(b).boxed().collect(Collectors.toList());
        listA.removeAll(listB);
        return listA.stream().mapToInt(i -> i).toArray();
    }

    public static int[] arrayDiff3(int[] a, int[] b) {
        List<Integer> list1 = IntStream.of(a).boxed().collect(Collectors.toList());
        List<Integer> list2 = IntStream.of(b).boxed().collect(Collectors.toList());
        List<Integer> diff = list1.stream()
                .filter(e -> !list2.contains(e))
                .collect(Collectors.toList());
        Integer[] result = new Integer[diff.size()];
        result = diff.toArray(result);
        return Stream.of(result).mapToInt(x -> x).toArray();
    }
}
