//Given a list of digits, return the smallest number that can be made from those digits using the digits only once
//(ignoring duplicates).
//Notes:
//Only positive integers (> 0) will be passed to the function, no negative values or zeros.
//Input >> Output Examples
//minValue({1, 3, 1}) ==> return (13)
//Explanation:
//(13) is the smallest number that can be made from {1, 3, 1} without repetition
//
//minValue({5, 7, 5, 9, 7}) ==> return (579)
//Explanation:
//(579) is the smallest number that can be made from {5, 7, 5, 9, 7} without repetition.
//
//minValue({1, 9, 3, 1, 7, 4, 6, 6, 7}) return ==> (134679)
//Explanation:
//(134679) is the minimum number that can be composed of {1, 9, 3, 1, 7, 4, 6, 6, 7} without repetitions

import java.util.Arrays;
import java.util.HashSet;

public class Minimum {
    public static void main(String[] args) {
        System.out.println(minValue(new int[]{5, 7, 9, 5, 7})); //579
        System.out.println(minValue(new int[]{1, 3, 1})); //13
        System.out.println(minValue(new int[]{4, 7, 5, 7})); //457
        System.out.println(minValue(new int[]{4, 8, 1, 4})); //148
        System.out.println(minValue(new int[]{6, 7, 8, 7, 6, 6})); //678
        System.out.println();

        System.out.println(minValue2(new int[]{5, 7, 9, 5, 7})); //579
        System.out.println(minValue2(new int[]{1, 3, 1})); //13
        System.out.println(minValue2(new int[]{4, 7, 5, 7})); //457
        System.out.println(minValue2(new int[]{4, 8, 1, 4})); //148
        System.out.println(minValue2(new int[]{6, 7, 8, 7, 6, 6})); //678
    }

    public static int minValue(int[] values) {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(values);
        sb.append(values[0]);

        for (int i = 1; i < values.length; i++) {
            if (values[i] != values[i - 1]) {
                sb.append(values[i]);
            }
        }

        return Integer.parseInt(sb.toString());
    }

    public static int minValue2(int[] values) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(values);
        HashSet<Integer> hashSet = new HashSet<>();

        for (int value : values) {
            hashSet.add(value);
        }

        for (Integer num : hashSet) {
            sb.append(num);
        }

        return Integer.parseInt(sb.toString());
    }
}

