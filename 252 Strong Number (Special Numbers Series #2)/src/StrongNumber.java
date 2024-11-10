//Strong number is a number with the sum of the factorial of its digits is equal to the number itself.
//For example, 145 is strong, because 1! + 4! + 5! = 1 + 24 + 120 = 145.
//Task
//Given a positive number, find if it is strong or not, and return either "STRONG!!!!" or "Not Strong !!".
//Examples
//1 is a strong number, because 1! = 1, so return "STRONG!!!!".
//123 is not a strong number, because 1! + 2! + 3! = 9 is not equal to 123, so return "Not Strong !!".
//145 is a strong number, because 1! + 4! + 5! = 1 + 24 + 120 = 145, so return "STRONG!!!!".
//150 is not a strong number, because 1! + 5! + 0! = 122 is not equal to 150, so return "Not Strong !!".

import java.util.Arrays;
import java.util.stream.IntStream;

public class StrongNumber {
    public static void main(String[] args) {
        System.out.println(isStrongNumber(145)); //"STRONG!!!!"
        System.out.println(isStrongNumber(123)); //"Not Strong !!"
        System.out.println(isStrongNumber(1)); //"STRONG!!!!"
        System.out.println(isStrongNumber(7)); //"Not Strong !!"
        System.out.println(isStrongNumber(93)); //"Not Strong !!"
        System.out.println(isStrongNumber(185)); //"Not Strong !!"
        System.out.println("_______________________");

        System.out.println(isStrongNumber2(145)); //"STRONG!!!!"
        System.out.println(isStrongNumber2(123)); //"Not Strong !!"
        System.out.println(isStrongNumber2(1)); //"STRONG!!!!"
        System.out.println(isStrongNumber2(7)); //"Not Strong !!"
        System.out.println(isStrongNumber2(93)); //"Not Strong !!"
        System.out.println(isStrongNumber2(185)); //"Not Strong !!"
    }

    public static String isStrongNumber(int num) {
        int sum = 0;
        for (String digit : String.valueOf(num).split("")) {
            sum += getFactorial(Integer.parseInt(digit));
        }
        return sum == num ? "STRONG!!!!" : "Not Strong !!";
    }

    public static String isStrongNumber2(int num) {
        int sum = Arrays.stream(String.valueOf(num).split(""))
                .mapToInt(i -> getFactorialByStream(Integer.parseInt(i)))
                .sum();
        return sum == num ? "STRONG!!!!" : "Not Strong !!";
    }

    private static int getFactorial(int num) {
        int mul = 1;
        for (int i = 1; i <= num; i++) {
            mul *= i;
        }
        return mul;
    }

    private static int getFactorialByStream(int num) {
        return IntStream.rangeClosed(1, num).reduce(1, (a, b) -> a * b);
    }
}
