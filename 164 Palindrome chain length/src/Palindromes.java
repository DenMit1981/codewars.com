//A number is a palindrome if it is equal to a number with the digits in reverse order.
//For example, 5, 44, 171, 4884 are palindromes, but 43, 194, 4773 are not.
//Write a function that takes a positive integer and returns the number of special steps
//needed to obtain a palindrome. The special step is "Swap the digits and add to the original number."
//If the resulting number is not a palindrome, repeat the procedure with the sum until the resulting number is a palindrome.
//If the input number is already a palindrome, the number of steps is 0.
//All inputs are guaranteed to have a final palindrome that does not overflow for a long time.
//Example
//For example, start with 87:
//87+78=165 - step 1, not a palindrome
//165+561=726 - step 2, not a palindrome
//726+627=1353 - step 3, not a palindrome
//1353+3531=4884 - step 4, a palindrome!
//4884 is a palindrome, and it took us 4 steps to get it, so the answer for 87 is 4.

public class Palindromes {

    public static void main(String[] args) {
        System.out.println(palindromeChainLength(1)); //0
        System.out.println(palindromeChainLength(88)); //0
        System.out.println(palindromeChainLength(393)); //0
        System.out.println(palindromeChainLength(10)); //1
        System.out.println(palindromeChainLength(134)); //1
        System.out.println(palindromeChainLength(87)); //4
        System.out.println(palindromeChainLength(2897)); //7
        System.out.println(palindromeChainLength(89)); //24
    }

    public static int palindromeChainLength(long n) {
        if (n == getPalindromeForNumber(n)) {
            return 0;
        }

        int count = 1;
        long sum = n + getPalindromeForNumber(n);

        while (sum != getPalindromeForNumber(sum)) {
            sum += getPalindromeForNumber(sum);
            count++;
        }

        return count;
    }

    private static long getPalindromeForNumber(long number) {
        return Long.parseLong(new StringBuilder(String.valueOf(number))
                .reverse()
                .toString());
    }
}
