//Write a method that takes one argument as a name, and then greets that name, capitalizing it and ending with an
//exclamation point.
//Example:
//"riley" --> "Hello Riley!"
//"JACK" --> "Hello Jack!"

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GreetMe {

    public static void main(String[] args) {
        System.out.println(greet("riley"));
        System.out.println(greet("JACK"));

        System.out.println(greetByStream("riley"));
        System.out.println(greetByStream("JACK"));

        System.out.println(greetByStream2("riley"));
        System.out.println(greetByStream2("JACK"));
    }

    public static String greet(String name) {
        return "Hello " +
                name.substring(0, 1).toUpperCase() +
                name.substring(1).toLowerCase() +
                "!";
    }

    public static String greetByStream(String name) {
        return Arrays.stream(getCapitalizeName(name).split(""))
                .collect(Collectors.joining("", "Hello ", "!"));
    }

    private static String getCapitalizeName(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    public static String greetByStream2(String name) {
        return Stream.of(Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase())
                .collect(Collectors.joining("", "Hello ", "!"));
    }
}
