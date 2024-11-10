//Convert a number to a reversed array of digits
//Given a random non-negative number, you must return the digits of that number in an array in reverse order.

import java.util.Arrays;

public class Kata {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(digitize(35231)));  //[1, 3, 2, 5, 3]
        System.out.println(Arrays.toString(digitize(0))); //[0]

        System.out.println(Arrays.toString(digitize2(35231))); //[1, 3, 2, 5, 3]
    }

    public static int[] digitize(long n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        String reversedString = sb.reverse().toString();
        String[] reversedArr = reversedString.split("");
        int[] digitsArr = new int[reversedArr.length];

        for (int i = 0; i < digitsArr.length; i++) {
            digitsArr[i] = Integer.parseInt(reversedArr[i]);
        }

        return digitsArr;
    }

    public static int[] digitize2(long n) {
        return new StringBuilder()
                .append(n)
                .reverse()
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }
}

