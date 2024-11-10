//A natural number is called k-prime if it has exactly k prime factors, counted with multiplicity. For example:
//k = 2 -> 4, 6, 9, 10, 14, 15, 21, 22, ...
//k = 3 -> 8, 12, 18, 20, 27, 28, 30, ...
//k = 5 -> 32, 48, 72, 80, 108, 112, ...
//Thus, a natural number is prime if and only if it is 1-prime.
//Problem:
//Terminate the function count_Kprimes (or countKprimes, count-K-primes, kPrimes) given parameters k, start,
//end (or nd), and return an array
//(or list or string depending on the language - see "Solution" and "Sample tests") of k-primes between start
//(inclusive) and end (inclusive).
//Example:
//countKprimes (5, 500, 600) -> [500, 520, 552, 567, 588, 592, 594]
//Notes:
//The first function would be better named: findKprimes or kPrimes :-)
//C provides some helper functions (see the declarations in the "Solution" section).
//For Go: expect a zero slice if there are no k-primes between start and end.
//Second Problem: Puzzle (not for Shell)
//For a positive integer s, find the total number of solutions to the equation a + b + c = s, where a is 1-prime,
//b is 3-prime, and c is 7-prime.
//Call this puzzle function.
//Examples:
//puzzle (138) -> 1 because [2 + 8 + 128] is the only solution
//puzzle (143) -> 2 because [3 + 12 + 128] and [7 + 8 + 128] are solutions

import java.util.*;

public class KPrimes {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countKprimes(2, 0, 100))); //[4, 6, 9, 10, 14, 15, 21, 22, 25, 26, 33, 34, 35, 38, 39, 46, 49, 51, 55, 57, 58, 62, 65, 69, 74, 77, 82, 85, 86, 87, 91, 93, 94, 95];
        System.out.println(Arrays.toString(countKprimes(5, 500, 600))); //[500, 520, 552, 567, 588, 592, 594];
    }

    public static int[] countKprimes(int k, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(k, i)) {
                count++;
            }
        }
        int[] res = new int[count];
        int j = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(k, i)) {
                res[j] = i;
                j++;
            }
        }
        return res;
    }

    private static boolean isPrime(int k, long n) {
        int count = 0;
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                n /= i;
                count++;
            }
        }
        if (n > 1) {
            count++;
        }
        return count == k;
    }
}

