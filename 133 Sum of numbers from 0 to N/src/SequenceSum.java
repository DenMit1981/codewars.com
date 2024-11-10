//We want to generate a function that calculates a series starting from 0 and ending with a given number
//Example:
//Input:
//> 6
//Output:
//0+1+2+3+4+5+6 = 21
//Input:
//> -15
//Output:
//-15<0
//Input:
//> 0
//Output:
//0=0

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SequenceSum {
    public static void main(String[] args) {
        System.out.println(showSequence(6));
        System.out.println(showSequence(-15));
        System.out.println(showSequence(0));
        System.out.println();

        System.out.println(showSequence2(6));
        System.out.println(showSequence2(-15));
        System.out.println(showSequence2(0));
        System.out.println();

        System.out.println(showSequence3(6));
        System.out.println(showSequence3(-15));
        System.out.println(showSequence3(0));
    }

    public static String showSequence(int value) {
        if (value <= 0) return value == 0 ? "0=0" : value + "<0";

        StringBuilder sb = new StringBuilder();
        int sum = 0;

        for (int i = 0; i <= value; i++) {
            sum += i;
            sb.append(i).append("+");
        }

        return sb.substring(0, sb.length() - 1) + " = " + sum;
    }

    public static String showSequence2(int value) {
        if (value <= 0) return value == 0 ? "0=0" : value + "<0";

        return getExpression(value) + " = " + sumOfSequence(value);
    }

    private static String getExpression(int value) {
        return IntStream.range(0, value + 1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("+"));
    }

    private static int sumOfSequence(int value) {
        return IntStream.range(0, value + 1).sum();
    }

    public static String showSequence3(int value) {
        if (value < 0) {
            return value + "<0";
        }
        if (value == 0) {
            return "0=0";
        }
        String expression = IntStream.range(0, value + 1).mapToObj(String::valueOf)
                .collect(Collectors.joining("+"));

        int result = IntStream.range(0, value + 1).sum();

        return expression + " = " + result;
    }
}
