//The term "smooth number" applies to all those numbers whose prime factors are less than or equal to 7:
//60 is a smooth number (2 * 2 * 3 * 5), 111 is not (3 * 37).
//
//More specifically, smooth numbers are classified by their highest prime factor, and you need to write a function
//isSmooth/is_smooth that returns a string with this classification, as follows:
//2-smooth numbers should be defined as "powers of 2", since that's just what they are;
//3-smooth numbers return the result "3-smooth";
//5-smooth numbers will be labeled as "Hamming numbers" (by the way, you may appreciate this beautiful kata on them);
//7-smooth numbers are classified as "modest numbers";
//for all other numbers, just return non-smooth.
//Examples:
//isSmooth(16) == "power of 2"
//isSmooth(36) == "3-smooth"
//isSmooth(60) == "Hamming number"
//isSmooth(98) == "humble number"
//isSmooth(111) == "non-smooth"
//The provided input n will always be a positive number > 1.

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private static final Map<Boolean, String> IS_SMOOTH_MAP = new HashMap<>();
    private static final Set<Map.Entry<Boolean, String>> IS_SMOOTH_SET = IS_SMOOTH_MAP.entrySet();

    public static void main(String[] args) {
        System.out.println(isSmooth(16)); //"power of 2"
        System.out.println(isSmooth(36)); //"3-smooth"
        System.out.println(isSmooth(60)); //"Hamming number"
        System.out.println(isSmooth(98)); //"humble number"
        System.out.println(isSmooth(111)); //"non-smooth"
        System.out.println(isSmooth(4096)); //"power of 2"
        System.out.println(isSmooth(729)); //"3-smooth"
        System.out.println(isSmooth(3125)); //"Hamming number"
        System.out.println(isSmooth(7)); //"humble number"
        System.out.println(isSmooth(17)); //"non-smooth"
    }

    public static String isSmooth(long number) {
        long factor = maxFactor(getAllSimpleFactors(number));

        IS_SMOOTH_MAP.put(factor == 2, "power of 2");
        IS_SMOOTH_MAP.put(factor == 3, "3-smooth");
        IS_SMOOTH_MAP.put(factor == 5, "Hamming number");
        IS_SMOOTH_MAP.put(factor == 7, "humble number");
        IS_SMOOTH_MAP.put(factor > 7, "non-smooth");

        return IS_SMOOTH_SET.stream()
                .filter(pair -> pair.getKey().equals(true))
                .map(Map.Entry::getValue)
                .collect(Collectors.joining());
    }

    private static long[] getAllSimpleFactors(long number) {
        List<Long> nums = new ArrayList<>();

        for (int i = 2; i < number; i++) {
            while (number % i == 0) {
                nums.add((long) i);
                number = number / i;
            }
        }
        if (number > 2) {
            nums.add(number);
        }

        long[] res = new long[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            res[i] = nums.get(i);
        }

        return res;
    }

    private static long[] getAllSimpleFactors2(long number) {
        List<Long> nums = new ArrayList<>();
        long divider = 2;

        while (divider <= Math.sqrt(number)) {
            if (number % divider == 0) {
                nums.add(divider);
                number /= divider;
            } else {
                divider++;
            }
        }

        if (number > 1) {
            nums.add(number);
        }

        long[] res = new long[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            res[i] = nums.get(i);
        }

        return res;
    }

    private static long maxFactor(long[] factorsArr) {
        return Arrays.stream(factorsArr).max().getAsLong();
    }
}
