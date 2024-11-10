//Your task is to create a function that can take any non-negative integer as an argument and return it with the digits
//in descending order. Basically, rearrange the digits to get the largest possible number.
//Examples:
//Input: 42145 Output: 54421
//Input: 145263 Output: 654321
//Input: 123456789 Output: 987654321

import java.util.*;
import java.util.stream.Collectors;

public class DescendingOrder {
    public static void main(String[] args) {
        System.out.println(sortDesc(15)); //51
        System.out.println(sortDesc(123456789)); //987654321
        System.out.println(sortDesc(0)); //0
    }

    public static int sortDesc(final int num) {
        return Integer.parseInt(Arrays.stream(String.valueOf(num).split(""))
                .sorted(Collections.reverseOrder())
                .collect(Collectors.joining()));
    }
}
