//Create a function that returns the sum of the digits formed by the first and last digits, up to the center of the number.
//Worked example
//2520 ➞ 7
//# The first and last digits are 2 and 0.
//#2 and 0 make 20.
//# The second digit is 5, and the second to last digit is 2.
//5 and 2 make 52.
//# 20 + 52 = 72
//Examples
//121 ➞ 13
//11 + 2
//1039 ➞ 22
//19 + 3
//22225555 ➞ 100
//# 25 + 25 + 25 + 25
//Notes
//If the number has an odd number of digits, simply add a single digit in the center (see example #1).
//Any number padded with zeros counts as one digit (see example #2).

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumOf2Digits(5, 2)); //52
        System.out.println(Arrays.toString(getDigitsArr(2520))); //[2, 5, 2, 0]
        System.out.println("______________");

        System.out.println(closingInSum(2520)); //72
        System.out.println(closingInSum(121)); //13
        System.out.println(closingInSum(1039)); //22
        System.out.println(closingInSum(22225555)); //100
        System.out.println(closingInSum(5332824166496569L)); //331
        System.out.println(closingInSum(3440584288422776554L)); //430
        System.out.println(closingInSum(22)); //22
        System.out.println(closingInSum(1)); //1
    }

    public static int closingInSum(long n) {
        int sum = 0;
        int[] digitsArr = getDigitsArr(n);
        int i = 0;
        int j = digitsArr.length - 1;

        if ((j + 1) % 2 != 0) {
            sum = digitsArr[j / 2];
        }

        while (i < j) {
            sum += sumOf2Digits(digitsArr[i], digitsArr[j]);
            i++;
            j--;
        }

        return sum;
    }

    private static int sumOf2Digits(int dig1, int dig2) {
        return Integer.parseInt(dig1 + "" + dig2);
    }

    private static int[] getDigitsArr(long num) {
        return Arrays.stream(String.valueOf(num).split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
