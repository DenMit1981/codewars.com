//Scenario
//For grains such as wheat or rice, before we can eat the grain, we need to remove the inedible husk, or separate the
//wheat from the chaff.
//Problem
//Given a sequence of n integers, separate the negative integers (chaff) from the positive integers (wheat).
//Notes
//Size of sequence is at least 3
//Return a new sequence with the negative integers (chaff) first, then the positive integers (wheat).
//In Java, you are not allowed to modify the input array/list/vector.
//Fear not, there are guaranteed to be no zeros .!alt
//Repetition of numbers in the input sequence may occur, so duplicates are included in the splitting.
//If an out-of-place positive integer is found at the front of the sequence, replace it with the last out-of-place
//negative integer (found near the end of the input). The second out-of-place positive integer should be replaced with
//the second-last out-of-place negative integer. Negative numbers at the beginning (start) of the sequence
//should be left in place.
//Input >> output examples:
//wheatFromChaff ({7, -8, 1,-2}) ==> return ({-2, -8, 1, 7})

import java.util.Arrays;

public class Kata {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(wheatFromChaff(new long[]{7, -8, 1, -2}))); //[-2, -8, 1, 7]
        System.out.println(Arrays.toString(wheatFromChaff(new long[]{2, -4, 6, -6}))); //[-6, -4, 6, 2]
        System.out.println(Arrays.toString(wheatFromChaff(new long[]{8, 10, -6, -7, 9}))); //[-7, -6, 10, 8, 9]
    }

    public static long[] wheatFromChaff(long[] values) {
        long[] result = new long[values.length];
        System.arraycopy(values, 0, result, 0, result.length);
        int startIndex = 0;
        int endIndex = result.length - 1;

        while (startIndex < endIndex) {
            if (result[startIndex] < 0) {
                startIndex++;
            } else {
                if (result[endIndex] > 0) {
                    endIndex--;
                } else {
                    swap(result, startIndex, endIndex);
                }
            }
        }

        return result;
    }

    private static void swap(long[] values, int index1, int index2) {
        long temp = values[index1];
        values[index1] = values[index2];
        values[index2] = temp;
    }
}
