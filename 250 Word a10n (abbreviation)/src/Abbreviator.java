//The word i18n is a common abbreviation of internationalization in the developer community, used instead of typing
//the whole word and trying to spell it correctly. Similarly, a11y is an abbreviation of accessibility.
//Write a function that takes a string and turns any and all "words" (see below) within that string of length 4 or
//greater into an abbreviation, following these rules:
//A "word" is a sequence of alphabetical characters. By this definition, any other character like a space or hyphen
//(eg. "elephant-ride") will split up a series of letters into two words (eg. "elephant" and "ride").
//The abbreviated version of the word should have the first letter, then the number of removed characters, then the
//last letter (eg. "elephant ride" => "e6t r2e").
//Example
//abbreviate("elephant-rides are really fun!")
////          ^^^^^^^^*^^^^^*^^^*^^^^^^*^^^*
//// words (^):   "elephant" "rides" "are" "really" "fun"
////                123456     123     1     1234     1
//// ignore short words:               X              X
//
//// abbreviate:    "e6t"     "r3s"  "are"  "r4y"   "fun"
//// all non-word characters (*) remain in place
////                     "-"      " "    " "     " "     "!"
//=== "e6t-r3s are r4y fun!"

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Abbreviator {
    public static void main(String[] args) {
        System.out.println(abbreviate("internationalization")); //"i18n"
        System.out.println(abbreviate("elephant-rides are really fun!")); //"e6t-r3s are r4y fun!"
        System.out.println("________________________");

        System.out.println(abbreviate2("internationalization")); //"i18n"
        System.out.println(abbreviate2("elephant-rides are really fun!")); //"e6t-r3s are r4y fun!"
        System.out.println("________________________");

        System.out.println(abbreviate3("internationalization")); //"i18n"
        System.out.println(abbreviate3("elephant-rides are really fun!")); //"e6t-r3s are r4y fun!"
    }

    public static String abbreviate(String string) {
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (char c : string.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(c);
            } else {
                if (word.length() > 3) {
                    result.append(word.charAt(0)).append(word.length() - 2).append(word.charAt(word.length() - 1));
                } else if (word.length() > 0) {
                    result.append(word);
                }
                result.append(c);
                word.setLength(0); // Reset word
            }
        }
        // Handle the last word if any
        if (word.length() > 3) {
            result.append(word.charAt(0)).append(word.length() - 2).append(word.charAt(word.length() - 1));
        } else if (word.length() > 0) {
            result.append(word);
        }

        return result.toString();
    }

    public static String abbreviate2(String string) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+|[^a-zA-Z]"); // Match words or non-word characters

        return pattern.matcher(string).results()
                .map(match -> {
                    String group = match.group();
                    if (group.matches("[a-zA-Z]+") && group.length() > 3) {
                        return group.charAt(0) + String.valueOf(group.length() - 2) + group.charAt(group.length() - 1);
                    } else {
                        return group;
                    }
                })
                .collect(Collectors.joining());
    }

    public static String abbreviate3(String string) {
        String[] parts = string.split("(?<=[^a-zA-Z])|(?=[^a-zA-Z])"); // Split on non-alphabetic characters
        StringBuilder result = new StringBuilder();

        for (String part : parts) {
            if (part.matches("[a-zA-Z]+") && part.length() > 3) {
                result.append(part.charAt(0)).append(part.length() - 2).append(part.charAt(part.length() - 1));
            } else {
                result.append(part);
            }
        }

        return result.toString();
    }
}
