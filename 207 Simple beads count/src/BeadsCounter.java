//Between two blue beads, place two red beads. There are N blue beads. Looking at the arrangement below,
//count the number of red beads.
//@ @@ @ @@ @ @@ @ @@ @ @@ @
//Implement count_red_beads(n) (in PHP count_red_beads($n); in Java, Javascript, TypeScript, C, C++ countRedBeads(n))
//so that it returns the number of red beads.
//If there are less than two blue beads, return 0.

import java.math.BigInteger;

public class BeadsCounter {
    public static void main(String[] args) {
        System.out.println(countRedBeads(5)); //8
        System.out.println(countRedBeads(6)); //10
        System.out.println(countRedBeads(1)); //0
        System.out.println(countRedBeads(3)); //4
        System.out.println("_____________________");

        System.out.println(countRedBeads2(5)); //8
        System.out.println(countRedBeads2(6)); //10
        System.out.println(countRedBeads2(1)); //0
        System.out.println(countRedBeads2(3)); //4
    }

    public static int countRedBeads(final int nBlue) {
        if (nBlue < 2) {
            return 0;
        }
        int count = 0;

        for (int i = 1; i < nBlue; i++) {
            count += 2;
        }

        return count;
    }

    public static BigInteger countRedBeads2(final int nBlue) {
        if (nBlue < 2) {
            return BigInteger.valueOf(0);
        }
        BigInteger count = BigInteger.valueOf(0);

        for (int i = 1; i < nBlue; i++) {
            count = count.add(BigInteger.valueOf(2));
        }

        return count;
    }
}
