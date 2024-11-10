//There is a queue at the self-checkout counters in a supermarket. Your task is to write a function to calculate the
//total time it takes all customers to check out!
//input
//customers: an array of positive integers representing the queue. Each integer represents a customer,
//and its value is the amount of time it takes them to check out.
//n: a positive integer, the number of checkout counters.
//output
//The function should return an integer — the total time required.
//Examples
//queue time([5,3,4], 1)
//// should return 12
//// because when there is 1 checkout counter, the total time is the sum of the times
//queue time([10,2,3,3], 2)
//// should return 10
//// because here n=2 and the 2nd, 3rd, and 4th people in
//// the queue ends before the 1st person finishes.
//queuetime([2,3,10],2)
//// should return 12
//Clarifications
//There is only ONE queue serving multiple checkouts, and
//The order of the queue NEVER changes, and
//The first person in the queue (i.e. the first element in the array/list) moves to a checkout as soon as it becomes
//available.
//N.B. You should assume that all test inputs will be valid as stated above.

import java.util.Arrays;

public class SupermarketQueue {

    public static void main(String[] args) {
        System.out.println(solveSuperMarketQueue(new int[]{2, 2, 3, 3, 4, 4}, 2)); //9
        System.out.println(solveSuperMarketQueue(new int[]{}, 1)); //0
        System.out.println(solveSuperMarketQueue(new int[]{1, 2, 3, 4, 5}, 1)); //15
        System.out.println(solveSuperMarketQueue(new int[]{5, 3, 4}, 1)); //12
        System.out.println(solveSuperMarketQueue(new int[]{2, 3, 10}, 2)); //12
        System.out.println(solveSuperMarketQueue(new int[]{10, 2, 3, 3}, 2)); //10
    }

    public static int solveSuperMarketQueue(int[] customers, int n) {
        int[] result = new int[n];

        for (int customer : customers) {
            result[0] += customer;
            Arrays.sort(result);
        }

        return result[n - 1];
    }
}
