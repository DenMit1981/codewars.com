//For any positive integer x ≤ 4000, find the smallest positive integer m such that mx consists of all 9s.
//Return -1 if no such m exists.
//Examples:
//11 -> 9, because 11*9 == 99.
//12 -> -1, because 12 is even, so no multiple of 12 can contain only 9s.
//13 -> 76923, because 13 * 76923 == 999999 and no smaller positive integer when multiplied by 13 yields an integer
//containing only 9s.
//NOTE: Even if x ≤ 4000, m may be very LARGE. If necessary, use the language-appropriate way of handling large integers.

import java.math.BigInteger;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(allNines(BigInteger.valueOf(11))); //9
        System.out.println(allNines(BigInteger.valueOf(12))); //-1
        System.out.println(allNines(BigInteger.valueOf(13))); //76923
        System.out.println(allNines(BigInteger.valueOf(15))); //-1

        System.out.println(allNines2(BigInteger.valueOf(11))); //9
        System.out.println(allNines2(BigInteger.valueOf(12))); //-1
        System.out.println(allNines2(BigInteger.valueOf(13))); //76923
        System.out.println(allNines2(BigInteger.valueOf(15))); //-1

    }

    public static BigInteger allNines(BigInteger x) {
        if (x.mod(BigInteger.TWO).equals(BigInteger.ZERO) || x.mod(BigInteger.valueOf(5)).equals(BigInteger.ZERO)) {
            return new BigInteger("-1");
        }

        String s = "9";

        while (true) {
            BigInteger answer = new BigInteger(s);

            if (answer.mod(x).equals(BigInteger.ZERO)) {
                return answer.divide(x);
            }

            s += "9";
        }
    }

    public static BigInteger allNines2(BigInteger x) {
        BigInteger m = BigInteger.valueOf(1);
        if (x.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0)) || x.mod(BigInteger.valueOf(5)).equals(BigInteger.valueOf(0))) {
            return BigInteger.valueOf(-1);
        }

        while (!isNumberContainsOnlyNines(m.multiply(x))) {
            m = m.add(BigInteger.valueOf(1));
        }

        return m;
    }

    private static boolean isNumberContainsOnlyNines(BigInteger number) {
        return Arrays.stream(String.valueOf(number).split(""))
                .mapToInt(Integer::valueOf)
                .allMatch(s -> s == 9);
    }
}
