//Write a number in expanded form
//You will be given a number and you will need to return it as a string in expanded form. For example:
//Kata.expandedForm(12); # Should return "10 + 2"
//Kata.expandedForm(42); # Should return "40 + 2"
//Kata.expandedForm(70304); # Should return "70000 + 300 + 4"
//NOTE: All numbers will be integers greater than 0.

import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Kata {
    public static void main(String[] args) {
        System.out.println(expandedForm(70304)); //70000 + 300 + 4
        System.out.println(expandedForm(12)); //10 + 2
        System.out.println(expandedForm(42)); //40 + 2
        System.out.println(expandedForm(4982340)); //4000000 + 900000 + 80000 + 2000 + 300 + 40
        System.out.println("_______________________");

        System.out.println(expandedForm2(70304)); //70000 + 300 + 4
        System.out.println(expandedForm2(12)); //10 + 2
        System.out.println(expandedForm2(42)); //40 + 2
        System.out.println(expandedForm2(4982340)); //4000000 + 900000 + 80000 + 2000 + 300 + 40
        System.out.println("_______________________");

        System.out.println(expandedForm3(70304)); //70000 + 300 + 4
        System.out.println(expandedForm3(12)); //10 + 2
        System.out.println(expandedForm3(42)); //40 + 2
        System.out.println(expandedForm3(4982340)); //4000000 + 900000 + 80000 + 2000 + 300 + 40
    }

    public static String expandedForm(int num) {
        String[] reverseNums = new StringBuilder(String.valueOf(num)).reverse().toString().split("");

        return IntStream.range(0, reverseNums.length)
                .filter(i -> Integer.parseInt(String.valueOf((reverseNums[i]))) > 0)
                .mapToObj(i -> Integer.parseInt(String.valueOf(reverseNums[i])) * (int) Math.pow(10, i))
                .sorted(Collections.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(" + "));
    }

    public static String expandedForm2(int num) {
        StringBuilder res = new StringBuilder();
        int d = 1;
        while (num > 0) {
            int nextDigit = num % 10;
            num /= 10;
            if (nextDigit > 0) {
                res.insert(0, d * nextDigit);
                res.insert(0, " + ");
            }
            d *= 10;
        }
        return res.substring(3);
    }

    public static String expandedForm3(int num) {
        LinkedList<String> expandedList = new LinkedList<>();
        int digit;
        int multiplier = 1;
        while (num > 0) {
            digit = (num % 10) * multiplier;
            if (digit != 0) expandedList.push(Integer.toString(digit));
            num /= 10;
            multiplier *= 10;
        }
        return String.join(" + ", expandedList);
    }
}
