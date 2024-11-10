//Given a positive integer n, calculate the following sum:
//n + n/2 + n/4 + n/8 + ...
//All elements of the sum are the results of integer division.
//Example
//25  =>  25 + 12 + 6 + 3 + 1 = 47

import java.util.stream.IntStream;

public class HalvingSum {
    public static void main(String[] args) {
        System.out.println(halvingSum(25)); //47
        System.out.println(halvingSum(127)); //247
        System.out.println("______________");

        System.out.println(halvingSum2(25)); //47
        System.out.println(halvingSum2(127)); //247
    }

    public static int halvingSum(int n) {
        int sum = 0;
        int k = 1;

        while (n / k != 0) {
            sum += n / k;
            k *= 2;
        }
        return sum;
    }

    public static int halvingSum2(int n) {
        return IntStream.iterate(n, i -> i / 2)
                .limit(32)
                .sum(); //32 covers all int cases
    }
}
