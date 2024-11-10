//There is an array with some numbers. All numbers are equal except one. Try to find it!
//Kata.findUniq(new double[]{1, 1, 1, 2, 1, 1}); // => 2
//Kata.findUniq(new double[]{0, 0, 0.55, 0, 0}); // => 0.55
//It is guaranteed that the array contains at least 3 numbers.
//Find the unique number

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println(findUniq(new double[]{0, 1, 0})); //1.0
        System.out.println(findUniq(new double[]{1, 1, 1, 2, 1, 1})); //2.0
        System.out.println(findUniq(new double[]{0, 0, 0.55, 0, 0})); //0.55
        System.out.println(findUniq(new double[]{3.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0})); //3.0

        System.out.println(findUniq1(new double[]{0, 1, 0})); //1.0
        System.out.println(findUniq1(new double[]{1, 1, 1, 2, 1, 1})); //2.0
        System.out.println(findUniq1(new double[]{0, 0, 0.55, 0, 0})); //0.55
        System.out.println(findUniq1(new double[]{3.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0})); //3.0
    }

    public static double findUniq(double[] arr) {
        Arrays.sort(arr);
        double num = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == num) {
                num = arr[arr.length - 1];
                break;
            }
        }
        return num;
    }

    public static double findUniq1(double[] arr) {
        Arrays.sort(arr);
        return arr[0] == arr[1] ? arr[arr.length - 1] : arr[0];
    }
}
