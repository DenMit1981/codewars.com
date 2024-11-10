//A reciprocal is a number that remains the same when turned upside down.
//For example, the first 20 reciprocals are:
//0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 22, 33, 44, 55, 66, 77, 88, 99, 101
//PROBLEM:
//You need to return the n-th reciprocal number. (Assume that reciprocals start with 0, as shown in the example.)
//NOTES:
//1 < n <= 100000000000

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Palindrome {

    public static void main(String[] args) {

        System.out.println(findReverseNumber(1)); //0
        System.out.println(findReverseNumber(20)); //101
        System.out.println(findReverseNumber(10)); //11
        System.out.println(findReverseNumber(100)); //909
        System.out.println(findReverseNumber(1000)); //90009
        System.out.println(findReverseNumber(10000)); //90009
        System.out.println(findReverseNumber(10000000)); //900000000009
        System.out.println(findReverseNumber(19999999)); //99999999999999
        System.out.println("________________");

        System.out.println(findReverseNumber2(1)); //0
        System.out.println(findReverseNumber2(20)); //101
        System.out.println(findReverseNumber2(10)); //9
        System.out.println(findReverseNumber2(100)); //909
        System.out.println(findReverseNumber2(1000)); //90009
        System.out.println(findReverseNumber2(10000)); //9000009
        System.out.println(findReverseNumber2(22222)); //9000009
    }

    public static BigInteger findReverseNumber(long n) { //max number = 14 digits, max n = 8 digits
        List<BigInteger> list = findReverseNumberByDigits(15);

        return list.get((int) n - 1);
    }

    private static List<BigInteger> findReverseNumberByDigits(long digits) {
        List<BigInteger> list = new ArrayList<>();
        long dig = (long) Math.pow(10, digits / 2);
        int pow = 10;
        int npow = 100;

        for (long i = 1; i <= dig; i++) {
            list.add(BigInteger.valueOf(i * pow + getReverse(i)));
            list.add(BigInteger.valueOf(i * pow / 10 + getReverse(i / 10)));
            if (i % pow == 0) {
                pow = npow;
                npow *= 10;
            }
        }

        return list.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static BigInteger findReverseNumber2(long n) { //max number = 9 digits, max n = 5 digits
        List<BigInteger> list = new ArrayList<>();
        long i = 0;

        while (list.size() < n) {
            if (isNumberPalindrome(i)) {
                list.add(BigInteger.valueOf(i));
            }

            i++;
        }

        return list.get(list.size() - 1);
    }

    private static boolean isNumberPalindrome(long n) {
        return new StringBuilder(String.valueOf(n))
                .reverse()
                .toString()
                .equals(String.valueOf(n));
    }

    private static long getReverseByString(long n) {
        return Long.parseLong(new StringBuilder(String.valueOf(n))
                .reverse()
                .toString());
    }

    private static long getReverse(long n) {
        long reverse = 0;

        while (n != 0) {
            long last = n % 10;
            reverse = reverse * 10 + last;
            n /= 10;
        }

        return reverse;
    }
}
