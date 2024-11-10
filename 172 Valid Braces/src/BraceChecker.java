//Write a function that takes a string of curly braces and determines whether the order of the curly braces is valid.
//It should return true if the string is valid and false if it is invalid.
//This Kata is similar to Kata Valid Parentheses, but introduces new characters: square brackets [] and curly braces {}.
//All input strings will be non-empty and will consist only of parentheses, square brackets, and curly braces: ()[]{}.
//What is considered valid?
//A string of curly braces is considered valid if all the curly braces match a valid curly brace.
//Examples
//"(){}[]" => True
//"([{}])" => True
//"(}" => False
//"[(])" => False
//"[({})](]" => False

public class BraceChecker {

    public static void main(String[] args) {

        System.out.println(isValid("()")); //true
        System.out.println(isValid("(){}[]")); //true
        System.out.println(isValid("([{}])")); //true
        System.out.println(isValid("(}")); //false
        System.out.println(isValid("[(])")); //false
        System.out.println(isValid("[({})](]")); //false
        System.out.println("______________");

        System.out.println(isValid2("()")); //true
        System.out.println(isValid2("(){}[]")); //true
        System.out.println(isValid2("([{}])")); //true
        System.out.println(isValid2("(}")); //false
        System.out.println(isValid2("[(])")); //false
        System.out.println(isValid2("[({})](]")); //false
    }

    public static boolean isValid(String s) {
        int x = s.length();

        s = s.replaceAll("\\(\\)|\\[\\]|\\{\\}", "");

        return s.length() != x && (s.length() == 0 || isValid(s));
    }

    public static boolean isValid2(String braces) {
        String b = braces;

        for (int i = 0; i < braces.length() / 2; i++) {
            b = b.replaceAll("\\(\\)", "");
            b = b.replaceAll("\\[\\]", "");
            b = b.replaceAll("\\{\\}", "");
            if (b.length() == 0)
                return true;
        }

        return false;
    }


}
