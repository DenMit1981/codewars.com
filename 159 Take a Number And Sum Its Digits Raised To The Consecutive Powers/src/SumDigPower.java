//The number 89 is the first integer with more than one digit that satisfies the property partially represented in
//the name of this kata. What's the point of saying "Eureka"? Because the sum is the same.
//In fact: 89 = 8^1 + 9^2
//The next number that has this property is 135.
//Look at this property again: 135 = 1^1 + 3^2 + 5^3.
//We need a function to collect these numbers that can take two integers a, b, defining the range [a, b]
//(inclusive), and output a list of sorted numbers in the range that satisfy the property described above.
//Let's look at some cases (input -> output):
//1, 10 -> [1, 2, 3, 4, 5, 6, 7, 8, 9]
//1, 100 -> [1, 2, 3, 4, 5, 6, 7, 8, 9, 89]
//If there are no such numbers in the range [a, b], the function should output an empty list.
//90, 100 --> []

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class SumDigPower {

    public static void main(String[] args) {
        System.out.println(isValid(89)); //true
        System.out.println(isValid(100)); //false

        System.out.println(sumDigPow(1, 100)); //[1, 2, 3, 4, 5, 6, 7, 8, 9, 89]
        System.out.println(sumDigPow(50, 150)); //[89, 135]

        System.out.println(sumDigPow2(1, 100)); //[1, 2, 3, 4, 5, 6, 7, 8, 9, 89]
        System.out.println(sumDigPow2(50, 150)); //[89, 135]
    }

    public static List<Long> sumDigPow(long a, long b) {
        return LongStream.rangeClosed(a, b)
                .filter(SumDigPower::isValid)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isValid(long x) {
        String value = Long.toString(x);

        return IntStream.range(0, value.length())
                .mapToDouble(i -> Math.pow(Character
                        .getNumericValue(value.charAt(i)), i + 1))
                .sum() == x;
    }

    public static List<Long> sumDigPow2(long a, long b) {
        List<Long> result = new ArrayList<>();

        for (long i = a; i <= b; i++) {
            long number = 0;
            int degree = 1;

            char[] digitsToCharArr = String.valueOf(i).toCharArray();

            for (char digitChar : digitsToCharArr) {
                number += Math.pow(digitChar - '0', degree++);

                if (number > i) {
                    break;
                }
            }

            if (number == i) {
                result.add(i);
            }
        }

        return result;
    }

    public static List<Long> sumDigPow3(long a, long b) {
        List<Long> ret = new ArrayList<>();

        for (long k = a; k <= b; k++) {
            long v = 0;
            int exp = 1;

            for (char c : ("" + k).toCharArray()) { //переводим в String с помощью "" + k
                v += Math.pow(c - '0', exp++); //переводим char в int c помощью char - '0' ('0' == 48)

                if (v > k) break;
            }
            if (v == k) ret.add(k);
        }
        return ret;
    }
}



