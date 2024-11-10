//Scenario
//Several people stand in a row, divided into two teams.
//The first person is in the first team, the second in the second, the third in the first, and so on.
//Problem
//Given an array of positive integers (the weights of the people), return a new array/tuple of two integers,
//where the first is the total weight of team 1, and the second is the total weight of team 2.
//Notes
//The array size is at least 1.
//All numbers will be positive.
//Input >> Output Examples
//rowWeights([13, 27, 49]) ==> return (62, 27)
//Explanation:
//The first element 62 is the total weight of team 1, and the second element 27 is the total weight of team 2.
//rowWeights([50, 60, 70, 80]) ==> return (120, 140)
//Explanation:
//The first element 120 is the total weight of team 1, and the second element 140 is the total weight of team 2.
//rowWeights([80]) ==> return (80, 0)
//Explanation:
//The first element 80 is the total weight of team 1, and the second element 0 is the total weight of team 2.

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rowWeights(new int[]{50, 60, 70, 80}))); //[120, 140]
        System.out.println(Arrays.toString(rowWeights(new int[]{29, 83, 67, 53, 19, 28, 96}))); //[211, 164]
        System.out.println(Arrays.toString(rowWeights(new int[]{80}))); //[80, 0]
        System.out.println();

        System.out.println(Arrays.toString(rowWeights2(new int[]{50, 60, 70, 80}))); //[120, 140]
        System.out.println(Arrays.toString(rowWeights2(new int[]{29, 83, 67, 53, 19, 28, 96}))); //[211, 164]
        System.out.println(Arrays.toString(rowWeights2(new int[]{80}))); //[80, 0]
    }

    public static int[] rowWeights(final int[] weights) {
        if (weights.length < 2) {
            return new int[]{weights[0], 0};
        }

        int firstWeightSum = weights[0];
        int secondWeightSum = weights[1];

        if (weights.length % 2 != 0) {
            firstWeightSum += weights[weights.length - 1];
        }

        for (int i = 2; i < weights.length - 1; i += 2) {
            firstWeightSum += weights[i];
            secondWeightSum += weights[i + 1];
        }
        return new int[]{firstWeightSum, secondWeightSum};
    }

    public static int[] rowWeights2(final int[] weights) {
        int sum1 = IntStream.range(0, weights.length).map(i -> i % 2 == 0 ? weights[i] : 0).sum();
        int sum2 = IntStream.range(0, weights.length).map(i -> i % 2 != 0 ? weights[i] : 0).sum();

        return new int[]{sum1, sum2};
    }
}
