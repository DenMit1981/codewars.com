//Write a function
//TripleDouble(long num1, long num2)
//which takes numbers num1 and num2 and returns 1 if there is a straight triple of a number at any place in num1 and
//also a straight double of the same number in num2.
//If this isn't the case, return 0
//Examples
//TripleDouble(451999277, 41177722899) == 1 // num1 has straight triple 999s and
//                                          // num2 has straight double 99s
//TripleDouble(1222345, 12345) == 0 // num1 has straight triple 2s but num2 has only a single 2
//TripleDouble(12345, 12345) == 0
//TripleDouble(666789, 12345667) == 1

import java.util.*;

public class Kata {
    public static void main(String[] args) {
        System.out.println(tripleDouble(451999277L, 41177722899L)); //1
        System.out.println(tripleDouble(451999277L, 411777228L)); //0

        System.out.println(Arrays.toString(getSortedArrayFromNumber(451999277L))); //[1, 2, 4, 5, 7, 7, 9, 9, 9]
        System.out.println(getSetOfTripleNumbersFromNumberArray(getSortedArrayFromNumber(451999277L))); //[9]
        System.out.println(getSetOfDoubleNumbersFromNumberArray(getSortedArrayFromNumber(41177722899L))); //[1, 2, 7, 9]
    }

    public static int tripleDouble(long num1, long num2) {
        long[] firstNumArr = getSortedArrayFromNumber(num1);
        long[] secondNumArr = getSortedArrayFromNumber(num2);

        Set<Long> firstNumberSet = getSetOfTripleNumbersFromNumberArray(firstNumArr);
        Set<Long> secondNumberSet = getSetOfDoubleNumbersFromNumberArray(secondNumArr);

        if (secondNumberSet.stream().anyMatch(firstNumberSet::contains)) {
            return 1;
        } else {
            return 0;
        }
    }

    private static long[] getSortedArrayFromNumber(long number) {
        return Arrays.stream(String.valueOf(number)
                        .split(""))
                .mapToLong(Integer::valueOf)
                .sorted()
                .toArray();
    }

    private static Set<Long> getSetOfTripleNumbersFromNumberArray(long[] number) {
        Set<Long> resultSet = new HashSet<>();

        for (int i = 1; i < number.length - 1; i++) {
            if (number[i - 1] == number[i] && number[i] == number[i + 1]) {
                resultSet.add(number[i]);
            }
        }

        return resultSet;
    }

    private static Set<Long> getSetOfDoubleNumbersFromNumberArray(long[] number) {
        Set<Long> resultSet = new HashSet<>();

        for (int i = 1; i < number.length; i++) {
            if (number[i - 1] == number[i]) {
                resultSet.add(number[i]);
            }
        }

        return resultSet;
    }
}
