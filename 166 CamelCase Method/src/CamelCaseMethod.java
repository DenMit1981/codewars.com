//Write a simple .camelCase method for strings. All words must have a capital first letter with no spaces.
//For example:
//camelCase("hello case"); // => "HelloCase"
//camelCase("camel case word"); // => "CamelCaseWord"

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CamelCaseMethod {

    public static void main(String[] args) {
        System.out.println(camelCase("camel case method"));
        System.out.println(camelCase("ab  c"));
        System.out.println(camelCase("z"));
        System.out.println(camelCase("say hello "));
        System.out.println(camelCase(" camel case word"));
        System.out.println(camelCase(""));
        System.out.println(camelCase(" "));
        System.out.println("__________________");

        System.out.println(camelCaseByStream("camel case method"));
        System.out.println(camelCaseByStream("ab  c"));
        System.out.println(camelCaseByStream("z"));
        System.out.println(camelCaseByStream("say hello "));
        System.out.println(camelCaseByStream(" camel case word"));
        System.out.println(camelCaseByStream(""));
        System.out.println(camelCaseByStream(" "));
    }

    public static String camelCase(String str) {
        if (str.equals("") || str.equals(" ")) {
            return "";
        }

        String[] words = str.replaceAll(" +", " ").trim().split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            sb.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase());
        }

        return sb.toString();
    }

    public static String camelCaseByStream(String str) {
        if (str.equals("") || str.equals(" ")) {
            return "";
        }

        return Stream.of(str.replaceAll(" +", " ").trim().split(" "))
                .map(s -> new StringBuilder().append(s.substring(0, 1).toUpperCase()).append(s.substring(1).toLowerCase()))
                .collect(Collectors.joining());
    }
}
