//Got to know Fibonacci's big brother, AKA Tribonacci.
//As the name suggests, it works basically like Fibonacci, but by summing the last 3 (instead of 2) numbers of the
//sequence, it generates the following.
//So, if we were to start our Tribonacci sequence with [1, 1, 1] as the initial input (AKA signature), we would have a
//sequence like this:
//[1, 1, 1, 3, 5, 9, 17, 31, ...]
//But what if we started with [0, 0, 1] as the signature? Since starting with [0, 1] instead of [1, 1] basically shifts
//the overall Fibonacci sequence by one place,
//you might think that we would get the same sequence shifted by 2 positions, but that's not the case and we would get:
//[0, 0, 1, 1, 2, 4, 7, 13, 24, ...]
//Well, you might have guessed it already, but to be clear: you need to create a Fibonacci function that, given an
//array/list of signatures,
//returns the first n elements - the signature included in the sequence so seeded.
//The signature will always contain 3 digits; n will always be a non-negative number;
//if n == 0 then return an empty array (except C return NULL) and be prepared for anything that is not clearly stated ;)

import java.util.Arrays;

public class Xbonacci {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(tribonacci(new double [] {0, 0, 1}, 10))); //[0.0, 0.0, 1.0, 1.0, 2.0, 4.0, 7.0, 13.0, 24.0, 44.0]
        System.out.println(Arrays.toString(tribonacci(new double [] {16.0, 11.0, 6.0}, 1))); //[16.0]
        System.out.println(Arrays.toString(tribonacci(new double [] {1.0, 3.0, 3.0}, 0))); //[]
        System.out.println(Arrays.toString(tribonacci(new double [] {5.0, 1.0, 17.0}, 2))); //[5.0, 1.0]
        System.out.println(Arrays.toString(tribonacci(new double [] {4.0, 18.0, 2.0}, 5))); //[4.0, 18.0, 2.0, 24.0, 44.0]
    }

    public static double[] tribonacci(double[] arr, int n) {
        if (n == 0) return new double[]{};
        if (n == 3 ) return arr;
        if (n == 1 ) return new double[]{arr[0]};
        if (n == 2 ) return new double[]{arr[0], arr[1]};
        double[] res = new double[n];
        int j = 0;
        for (double v : arr) {
            res[j] = v;
            j++;
        }
        for (int i = j; i < n; i++) {
            res[i] = res[j - 1] + res[j - 2] + res[j - 3];
            j++;
        }
        return res;
    }
}
