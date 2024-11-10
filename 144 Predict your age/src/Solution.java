//My grandfather always predicted how people would age, and right before he died, he revealed his secret!
//In honor of my grandfather's memory, we'll write a function using his formula!
//Make a list of the ages each of your great-grandfathers died.
//Multiply each number by itself.
//Add them all together.
//Take the square root of the result.
//Divide by two.
//Example
//PredictAge(65, 60, 75, 55, 60, 63, 64, 45) === 86
//Note: The result should be rounded down to the nearest whole number.

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(predictAge(65, 60, 75, 55, 60, 63, 64, 45)); //86
        System.out.println(predictAge(32, 54, 76, 65, 34, 63, 64, 45)); //79
        System.out.println();

        System.out.println(predictAge2(65, 60, 75, 55, 60, 63, 64, 45)); //86
        System.out.println(predictAge2(32, 54, 76, 65, 34, 63, 64, 45)); //79
    }

    public static int predictAge(int age1, int age2, int age3, int age4, int age5, int age6, int age7, int age8) {
        int[] ageArr = new int[]{age1, age2, age3, age4, age5, age6, age7, age8};
        int sum = 0;

        for (int j : ageArr) {
            sum += j * j;
        }

        return (int) Math.sqrt(sum) / 2;
    }

    public static int predictAge2(int age1, int age2, int age3, int age4, int age5, int age6, int age7, int age8) {
        return (int) Math.sqrt(Arrays
                .stream(new int[]{age1, age2, age3, age4, age5, age6, age7, age8})
                .map(p -> p * p).sum()) / 2;
    }
}
