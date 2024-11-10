//Your task is to write a function that returns the sum of a sequence of integers.
//The sequence is defined by three non-negative values: start, end, step.
//If the start value is greater than the end, your function should return 0. If the end is not the result of an integer
//number of steps, do not add it to the sum. See the 4th example below.
//Examples
//2,2,2 --> 2
//2,6,2 --> 12 (2 + 4 + 6)
//1,5,1 --> 15 (1 + 2 + 3 + 4 + 5)
//1,5,3 --> 5 (1 + 4)

public class Kata {
    public static void main(String[] args) {
        System.out.println(sequenceSum(2, 6, 2)); //12
        System.out.println(sequenceSum(1, 5, 1)); //15
        System.out.println(sequenceSum(1, 5, 3)); //5
        System.out.println(sequenceSum(0, 15, 3)); //45
        System.out.println(sequenceSum(16, 15, 3)); //0
    }

    public static int sequenceSum(int start, int end, int step) {
        int sum = 0;

        for (int i = start; i <= end; i += step) {
            sum += i;
        }
        return sum;
    }
}
