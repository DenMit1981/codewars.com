//Given a non-negative integer, return an array / a list of the individual digits in order.
//Examples:
//123 => [1,2,3]
//1 => [1]
//8675309 => [8,6,7,5,3,0,9]

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(digitize(123))); //[1, 2, 3]
        System.out.println(Arrays.toString(digitize(1))); //[1]
        System.out.println(Arrays.toString(digitize(0))); //[0]
        System.out.println(Arrays.toString(digitize(1230))); //[1, 2, 3, 0]
        System.out.println(Arrays.toString(digitize(8675309))); //[8, 6, 7, 5, 3, 0, 9]
        System.out.println("_____________________-");

        System.out.println(Arrays.toString(digitize2(123))); //[1, 2, 3]
        System.out.println(Arrays.toString(digitize2(1))); //[1]
        System.out.println(Arrays.toString(digitize2(0))); //[0]
        System.out.println(Arrays.toString(digitize2(1230))); //[1, 2, 3, 0]
        System.out.println(Arrays.toString(digitize2(8675309))); //[8, 6, 7, 5, 3, 0, 9]
    }

    public static int[] digitize(int n) {
        String[] strArr = String.valueOf(n).split("");

        int[] result = new int[strArr.length];
        int i = 0;

        for (String str : strArr) {
            result[i] = Integer.parseInt(str);
            i++;
        }

        return result;
    }

    public static int[] digitize2(int n) {
        return Arrays.stream(String.valueOf(n).split(""))
                .mapToInt(Integer::valueOf)
                .toArray();
    }
}
