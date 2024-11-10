//Given a string that specifies a range of letters, return a string that includes all the letters in that range,
//including the last letter. Note: if the range is specified in uppercase, return the string in uppercase!
//Examples
//gimmeTheLetters("a-z") ➞ "abcdefghijklmnopqrstuvwxyz"
//gimmeTheLetters("h-o") ➞ "hijklmno"
//gimmeTheLetters("Q-Z") ➞ "QRSTUVWXYZ"
//gimmeTheLetters("J-J") ➞ "J"
//Notes
//The hyphen will separate two letters in the string.
//In this case, you don't need to worry about error handling (i.e. both letters will have the same case,
//and the second letter will always come after the first in alphabetical order).

public class Solution {
    public static void main(String[] args) {
        System.out.println(gimmeTheLetters("a-z")); //abcdefghijklmnopqrstuvwxyz
        System.out.println(gimmeTheLetters("h-o")); //hijklmno
        System.out.println(gimmeTheLetters("Q-Z")); //QRSTUVWXYZ
        System.out.println(gimmeTheLetters("J-J")); //J
    }

    public static String gimmeTheLetters(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c = s.charAt(0); c <= s.charAt(s.length() - 1); c++) {
            sb.append(c);
        }

        return sb.toString();
    }
}
