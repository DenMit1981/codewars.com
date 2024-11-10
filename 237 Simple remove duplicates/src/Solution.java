//Remove the duplicates from a list of integers, keeping the last ( rightmost ) occurrence of each element.
//Example:
//For input: [3, 4, 4, 3, 6, 3]
//remove the 3 at index 0
//remove the 4 at index 1
//remove the 3 at index 3
//Expected output: [4, 6, 3]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{3, 4, 4, 3, 6, 3}))); //[4,6,3]
        System.out.println(Arrays.toString(solve(new int[]{1, 2, 1, 2, 1, 2, 3}))); //[1,2,3]
        System.out.println(Arrays.toString(solve(new int[]{1, 2, 3, 4}))); //[1,2,3,4]
        System.out.println(Arrays.toString(solve(new int[]{1, 1, 4, 5, 1, 2, 1}))); //[4,5,2,1]
    }

    public static int[] solve(int[] arr) {
        List<Integer> list = new ArrayList<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            list.add(arr[i]);
        }
        List<Integer> result = list.stream()
                .distinct()
                .collect(Collectors.toList());
        Collections.reverse(result);

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
