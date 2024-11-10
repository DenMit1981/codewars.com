//Implement a pseudo-encryption algorithm which given a string S and an integer N concatenates all the odd-indexed
//characters of S with all the even-indexed characters of S, this process should be repeated N times.
//Examples:
//encrypt("012345", 1)  =>  "135024"
//encrypt("012345", 2)  =>  "135024"  ->  "304152"
//encrypt("012345", 3)  =>  "135024"  ->  "304152"  ->  "012345"
//
//encrypt("01234", 1)  =>  "13024"
//encrypt("01234", 2)  =>  "13024"  ->  "32104"
//encrypt("01234", 3)  =>  "13024"  ->  "32104"  ->  "20314"
//Together with the encryption function, you should also implement a decryption function which reverses the process.
//If the string S is an empty value or the integer N is not positive, return the first argument without changes.

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Kata {
    public static void main(String[] args) {
        System.out.println(encrypt("012345", 1)); //135024
        System.out.println(encrypt("012345", 2)); //304152
        System.out.println(encrypt("012345", 3)); //012345
        System.out.println(encrypt("01234", 1)); //13024
        System.out.println(encrypt("01234", 2)); //32104
        System.out.println(encrypt("01234", 3)); //20314
        System.out.println(decrypt("This is a test!", 0)); //"This is a test!"
        System.out.println(decrypt("hsi  etTi sats!", 1)); //"This is a test!"
        System.out.println(decrypt(" Tah itse sits!", 3)); //"This is a test!"
        System.out.println(decrypt("This is a test!", -1)); //"This is a test!"
        System.out.println(decrypt("hskt svr neetn!Ti aai eyitrsig", 1)); //"This kata is very interesting!"
        System.out.println("_____________________-");

        System.out.println(encrypt2("012345", 1)); //135024
        System.out.println(encrypt2("012345", 2)); //304152
        System.out.println(encrypt2("012345", 3)); //012345
        System.out.println(encrypt2("01234", 1)); //13024
        System.out.println(encrypt2("01234", 2)); //32104
        System.out.println(encrypt2("01234", 3)); //20314
        System.out.println(decrypt2("This is a test!", 0)); //"This is a test!"
        System.out.println(decrypt2("hsi  etTi sats!", 1)); //"This is a test!"
        System.out.println(decrypt2(" Tah itse sits!", 3)); //"This is a test!"
        System.out.println(decrypt2("This is a test!", -1)); //"This is a test!"
        System.out.println(decrypt2("hskt svr neetn!Ti aai eyitrsig", 1)); //"This kata is very interesting!"
    }

    public static String encrypt(String s, int n) {
        if (s == null || s.isEmpty() || n <= 0) {
            return s;
        }

        for (int i = 0; i < n; i++) {
            final String temp = s; // Needed for lambda
            String odd = IntStream.range(0, s.length())
                    .filter(j -> j % 2 != 0)
                    .mapToObj(j -> String.valueOf(temp.charAt(j)))
                    .collect(Collectors.joining());
            String even = IntStream.range(0, s.length())
                    .filter(j -> j % 2 == 0)
                    .mapToObj(j -> String.valueOf(temp.charAt(j)))
                    .collect(Collectors.joining());
            s = odd + even;
        }
        return s;
    }

    public static String decrypt(final String text, final int n) {
        if (text == null || n < 1) {
            return text;
        }

        String decrypted = IntStream.range(0, text.length())
                .mapToObj(i -> (i % 2 == 1) ? text.charAt(i / 2) : text.charAt(text.length() / 2 + i / 2))
                .map(Object::toString)
                .collect(Collectors.joining(""));
        return decrypt(decrypted, n - 1);
    }

    public static String encrypt2(String text, int n) {
        if (text == null || text.isEmpty() || n <= 0) {
            return text;
        }

        String result = text;
        for (int i = 0; i < n; i++) {
            result = performEncryption(result);
        }
        return result;
    }

    public static String decrypt2(final String encryptedText, int n) {
        if (n <= 0 || encryptedText == null || encryptedText.isEmpty()) {
            return encryptedText;
        }

        StringBuilder text = new StringBuilder();
        final int half = encryptedText.length() / 2;
        for (int i = 0; i < half; i++) {
            text.append(encryptedText.charAt(half + i)).append(encryptedText.charAt(i));
        }
        if (encryptedText.length() % 2 == 1) {
            text.append(encryptedText.charAt(encryptedText.length() - 1));
        }

        return decrypt2(text.toString(), --n);
    }

    private static String performEncryption(String s) {
        StringBuilder oddIndexed = new StringBuilder();
        StringBuilder evenIndexed = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                evenIndexed.append(s.charAt(i));
            } else {
                oddIndexed.append(s.charAt(i));
            }
        }

        return oddIndexed + evenIndexed.toString();
    }
}

