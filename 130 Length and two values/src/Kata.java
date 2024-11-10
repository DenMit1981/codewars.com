//Given an integer n and two other values, construct an array of size n filled with those two values alternating
//Examples
//5, true, false --> [true, false, true, false, true]
//10, "blue", "red" --> ["blue", "red", "blue", "red", "blue", "red", "blue", "red", "blue", "red", "blue", "red"]
//0, "one", "two" --> []

import java.util.Arrays;

public class Kata {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(alternate(5, "true", "false"))); //[true, false, true, false, true]
        System.out.println(Arrays.toString(alternate(10, "blue", "red"))); //[blue, red, blue, red, blue, red, blue, red, blue, red]
        System.out.println(Arrays.toString(alternate(0, "one", "two"))); //[]
        System.out.println("____________________");

        System.out.println(Arrays.toString(alternate2(5, "true", "false"))); //[true, false, true, false, true]
        System.out.println(Arrays.toString(alternate2(10, "blue", "red"))); //[blue, red, blue, red, blue, red, blue, red, blue, red]
        System.out.println(Arrays.toString(alternate2(0, "one", "two"))); //[]
    }

    public static String[] alternate(int n, String firstValue, String secondValue) {
        String[] result = new String[n];

        if (n % 2 != 0) {
            result[n - 1] = firstValue;
        }

        for (int i = 0; i < result.length - 1; i += 2) {
            result[i] = firstValue;
            result[i + 1] = secondValue;
        }
        return result;
    }

    public static String[] alternate2(int n, String firstValue, String secondValue) {
        String[] result = new String[n];
        if (n % 2 != 0) {
            result[n - 1] = firstValue;
        }
        for (int i = 0, j = i + 1; i < result.length - 1; i += 2, j += 2) {
            result[i] = firstValue;
            result[j] = secondValue;
        }
        return result;
    }
}
