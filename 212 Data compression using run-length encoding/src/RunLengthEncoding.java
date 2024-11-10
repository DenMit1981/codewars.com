//Run-length encoding (RLE) is a very simple form of lossless data compression in which runs of data are stored
//as a single value and data count.
//A simple form of RLE encodes the string "AAABBBCCCD" as "3A3B3C1D", meaning that there are 3 A's first, then 3 B's,
//then 3 C's, and finally 1 D.
//Your task is to write an RLE encoder and decoder using this technique. The encoded text will always consist
//of uppercase characters only and no numbers.

import java.util.regex.Pattern;

public class RunLengthEncoding {

    private static final Pattern ENCODE_PATTERN = Pattern.compile("(.)\\1*");
    private static final Pattern DECODE_PATTERN = Pattern.compile("(\\d+)(.)");

    public static void main(String[] args) {
        System.out.println(encode("A")); //1A
        System.out.println(encode("AAA")); //3A
        System.out.println(encode("AAABBBCCCD")); //3A3B3C1D
        System.out.println(encode("AB")); //1A1B
        System.out.println(encode("AAABBBCCCA")); //3A3B3C1A

        System.out.println(decode("1A")); //A
        System.out.println(decode("3A")); //AAA
        System.out.println(decode("3A3B3C1D")); //AAABBBCCCD
        System.out.println(decode("1A1B")); //AB
        System.out.println(decode("3A3B3C1A")); //AAABBBCCCA
        System.out.println("__________");

        System.out.println(encode2("A")); //1A
        System.out.println(encode2("AAA")); //3A
        System.out.println(encode2("AAABBBCCCD")); //3A3B3C1D
        System.out.println(encode2("AB")); //1A1B
        System.out.println(encode2("AAABBBCCCA")); //3A3B3C1A

        System.out.println(decode2("1A")); //A
        System.out.println(decode2("3A")); //AAA
        System.out.println(decode2("3A3B3C1D")); //AAABBBCCCD
        System.out.println(decode2("1A1B")); //AB
        System.out.println(decode2("3A3B3C1A")); //AAABBBCCCA
        System.out.println("__________");

        System.out.println(encode3("A")); //1A
        System.out.println(encode3("AAA")); //3A
        System.out.println(encode3("AAABBBCCCD")); //3A3B3C1D
        System.out.println(encode3("AB")); //1A1B
        System.out.println(encode3("AAABBBCCCA")); //3A3B3C1A

        System.out.println(decode3("1A")); //A
        System.out.println(decode3("3A")); //AAA
        System.out.println(decode3("3A3B3C1D")); //AAABBBCCCD
        System.out.println(decode3("1A1B")); //AB
        System.out.println(decode3("3A3B3C1A")); //AAABBBCCCA
        System.out.println("__________");

        System.out.println(encode4("A")); //1A
        System.out.println(encode4("AAA")); //3A
        System.out.println(encode4("AAABBBCCCD")); //3A3B3C1D
        System.out.println(encode4("AB")); //1A1B
        System.out.println(encode4("AAABBBCCCA")); //3A3B3C1A

        System.out.println(decode4("1A")); //A
        System.out.println(decode4("3A")); //AAA
        System.out.println(decode4("3A3B3C1D")); //AAABBBCCCD
        System.out.println(decode4("1A1B")); //AB
        System.out.println(decode4("3A3B3C1A")); //AAABBBCCCA
    }

    public static String encode(String s) {
        char[] letters = s.toCharArray();
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 1, j = 0; i <= n; i++) {
            if (i == n || letters[i] != letters[i - 1]) {
                sb.append(i - j).append(letters[j]);
                j = i;
            }
        }
        return sb.toString();
    }

    public static String decode(String s) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                sum = sum * 10 + (c - '0');
            } else {
                sb.append(("" + c).repeat(sum));
                sum = 0;
            }
        }
        return sb.toString();
    }

    public static String encode2(String input) {
        StringBuilder encoded = new StringBuilder();
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                encoded.append(count);
                encoded.append(input.charAt(i - 1));
                count = 1;
            }
        }

        encoded.append(count);
        encoded.append(input.charAt(input.length() - 1));

        return encoded.toString();
    }

    public static String decode2(String input) {
        StringBuilder decoded = new StringBuilder();
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (Character.isDigit(currentChar)) {
                count = count * 10 + (currentChar - '0');
            } else {
                decoded.append(String.valueOf(currentChar).repeat(Math.max(0, count)));
                count = 0;
            }
        }

        return decoded.toString();
    }

    public static String encode3(String input) {
        return ENCODE_PATTERN.matcher(input).replaceAll(result -> result.group().length() + result.group(1));
    }

    public static String decode3(String input) {
        return DECODE_PATTERN.matcher(input).replaceAll(result -> result.group(2).repeat(Integer.parseInt(result.group(1))));
    }

    public static String encode4(String input) {
        StringBuilder encoded = new StringBuilder();
        String[] chars = input.split("");
        int count = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i].equals(chars[i - 1]))
                count++;
            else {
                encoded.append(count).append(chars[i - 1]);
                count = 1;
            }
        }
        encoded.append(count).append(chars[chars.length - 1]);

        return encoded.toString();
    }

    public static String decode4(String input) {
        StringBuilder decoded = new StringBuilder();
        String[] chars = input.split("");
        StringBuilder count = new StringBuilder();

        for (String elem : chars) {
            if (elem.matches("[0-9]"))
                count.append(elem);
            if (elem.matches("[a-zA-Z]")) {
                decoded.append(elem.repeat(Integer.parseInt(count.toString())));
                count = new StringBuilder();
            }
        }

        return decoded.toString();
    }
}
