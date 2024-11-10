//Your task is to find the sum of triangular numbers, including the n-th triangular number.
//Triangular number: "any series of numbers (1, 3, 6, 10, 15, etc.) obtained by continuously summing
//the natural numbers 1, 2, 3, 4, 5, etc."
//[01]
//02 [03]
//04 05 [06]
//07 08 09 [10]
//11 12 13 14 [15]
//16 17 18 19 20 [21]
//e.g. Given 4: 1 + 3 + 6 + 10 = 20.
//Triangular numbers cannot be negative, so return 0 if a negative number is given.

public class SumOfTriangularNumbers {

    public static void main(String[] args) {
        System.out.println(sumTriangularNumbers(4)); //20
        System.out.println(sumTriangularNumbers(6)); //56
        System.out.println(sumTriangularNumbers(1)); //1
        System.out.println(sumTriangularNumbers(0)); //0
        System.out.println(sumTriangularNumbers(-3)); //0
        System.out.println(sumTriangularNumbers(34)); //7140
        System.out.println(sumTriangularNumbers(943)); //140205240
        System.out.println("______________________________");

        System.out.println(sumTriangularNumbers2(4)); //20
        System.out.println(sumTriangularNumbers2(6)); //56
        System.out.println(sumTriangularNumbers2(1)); //1
        System.out.println(sumTriangularNumbers2(0)); //0
        System.out.println(sumTriangularNumbers2(-3)); //0
        System.out.println(sumTriangularNumbers2(34)); //7140
        System.out.println(sumTriangularNumbers2(943)); //140205240
    }

    public static int sumTriangularNumbers(int n) {
        int sum = 0;

        if (n < 0) {
            return 0;
        }

        for (int i = 1; i <= n; i++) {
            sum += i * (i + 1) / 2; //arithmetic progression
        }

        return sum;
    }

    public static int sumTriangularNumbers2(int n) {
        if (n < 0) {
            return 0;
        }

        return (n * (n + 1) * (n + 2)) / 6;
    }
}
