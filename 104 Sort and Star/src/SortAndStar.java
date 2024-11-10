//You will be given a vector of strings. You must sort it alphabetically
//(case sensitive and based on the ASCII values of the characters) and then return the first value.
//The return value must be a string and contain "***" between the letters.
//You must not remove or add elements from/to the array.

import java.util.Arrays;

public class SortAndStar {
    public static void main(String[] args) {
        System.out.println(twoSort(new String[]{"bitcoin", "take", "over", "the", "world",
                "maybe", "who", "knows", "perhaps"})); //"b***i***t***c***o***i***n"
        System.out.println(twoSort(new String[]{"turns", "out", "random", "test", "cases",
                "are", "easier", "than", "writing", "out", "basic", "ones"})); //"a***r***e"
    }

    public static String twoSort(String[] s) {
        if (s.length == 0) return null;
        Arrays.sort(s);
        StringBuilder sb = new StringBuilder(s[0].replace("", "***"));
        return sb.substring(3, sb.length() - 3);
    }
}





