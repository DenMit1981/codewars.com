//Filter the number
//The number has been mixed up with the text. Your goal is to retrieve the number from the text, can you return the
//number back to its original state?
//Task
//Your task is to return a number from a string.
//Details
//You will be given a string of numbers and letters mixed up, you have to return all the numbers in that string in
//the order they occur.

import java.util.Arrays;
import java.util.stream.Collectors;

public class Kata {
    public static void main(String[] args) {
        System.out.println(filterString("a1b2c3")); //123
        System.out.println(filterString("123")); //123
        System.out.println(filterString("aa1bb2cc3dd")); //123
    }

    public static long filterString(final String value) {
        return Long.parseLong(Arrays.stream(value.split(""))
                .filter(el -> el.matches("\\d"))
                .collect(Collectors.joining()));
    }
}
