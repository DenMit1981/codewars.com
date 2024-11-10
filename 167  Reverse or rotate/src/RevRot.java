//The input is a string str of digits. Cut the string into chunks (here a chunk is a substring of the original string)
//of size sz (ignore the last chunk if its size is smaller than sz).
//If a chunk is an integer, such that the sum of the cubes of its digits is divisible by 2, reverse the chunk;
//otherwise, rotate it left by one position. Concatenate these modified chunks and
//return the result as a string.
//If sz <= 0 or if the string is empty, return ""
//sz is greater (>) than the length of str, it is impossible to take a chunk of size sz, so return "".
//Examples:
//revrot("123456987654", 6) --> "234561876549"
//revrot("123456987653", 6) --> "234561356789"
//revrot("66443875", 4) --> "44668753"
//revrot("66443875", 8) --> "64438756"
//revrot("664438769", 8) --> "67834466"
//revrot("123456779", 8) --> "23456771"
//revrot("", 8) --> ""
//revrot("123456779", 0) --> ""
//revrot("563000655734469485", 4) --> "0365065073456944"
//Пример строки, повернутой влево на одну позицию:
//s = "123456" дает "234561".

import java.util.Arrays;

public class RevRot {

    public static void main(String[] args) {
        System.out.println(revRot("123456987654", 6)); //"234561876549"
        System.out.println(revRot("66443875", 4)); //"44668753"
        System.out.println(revRot("1234", 0)); //""
        System.out.println(revRot("563000655734469485", 4)); //"0365065073456944"
        System.out.println(revRot("", 8)); //""
        System.out.println(revRot("733049910872815764", 5)); //"330479108928157"
    }

    public static String revRot(String str, int sz) {
        if (sz <= 0 || str == null || "".equals(str) || sz > str.length()) {
            return "";
        }

        StringBuilder[] sb = new StringBuilder[str.length() / sz];

        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
            for (int j = 0; j < sz; j++) {
                sb[i].append(str.charAt(j + i * sz));
            }
        }

        for (int i = 0; i < sb.length; i++) {
            if (RevRot.divisible(sb[i])) {
                sb[i] = sb[i].reverse();
            } else {
                sb[i] = new StringBuilder(RevRot.rotate(sb[i]));
            }
        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder x : sb) {
            result.append(x);
        }

        return result.toString();
    }

    private static boolean divisible(StringBuilder sb) {
        long sum = 0;

        for (int i = 0; i < sb.length(); i++) {
            sum += Math.pow(sb.charAt(i), 3);
        }

        return sum % 2 == 0;

    }

    private static String rotate(StringBuilder sb) {
        sb.append(sb.charAt(0));
        sb.deleteCharAt(0);

        return sb.toString();
    }
}
