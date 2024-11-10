//Write a function that converts any sentence into a V A P O R W A V E sentence. a V A P O R W A V E sentence
// converts all the letters into uppercase, and adds 2 spaces between each letter (or special character) to create
//this V A P O R W A V E effect.
//Note that spaces should be ignored in this case.
//Examples
//"Lets go to the movies"       -->  "L  E  T  S  G  O  T  O  T  H  E  M  O  V  I  E  S"
//"Why isn't my code working?"  -->  "W  H  Y  I  S  N  '  T  M  Y  C  O  D  E  W  O  R  K  I  N  G  ?"

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(vaporcode("Lets go to the movies")); //"L  E  T  S  G  O  T  O  T  H  E  M  O  V  I  E  S"
        System.out.println(vaporcode("Why isn't my code working?")); //"W  H  Y  I  S  N  '  T  M  Y  C  O  D  E  W  O  R  K  I  N  G  ?"
        System.out.println("________________________________");

        System.out.println(vaporcode2("Lets go to the movies")); //"L  E  T  S  G  O  T  O  T  H  E  M  O  V  I  E  S"
        System.out.println(vaporcode2("Why isn't my code working?")); //"W  H  Y  I  S  N  '  T  M  Y  C  O  D  E  W  O  R  K  I  N  G  ?"
    }

    public static String vaporcode(String s) {
        return String.join("  ", s.replaceAll(" ", "").toUpperCase().split(""));
    }

    public static String vaporcode2(String s) {
        return Arrays.stream(s.replaceAll(" ", "").toUpperCase().split("")).collect(Collectors.joining("  "));
    }
}
