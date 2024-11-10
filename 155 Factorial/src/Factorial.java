import java.util.stream.IntStream;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(4)); //24
        System.out.println(factorial(7)); //5040
        System.out.println(factorial(0)); //1

        System.out.println(factorialByRecursion(4)); //24
        System.out.println(factorialByRecursion(7)); //5040
        System.out.println(factorialByRecursion(0)); //1

        System.out.println(factorialByStreamApi(4)); //24
        System.out.println(factorialByStreamApi(7)); //5040
        System.out.println(factorialByStreamApi(0)); //1
    }

    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        }

        long fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }

    public static long factorialByRecursion(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return factorialByRecursion(n - 1) * n;
    }

    public static long factorialByStreamApi(int n) {
        return IntStream.rangeClosed(2, n).reduce(1, (x, y) -> x * y);
    }
}
