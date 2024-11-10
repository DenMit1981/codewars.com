//If we list all the natural numbers up to 10 that are multiples of 3 or 5, we get 3, 5, 6, and 9. The sum of these
//multiples is 23.
//Complete the solution so that it returns the sum of all the multiples of 3 or 5 that are less than the given number.
//Also, if the number is negative, return 0 (for languages that have them).
//Note: If a number is a multiple of both 3 and 5, count it only once.

import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(10)); //23
        System.out.println(solution(15)); //45
    }

    public static int solution(int number) {
        if (number < 0) {
            return 0;
        }
        return IntStream.range(1, number).filter(n -> n % 3 == 0 || n % 5 == 0).sum();
    }
}
