//In this kata, you are asked to square each digit of a number and add them together.
//For example, if we run 9119 through the function, it will return 811181 because 9^2 is 81 and 1^2 is 1. (81-1-1-81)
//Example #2: Entering 765 will/should return 493625 because 7^2 is 49, 6^2 is 36, and 5^2 is 25. (49-36-25)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SquareDigit {
    public static void main(String[] args) {
        System.out.println(squareDigits(9119)); //811181
        System.out.println(squareDigits(765)); //493625

        System.out.println(squareDigits2(9119)); //811181
        System.out.println(squareDigits2(765)); //493625
    }

    public static int squareDigits(int n) {
        StringBuilder sb = new StringBuilder();
        String[] digitArr = String.valueOf(n).split("");

        for (String digit : digitArr) {
            sb.append(Integer.parseInt(digit) * Integer.parseInt(digit));
        }
        return Integer.parseInt(sb.toString());
    }

    public static int squareDigits2(int n) {
        List<Integer> digList = new ArrayList();

        while (n > 0) {
            digList.add(n % 10);
            n /= 10;
        }
        Collections.reverse(digList);
        String squareDigitString = digList.stream()
                .map(el -> String.valueOf(el * el))
                .collect(Collectors.joining());

        return Integer.parseInt(squareDigitString);
    }
}
