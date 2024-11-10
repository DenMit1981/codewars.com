//For this kata you will have to forget how to add two numbers.
//In simple terms, our method does not like the principle of carrying over numbers and just writes down every number
//it calculates :-)
//You may assume both integers are positive integers.
//You may assume both integers are positive integers and the result will not be bigger than Integer.MAX_VALUE

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SillyAdditon {
    public static void main(String[] args) {
        System.out.println(add(16, 18)); //214
        System.out.println(add(26, 39)); //515
        System.out.println(add(122, 81)); //1103
        System.out.println(add(2, 11)); //13
        System.out.println(add(0, 1)); //1
        System.out.println(add(0, 0)); //0
        System.out.println("______________________");

        System.out.println(add2(16, 18)); //214
        System.out.println(add2(26, 39)); //515
        System.out.println(add2(122, 81)); //1103
        System.out.println(add2(2, 11)); //13
        System.out.println(add2(0, 1)); //1
        System.out.println(add2(0, 0)); //0
    }

    public static int add(int num1, int num2) {
        StringBuilder str1 = new StringBuilder(String.valueOf(num1));
        StringBuilder str2 = new StringBuilder(String.valueOf(num2));

        // Pad the shorter string with leading zeros
        while (str1.length() < str2.length()) {
            str1.insert(0, "0");
        }
        while (str2.length() < str1.length()) {
            str2.insert(0, "0");
        }

        StringBuilder result = new StringBuilder();

        // Add corresponding digits
        for (int i = 0; i < str1.length(); i++) {
            int digit1 = str1.charAt(i) - '0'; // Convert char to int
            int digit2 = str2.charAt(i) - '0'; // Convert char to int
            int sum = digit1 + digit2;
            result.append(sum); // Append the sum of the digits
        }

        return Integer.parseInt(result.toString());
    }

    public static int add2(int num1, int num2) {
        StringBuilder str1 = new StringBuilder(String.valueOf(num1));
        StringBuilder str2 = new StringBuilder(String.valueOf(num2));

        while (str1.length() < str2.length()) {
            str1.insert(0, "0");
        }
        while (str2.length() < str1.length()) {
            str2.insert(0, "0");
        }

        String result = IntStream.range(0, str1.length())
                .mapToObj(i -> (str1.charAt(i) - '0') + (str2.charAt(i) - '0')) // Sum the digits
                .map(String::valueOf) // Convert to String
                .collect(Collectors.joining());
        //.reduce("", String::concat); // Concatenate the results

        return Integer.parseInt(result);
    }
}
