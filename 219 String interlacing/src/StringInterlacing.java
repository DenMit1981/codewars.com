//Given two strings of any value of any length, return a resulting string of alternating characters from one and
//the other.
//Example with strings of the same size: Given the strings "Hello" and "World", the resulting string is "HWeolrllod".
//In this case, the first character of the result must be the first character of the first parameter of the function.
//When using strings of different sizes, repeat the mixing to the end of the larger string, repeating the characters of
//the smaller one.
//Example: Given the strings "Drink" and "beer", the result is "Dbreienrkbienegr". When using strings of different
//size, the result must start with the first character of the larger of them.
//The result must always end with a character of a different string value than the one used at the beginning of the
//result value.
//Spaces are not taken into account even when calculating the sizes of strings ("abcd" is greater than "a b c").
//Example: Given the strings "Bike" and "city", the result must be "tBhiekciintgyB".

public class StringInterlacing {
    public static void main(String[] args) {
        System.out.println(interlace("Hello", "World")); //HWeolrllod
        System.out.println(interlace("Gimme", "some lovin'")); //sGoimmemleoGviimnm'e

        System.out.println(interlace2("Hello", "World")); //HWeolrllod
        System.out.println(interlace2("Gimme", "some lovin'")); //sGoimmemleoGviimnm'e
    }

    public static String interlace(final String first, final String second) {
        char[] f2 = first.replaceAll(" ", "").toCharArray();
        char[] s2 = second.replaceAll(" ", "").toCharArray();

        if (f2.length < s2.length) {
            return interlacing(s2, f2);
        }

        return interlacing(f2, s2);
    }

    private static String interlacing(char[] one, char[] two) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;

        for (char c : one) {
            sb.append(c);
            sb.append(two[counter % two.length]);
            counter++;
        }

        return sb.toString();
    }

    public static String interlace2(final String firstIn, final String secondIn) {
        String first = firstIn.replaceAll(" ", "");
        String second = secondIn.replaceAll(" ", "");
        if (second.length() > first.length()) {
            return interlace(second, first);
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < first.length(); i++) {
            s.append(first.charAt(i));
            s.append(second.charAt(i % second.length()));
        }
        return s.toString();
    }
}
