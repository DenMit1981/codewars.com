//The Museum of Incredibly Boring Things
//The Museum of Incredibly Boring Things wants to get rid of some of its exhibits. Miriam, an interior designer,
//comes up with a plan to remove the most boring exhibits. She rates them, then removes the one
//with the lowest rating.
//However, once she has finished rating all the exhibits, she goes to an important fair and asks you to write
//a program that tells her the ratings of the exhibits after removing the lowest one. Fair enough.
//Problem
//Given an array of integers, remove the smallest value. Do not modify the original array/list.
//If there are multiple elements with the same value, remove the element with the smallest index.
//If you get an empty array/list, return an empty array/list.
//Do not change the order of the remaining elements.
//Examples
//* Input: [1,2,3,4,5], output = [2,3,4,5]
//* Input: [5,3,2,1,4], output = [5,3,2,4]
//* Input: [2,2,1,2,1], output = [2,2,2,1]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Remover {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeSmallest(new int[]{1, 2, 3, 4, 5}))); //[2, 3, 4, 5]
        System.out.println(Arrays.toString(removeSmallest(new int[]{5, 3, 2, 1, 4}))); //[5, 3, 2, 4]
        System.out.println(Arrays.toString(removeSmallest(new int[]{5, 4, 3, 2, 1}))); //[5, 4, 3, 2]
        System.out.println(Arrays.toString(removeSmallest(new int[]{2, 2, 1, 2, 1}))); //[2, 2, 2, 1]
        System.out.println(Arrays.toString(removeSmallest(new int[]{}))); //[]
    }

    public static int[] removeSmallest(int[] numbers) {
        List<Integer> numbersList = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        for (Integer number : numbersList) {
            if (number.equals(getMinNumber(numbers))) {
                numbersList.remove(number);
                break;
            }
        }

        return numbersList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static int getMinNumber(int[] numbers) {
        return Arrays.stream(numbers).min().getAsInt();
    }
}
