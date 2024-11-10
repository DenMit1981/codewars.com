//You will be given an array of integers. Your task is to take that array and find the index N where the sum of the
//integers to the left
//of N equals the sum of the integers to the right of N. If there is no index that can do this, return - 1.
//Suppose you are given the array {1,2,3,4,3,2,1}:
//Your function will return index 3, because at the 3rd position of the array, the sum of the left side of the index ({1,2,3})
//and the sum of the right side of the index ({3,2, 1}) are both 6.
//You are given the array {1,100,50, -51,1,1}:
//Your function will return index 1, because at the 1st position of the array, the sum of the left side of the index ({1})
//and the sum of the right side of the index ({50, -51,1,1 }) are both 1.
//You are given the array {20,10, -80,10,10,15,35}
//At index 0, the left side is {}
//Right side is {10, -80,10,10,15,35}
//When added, they are both 0. (Empty arrays are 0 in this problem)
//Index 0 is where the left and right sides are equal.
//Note: Remember that in most programming/scripting languages, array indexes start at 0.
//Input:
//An integer array of length 0 < arr < 1000. The numbers in the array can be any integer, positive or negative.
//Output:
//The lowest index of N where the side on the left of N is equal to the side on the right of N. If you don't find an index
//that follows these rules, you will return -1.
//Note:
//If you are given an array with multiple answers, return the lowest correct index.

import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        System.out.println(findEvenIndex(new int[]{1, 2, 3, 4, 3, 2, 1})); //3
        System.out.println(findEvenIndex(new int[]{1, 100, 50, -51, 1, 1})); //1
        System.out.println(findEvenIndex(new int[]{1, 2, 3, 4, 5, 6})); //-1
        System.out.println(findEvenIndex(new int[]{20, 10, 30, 10, 10, 15, 35})); //3
        System.out.println(findEvenIndex(new int[]{-8505, -5130, 1926, -9026})); //-1
        System.out.println(findEvenIndex(new int[]{2824, 1774, -1490, -9084, -9696, 23094})); //1
        System.out.println(findEvenIndex(new int[]{4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4})); //6

        System.out.println(findEvenIndex1(new int[]{1, 2, 3, 4, 3, 2, 1})); //3
        System.out.println(findEvenIndex1(new int[]{1, 100, 50, -51, 1, 1})); //1
        System.out.println(findEvenIndex1(new int[]{1, 2, 3, 4, 5, 6})); //-1
        System.out.println(findEvenIndex1(new int[]{20, 10, 30, 10, 10, 15, 35})); //3
        System.out.println(findEvenIndex1(new int[]{-8505, -5130, 1926, -9026})); //-1
        System.out.println(findEvenIndex1(new int[]{2824, 1774, -1490, -9084, -9696, 23094})); //1
        System.out.println(findEvenIndex1(new int[]{4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4})); //6

        System.out.println(findEvenIndex2(new int[]{1, 2, 3, 4, 3, 2, 1})); //3
        System.out.println(findEvenIndex2(new int[]{1, 100, 50, -51, 1, 1})); //1
        System.out.println(findEvenIndex2(new int[]{1, 2, 3, 4, 5, 6})); //-1
        System.out.println(findEvenIndex2(new int[]{20, 10, 30, 10, 10, 15, 35})); //3
        System.out.println(findEvenIndex2(new int[]{-8505, -5130, 1926, -9026})); //-1
        System.out.println(findEvenIndex2(new int[]{2824, 1774, -1490, -9084, -9696, 23094})); //1
        System.out.println(findEvenIndex2(new int[]{4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4})); //6
    }

    public static int findEvenIndex(int[] arr) {
        int left = 0, right = 0;
        for (int i = 0; i < arr.length; i++, left = 0, right = 0) {
            for (int j = 0; j < i; j++) {
                left += arr[j];
            }
            for (int k = arr.length - 1; k > i; k--) {
                right += arr[k];
            }
            if (left == right) return i;
        }
        return -1;
    }

    public static int findEvenIndex1(int[] arr) {
        return IntStream.range(0, arr.length)
                .filter(n -> IntStream.of(arr).limit(n).sum() == IntStream.of(arr).skip(n + 1).sum())
                .findFirst().orElse(-1);
    }

    public static int findEvenIndex2(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        int half = 0;
        for (int i = 0; i < arr.length; i++) {
            if (half == (sum - arr[i]) / 2) {
                return i;
            }
            half += arr[i];
        }
        return -1;
    }
}
