//Given an array/list [] of n integers, find the maximum sum of three numbers in the array without repetitions.
//The size of the array/list is at least 3 .
//The numbers in the array/list may consist of positive, negative, and zero numbers.
//It is possible for numbers in the array/list to be repeated, i.e. (duplications are not counted in the summation).
//Input >> Output Examples
//1- maxTriSum ({3,2,6,8,2,3}) ==> return (17)
//Explanation:
//As a triplet that maximizes the sum of {6,8,3} in order , their sum is (17)
//Note: repetitions are not counted in the summation (i.e. numbers are added only once).
//2- maxTriSum({2,1,8,0,6,4,8,6,2,4}) ==> return (18)
//Explanation:
//As a triple that maximizes the sum of {8, 6, 4} in order, their sum is (18),
//Note: repetitions are not counted in the summation (i.e. the numbers are added only once).
//3- maxTriSum({-7,12,-7,29,-5,0,-7,0,0,29}) ==> return (41)
//Explanation:
//As a triple that maximizes the sum of {12, 29, 0} in order, their sum is (41),
//Note: repetitions are not counted in the summation (i.e. the numbers are added only once).

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(maxTriSum(new int[]{3, 2, 6, 8, 2, 3})); //17
        System.out.println(maxTriSum(new int[]{2, 9, 13, 10, 5, 2, 9, 5})); //32
        System.out.println(maxTriSum(new int[]{2, 1, 8, 0, 6, 4, 8, 6, 2, 4})); //18
        System.out.println(maxTriSum(new int[]{-3, -27, -4, -2, -27, -2})); //-9
        System.out.println(maxTriSum(new int[]{-14, -12, -7, -42, -809, -14, -12})); //-33
        System.out.println(maxTriSum(new int[]{-13, -50, 57, 13, 67, -13, 57, 108, 67})); //232
        System.out.println(maxTriSum(new int[]{-7, 12, -7, 29, -5, 0, -7, 0, 0, 29})); //41
    }

    public static int maxTriSum(int[] numbers) {
        int[] newArr = Arrays.stream(numbers).distinct().sorted().toArray();
        return Arrays.stream(newArr, newArr.length - 3, newArr.length).sum();
    }
}
