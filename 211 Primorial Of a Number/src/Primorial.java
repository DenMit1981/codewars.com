//Definition (prime number)
//Similar to the factorial of a number. In the primitive method, not all natural numbers are multiplied, to calculate a
//prime number, only prime numbers are multiplied. It is denoted by P# and is the product of the first n prime numbers.
//Problem
//Given a number N, calculate its original value.!alt!alt
//Notes
//Only positive numbers (N > 0) will be passed.
//Input >> output examples:
//1- numPrimorial (3) ==> return (30)
//Explanation:
//Since the passed number is (3), the original number must be obtained by multiplying 2 * 3 * 5 = 30.
//Mathematically written as P3# = 30 .
//2- numPrimorial (5) ==> return (2310)
//Explanation:
//Since the passed number is (5), the original number must be obtained by multiplying 2 * 3 * 5 * 7 * 11 = 2310.
//Mathematically written as P5# = 2310.
//3- numPrimorial (6) ==> return (30030)
//Explanation:
//Since the passed number is (6), the original number must be obtained by multiplying 2 * 3 * 5 * 7 * 11 * 13 = 30030.
//Mathematically written as P6# = 30030.

import java.math.BigInteger;

public class Primorial {
    public static void main(String[] args) {
        System.out.println(isNumberSimple(4)); //false
        System.out.println(isNumberSimple(5)); //true
        System.out.println(isNumberSimple(22)); //false
        System.out.println("__________________");

        System.out.println(numPrimordial(3)); //30
        System.out.println(numPrimordial(5)); //2310
        System.out.println(numPrimordial(6)); //30030
        System.out.println(numPrimordial(9)); //223092870
    }

    public static String numPrimordial(int n) {
        BigInteger mul = BigInteger.valueOf(1);
        int i = 2;
        int j = 0;

        while (j < n) {
            if (isNumberSimple(i)) {
                mul = mul.multiply(BigInteger.valueOf(i));
                j++;
            }
            i++;
        }

        return String.valueOf(mul);
    }

    private static boolean isNumberSimple(int number) {
        boolean isNumberSimple = true;

        for (int i = 2; i < number - 1; i++) {
            if (number % i == 0) {
                isNumberSimple = false;
                break;
            }
        }
        return isNumberSimple;
    }
}
