//You get an array of arrays.
//If you sort the arrays by their length, you'll see that their length values are consecutive.
//But one array is missing!
//You need to write a method that returns the length of the missing array.
//Example:
//[[1, 2], [4, 5, 1, 1], [1], [5, 6, 7, 8, 9]] --> 3
//If the array of arrays is null/nil or empty, the method should return 0.
//When an array in array is null or empty, the method should also return 0!
//There will always be a missing element, and its length will always be between the given arrays.

import java.util.*;

public class LengthOfMissingArray {

    public static void main(String[] args) {
        System.out.println(getLengthOfMissingArray(new Object[][]
                {new Object[]{1, 2}, new Object[]{4, 5, 1, 1}, new Object[]{1}, new Object[]{5, 6, 7, 8, 9}})); //3
        System.out.println(getLengthOfMissingArray(new Object[][]
                {new Object[]{5, 2, 9}, new Object[]{4, 5, 1, 1}, new Object[]{1}, new Object[]{5, 6, 7, 8, 9}})); //2
        System.out.println(getLengthOfMissingArray(new Object[][]
                {new Object[]{'a', 'a', 'a'}, new Object[]{'a', 'a'}, new Object[]{'a', 'a', 'a', 'a'},
                        new Object[]{'a'}, new Object[]{'a', 'a', 'a', 'a', 'a', 'a'}})); //5
        System.out.println(getLengthOfMissingArray(new Object[][]
                {new Object[]{null}, new Object[]{null, null, null}})); //2
        System.out.println(getLengthOfMissingArray(new Object[][]
                {new Object[]{}, new Object[]{3, 2, 3}})); //0
        System.out.println(getLengthOfMissingArray(new Object[][]
                {new Object[]{4, 0, 4, 2, 3, 2}, new Object[]{0, 3, 1, 3, 4, 0, 3, 1, 2, 2},
                        new Object[]{0, 3, 1, 0, 1}, new Object[]{1, 2, 3}, new Object[]{3, 3, 3, 2, 3, 4, 4},
                        new Object[]{1, 4, 2, 1, 0, 3, 3, 0}, new Object[]{1, 2, 0, 0, 3, 2, 4, 2, 1, 3, 0, 0},
                        new Object[]{2, 3, 3, 2}, new Object[]{3, 1, 2, 4, 1, 1, 2, 0, 2, 1, 3, 3, 0, 1},
                        new Object[]{0, 4, 1, 3, 0, 3, 4, 0, 3, 0, 0}, new Object[]{1, 0, 0, 2, 0, 2, 2, 2, 0, 1, 4, 4, 3}})); //9
        System.out.println("______________________________________");

        System.out.println(getLengthOfMissingArray2(new Object[][]
                {new Object[]{1, 2}, new Object[]{4, 5, 1, 1}, new Object[]{1}, new Object[]{5, 6, 7, 8, 9}})); //3
        System.out.println(getLengthOfMissingArray2(new Object[][]
                {new Object[]{5, 2, 9}, new Object[]{4, 5, 1, 1}, new Object[]{1}, new Object[]{5, 6, 7, 8, 9}})); //2
        System.out.println(getLengthOfMissingArray2(new Object[][]
                {new Object[]{'a', 'a', 'a'}, new Object[]{'a', 'a'}, new Object[]{'a', 'a', 'a', 'a'},
                        new Object[]{'a'}, new Object[]{'a', 'a', 'a', 'a', 'a', 'a'}})); //5
        System.out.println(getLengthOfMissingArray2(new Object[][]
                {new Object[]{null}, new Object[]{null, null, null}})); //2
        System.out.println(getLengthOfMissingArray2(new Object[][]
                {new Object[]{}, new Object[]{3, 2, 3}})); //0
        System.out.println(getLengthOfMissingArray2(new Object[][]
                {new Object[]{4, 0, 4, 2, 3, 2}, new Object[]{0, 3, 1, 3, 4, 0, 3, 1, 2, 2},
                        new Object[]{0, 3, 1, 0, 1}, new Object[]{1, 2, 3}, new Object[]{3, 3, 3, 2, 3, 4, 4},
                        new Object[]{1, 4, 2, 1, 0, 3, 3, 0}, new Object[]{1, 2, 0, 0, 3, 2, 4, 2, 1, 3, 0, 0},
                        new Object[]{2, 3, 3, 2}, new Object[]{3, 1, 2, 4, 1, 1, 2, 0, 2, 1, 3, 3, 0, 1},
                        new Object[]{0, 4, 1, 3, 0, 3, 4, 0, 3, 0, 0}, new Object[]{1, 0, 0, 2, 0, 2, 2, 2, 0, 1, 4, 4, 3}})); //9
    }

    public static int getLengthOfMissingArray(Object[][] arrayOfArrays) {
        if (arrayOfArrays == null || arrayOfArrays.length == 0) {
            return 0;
        }

        int missingArrLength = 0;

        List<Integer> list = new ArrayList<>();

        for (Object[] array : arrayOfArrays) {
            if (array == null || array.length == 0) {
                return 0;
            }

            list.add(array.length);
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) + 1 != list.get(i + 1)) {
                missingArrLength = list.get(i) + 1;
                break;
            }
        }

        return missingArrLength;
    }

    public static int getLengthOfMissingArray2(Object[][] arrayOfArrays) {
        if (arrayOfArrays == null || arrayOfArrays.length == 0) {
            return 0;
        }

        TreeSet<Integer> tree = new TreeSet<>();

        for (Object[] array : arrayOfArrays) {
            if (array == null || array.length == 0) {
                return 0;
            }
            tree.add(array.length);
        }

        Iterator<Integer> it = tree.iterator();
        int nextSeq = it.next() + 1;

        while (it.hasNext()) {
            int seq = it.next();
            if (seq != nextSeq) {
                return nextSeq;
            }
            nextSeq = seq + 1;
        }

        return 0;
    }
}
