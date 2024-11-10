//Complete the solution so that the function splits camel case using spaces between words.
//Example
//"camelCasing" => "camel Casing"
//"identifier" => "identifier"
//"" => ""

public class Solution {
    public static void main(String[] args) {
        System.out.println(camelCase("camelCasingTest")); //camel Casing Test
        System.out.println(camelCase("camelcasingtest")); //camelcasingtest
    }

    public static String camelCase(String input) {
        StringBuilder sb = new StringBuilder();
        char[] c = input.toCharArray();

        for (char value : c) {
            if (value >= 'A' && value <= 'Z') {
                sb.append(" ").append(value);
            } else {
                sb.append(value);
            }
        }
        return sb.toString();
    }
}
