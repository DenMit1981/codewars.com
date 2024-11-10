//In this little challenge, you are given a string of numbers separated by spaces, and you must return the largest
//and smallest numbers.
//Example:
//highAndLow("1 2 3 4 5") // return "5 1"
//highAndLow("1 2 -3 4 5") // return "5 -3"
//highAndLow("1 9 3 4-5") // return "9 -5"
//Notes:
//All numbers are valid Int32 numbers, no need to check them.
//There will always be at least one number in the input string.
//The output string should consist of two numbers separated by a single space, with the largest number coming first.

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println(highAndLow("1 2 3 4 5")); //"5 1"
        System.out.println(highAndLow("1 2 -3 4 5")); //"5 -3"
        System.out.println(highAndLow("1 9 3 4 -5")); //"9 -5"

        System.out.println(highAndLow1("1 2 3 4 5")); //"5 1"
        System.out.println(highAndLow1("1 2 -3 4 5")); //"5 -3"
        System.out.println(highAndLow1("1 9 3 4 -5")); //"9 -5"

        System.out.println(highAndLow2("1 2 3 4 5")); //"5 1"
        System.out.println(highAndLow2("1 2 -3 4 5")); //"5 -3"
        System.out.println(highAndLow2("1 9 3 4 -5")); //"9 -5"
    }

    public static String highAndLow(String numbers) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        if (numbers.length() == 1) return numbers;
        String[] s = numbers.split(" ");
        int[] res = new int[s.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = Integer.parseInt(s[i]);
            if (res[i] < min) min = res[i];
            if (res[i] > max) max = res[i];
        }
        return max + " " + min;
    }

    public static String highAndLow1(String numbers) {
        String[] arr = numbers.split(" ");
        int[] intArr = new int[arr.length];
        for (int i = 0; intArr.length > i; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(intArr);
        return Integer.toString(intArr[intArr.length - 1]) + " " + Integer.toString(intArr[0]);
    }

    public static String highAndLow2(String numbers) {
        int[] ints = Arrays.stream(numbers.split(" "))
                .mapToInt(Integer::parseInt).sorted()
                .toArray();
        return ints[ints.length - 1] + " " + ints[0];
    }
}
