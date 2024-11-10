//Are the numbers in order?
//In this Kata, your function receives an array of integers as input. Your task is to determine whether the numbers are in
//ascending order. An array is said to be in ascending order if there are no two adjacent integers
//where the left integer is greater in value than the right integer.
//For the purposes of this Kata, you can assume that all inputs are valid, i.e. non-empty arrays
//containing only integers.
//Note that an array of 1 integer is automatically assumed to be sorted in ascending order, since all (zero) adjacent pairs of integers satisfy the condition that the left integer is not greater in value than the right integer. The empty list is considered a degenerate case and will therefore not be tested by this Kata - feel free to raise an issue if you see such a list being tested.
//For example:
//isAscOrder(new int[]{1,2,4,7,19}) == true
//isAscOrder(new int[]{1,2,3,4,5}) == true
//isAscOrder(new int[]{1,6,10,18,2,4,20}) == false
//isAscOrder(new int[]{9,8,7,6,5,4,3,2,1}) == false // numbers are in DESCENDING order

public class Solution {
    public static void main(String[] args) {
        System.out.println(isAscOrder(new int[]{1, 2, 4, 7, 19})); //true
        System.out.println(isAscOrder(new int[]{1, 2, 3, 4, 5})); //true
        System.out.println(isAscOrder(new int[]{1, 6, 10, 18, 2, 4, 20})); //false
        System.out.println(isAscOrder(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1})); //false
        System.out.println(isAscOrder(new int[]{9})); //true
    }

    public static boolean isAscOrder(int[] arr) {
        boolean isAscOrder = true;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isAscOrder = false;
                break;
            }
        }
        return isAscOrder;
    }
}
