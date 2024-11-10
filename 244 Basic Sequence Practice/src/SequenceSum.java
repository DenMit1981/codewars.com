//A sequence or a series, in mathematics, is a string of objects, like numbers, that follow a particular pattern.
//The individual elements in a sequence are called terms. A simple example is 3, 6, 9, 12, 15, 18, 21, ..., where the
//pattern is: "add 3 to the previous term".
//In this kata, we will be using a more complicated sequence: 0, 1, 3, 6, 10, 15, 21, 28, ... This sequence is generated
//with the pattern: "the nth term is the sum of numbers from 0 to n, inclusive".
//[ 0,  1,    3,      6,   ...]
//  0  0+1  0+1+2  0+1+2+3
//Your Task
//Complete the function that takes an integer n and returns a list/array of length abs(n) + 1 of the arithmetic series
//explained above. When < 0 return the sequence with negative terms.
//Examples
// 5  -->  [0,  1,  3,  6,  10,  15]
//-5  -->  [0, -1, -3, -6, -10, -15]
// 7  -->  [0,  1,  3,  6,  10,  15,  21,  28]

import java.util.Arrays;
import java.util.stream.IntStream;

public class SequenceSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumOfN(5))); //[0, 1, 3, 6, 10, 15]
        System.out.println(Arrays.toString(sumOfN(-5))); //[0, -1, -3, -6, -10, -15]
        System.out.println(Arrays.toString(sumOfN(7))); //[0, 1, 3, 6, 10, 15, 21, 28]
        System.out.println("___________________");

        System.out.println(Arrays.toString(sumOfN2(5)));
        System.out.println(Arrays.toString(sumOfN2(7)));
        System.out.println(Arrays.toString(sumOfN2(-5)));
    }

    public static int[] sumOfN(int n) {
        int sum = 0;
        int k = 1;
        int[] result = new int[Math.abs(n) + 1];
        result[0] = 0;
        int j = 1;

        for (int i = 0; i < Math.abs(n); i++) {
            sum = k + sum;
            k++;
            if (n > 0) {
                result[j] = sum;
            } else {
                result[j] = -sum;
            }
            j++;
        }

        return result;
    }

    public static int[] sumOfN2(int n) {
        return IntStream.rangeClosed(0, Math.abs(n))
                .map(i -> (n > 0 ? 1 : -1) * i * (i + 1) / 2)
                .toArray();
    }
}
