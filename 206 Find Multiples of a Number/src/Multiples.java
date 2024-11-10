//In this simple exercise, you will create a program that takes an integer and returns a list of its multiples up to
//another limit value. If the limit is a multiple of an integer, it should also be included.
//Only positive integers that do not consist of 0 will be passed to the function.
//The limit will always be higher than the base.
//For example, if the parameters passed are (2, 6), the function should return [2, 4, 6], since 2, 4, and 6 are
//multiples of 2 through 6.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Multiples {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(find(2, 6))); //[2, 4, 6]
        System.out.println(Arrays.toString(find(1, 2))); //[1, 2]
        System.out.println(Arrays.toString(find(5, 7))); //[5]
        System.out.println(Arrays.toString(find(4, 27))); //[4, 8, 12, 16, 20, 24]
        System.out.println(Arrays.toString(find(11, 54))); //[11, 22, 33, 44]
        System.out.println(Arrays.toString(find(5, 25))); //[5, 10, 15, 20, 25]
        System.out.println("_____________________");

        System.out.println(Arrays.toString(find2(2, 6))); //[2, 4, 6]
        System.out.println(Arrays.toString(find2(1, 2))); //[1, 2]
        System.out.println(Arrays.toString(find2(5, 7))); //[5]
        System.out.println(Arrays.toString(find2(4, 27))); //[4, 8, 12, 16, 20, 24]
        System.out.println(Arrays.toString(find2(11, 54))); //[11, 22, 33, 44]
        System.out.println(Arrays.toString(find2(5, 25))); //[5, 10, 15, 20, 25]
    }

    public static int[] find(int base, int limit) {
        List<Integer> result = new ArrayList<>();
        for (int i = base; i <= limit; i++) {
            if (i % base == 0) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] find2(int base, int limit) {
        return IntStream.range(base, limit + 1).filter(i -> i % base == 0).toArray();
    }
}

