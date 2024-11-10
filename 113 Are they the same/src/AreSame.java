//Given two arrays a and b, write a function comp(a, b) (orcompSame(a, b)) that checks whether the two arrays have
//"the same" elements with the same multiplicities (the multiplicity of an element is the number of times it appears).
//"The same" here means that the elements in b are the elements in the square, regardless of order.
//Examples
//Real arrays
//a = [121, 144, 19, 161, 19, 144, 19, 11]
//b = [121, 14641, 20736, 361, 25921, 361, 20736, 361]
//comp(a, b) returns true because in b 121 is the square of 11, 14641 is the square of 121, 20736 is the square of 144,
//361 is the square of 19, 25921 is the square of 161, and so on. This becomes obvious if we write the elements of
//b in terms of squares:

//a = [121, 144, 19, 161, 19, 144, 19, 11]
//b = [11*11, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19]
//Invalid arrays
//If, for example, we change the first number to something else, comp no longer returns true:
//
//a = [121, 144, 19, 161, 19, 144, 19, 11]
//b = [132, 14641, 20736, 361, 25921, 361, 20736, 361]
//comp(a,b) returns false because in b 132 is not a square of any a.
//
//a = [121, 144, 19, 161, 19, 144, 19, 11]
//b = [121, 14641, 20736, 36100, 25921, 361, 20736, 361]
//comp(a,b) returns false because in b 36100 is not a square of any a.
//
//Notes
//a or b can be [] or {} (all languages except R, Shell).
//a or b can be nil or null, None or nothing (except C++, COBOL, Crystal, D, Dart, Elixir, Fortran, F#, Haskell, Nim,
//OCaml, Pascal, Perl, PowerShell, Prolog, PureScript, R, Racket, Rust, Shell, Swift).
//If a or b is nil (or null or None, depending on the language), the problem does not make sense, so return false.
//
//Note for C
//The two arrays have the same size (> 0) specified as a parameter to the comp function.

import java.util.Arrays;

public class AreSame {
    public static void main(String[] args) {

        System.out.println(comp(new int[]{121, 144, 19, 161, 19, 144, 19, -11},
                new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361})); //true
        System.out.println(comp(new int[]{121, 144, 19, 161, 19, 144, 19, 11},
                new int[]{121, 14641, 20736, 362, 25921, 361, 20736, 361})); //false
        System.out.println(comp(null, new int[]{2})); //false
        System.out.println(comp(new int[]{2}, new int[]{4})); //false
        System.out.println(comp(new int[]{}, new int[]{1})); //false
        System.out.println(comp(new int[]{0, -14, 191, 161, 19, 144, 195, 1},
                new int[]{1, 0, 14 * 14, 191 * 191, 161 * 161, 19 * 19, 144 * 144, 195 * 195})); //true
        System.out.println("____________________________");

        System.out.println(comp2(new int[]{121, 144, 19, 161, 19, 144, 19, -11},
                new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361})); //true
        System.out.println(comp2(new int[]{121, 144, 19, 161, 19, 144, 19, 11},
                new int[]{121, 14641, 20736, 362, 25921, 361, 20736, 361})); //false
        System.out.println(comp2(null, new int[]{2})); //false
        System.out.println(comp2(new int[]{2}, new int[]{4})); //false
        System.out.println(comp2(new int[]{}, new int[]{1})); //false
        System.out.println(comp2(new int[]{0, -14, 191, 161, 19, 144, 195, 1},
                new int[]{1, 0, 14 * 14, 191 * 191, 161 * 161, 19 * 19, 144 * 144, 195 * 195})); //true
        System.out.println("____________________________");

        System.out.println(comp3(new int[]{121, 144, 19, 161, 19, 144, 19, -11},
                new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361})); //true
        System.out.println(comp3(new int[]{121, 144, 19, 161, 19, 144, 19, 11},
                new int[]{121, 14641, 20736, 362, 25921, 361, 20736, 361})); //false
        System.out.println(comp3(null, new int[]{2})); //false
        System.out.println(comp3(new int[]{2}, new int[]{4})); //false
        System.out.println(comp3(new int[]{}, new int[]{1})); //false
        System.out.println(comp3(new int[]{0, -14, 191, 161, 19, 144, 195, 1},
                new int[]{1, 0, 14 * 14, 191 * 191, 161 * 161, 19 * 19, 144 * 144, 195 * 195})); //true
    }

    public static boolean comp(int[] a, int[] b) {
        if ((a == null) || (b == null)) return false;

        int[] aa = Arrays.stream(a).map(n -> n * n).toArray();

        Arrays.sort(aa);
        Arrays.sort(b);

        return (Arrays.equals(aa, b));
    }

    public static boolean comp1(final int[] a, final int[] b) {
        return a != null && b != null && a.length == b.length &&
                Arrays.equals(
                        Arrays.stream(a).map(i -> i * i).sorted().toArray(),
                        Arrays.stream(b).sorted().toArray()
                );
    }

    public static boolean comp2(int[] a, int[] b) {
        if ((a == null) || (b == null)) return false;

        int[] aa = Arrays.stream(a).map(n -> n * n).toArray();

        Arrays.sort(aa);
        Arrays.sort(b);

        return (Arrays.equals(aa, b));
    }

    public static boolean comp3(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) {
            return false;
        }

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < a.length; i++) {
            if (b[i] != Math.abs(a[i] * a[i])) {
                return false;
            }
        }
        return true;
    }
}
