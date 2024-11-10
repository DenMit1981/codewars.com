//Determine the total number of digits in an integer (n>=0) given as input to the function. For example,
//9 is one digit, 66 is 2 digits, and 128685 is 6 digits. Be careful to avoid
//overflow/underflow.

import java.util.stream.Stream;

public class NumberOfDecimalDigits {

    public static void main(String[] args) {
        System.out.println(digits(9876543210L)); //10
        System.out.println(digits(323L)); //3
        System.out.println(digits(9)); //1
        System.out.println(digits(0)); //1
        System.out.println("_______________");

        System.out.println(digitsByString(9876543210L)); //10
        System.out.println(digitsByString(323L)); //3
        System.out.println(digitsByString(9)); //1
        System.out.println(digitsByString(0)); //1
        System.out.println("_______________");

        System.out.println(digitsByString2(9876543210L)); //10
        System.out.println(digitsByString2(323L)); //3
        System.out.println(digitsByString2(9)); //1
        System.out.println(digitsByString2(0)); //1
    }

    public static int digits(long n) {
        int count = 0;

        if (n == 0L) {
            return 1;
        }

        while (n != 0) {
            n /= 10;
            count++;
        }

        return count;
    }

    public static int digitsByString(long n) {
        return (int) Stream.of(String.valueOf(n).split("")).count();
    }

    public static int digitsByString2(long n) {
        return String.valueOf(n).split("").length;
    }
}
