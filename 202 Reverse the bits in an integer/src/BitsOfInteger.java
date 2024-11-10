//Write a function that swaps the bits of an integer.
//For example, the number 417 in binary is 110100001. If you flip the binary code, you get 100001011,
//which is 267.
//We can assume that the number is not negative.

import java.math.BigInteger;

public class BitsOfInteger {
    public static void main(String[] args) {
        System.out.println(convertDecimalToBinary(417)); //1101100001
        System.out.println(convertDecimalToBinary(8)); //1000
        System.out.println(convertDecimalToBinary(20)); //10100
        System.out.println(convertDecimalToBinary(524518)); //10000000000011100110
        System.out.println("_____________________________");

        System.out.println(convertBinaryToDecimal(BigInteger.valueOf(11011))); //27
        System.out.println(convertBinaryToDecimal(BigInteger.valueOf(1000))); //8
        System.out.println(convertBinaryToDecimal(BigInteger.valueOf(10100))); //20
        System.out.println("_____________________________");

        System.out.println(reverseBits(417)); //267
        System.out.println(reverseBits(267)); //417
        System.out.println(reverseBits(0)); //0
        System.out.println(reverseBits(2017)); //1087
        System.out.println(reverseBits(1023)); //1023
        System.out.println(reverseBits(1024)); //1
    }

    public static int reverseBits(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(convertDecimalToBinary(n)).reverse();

        return convertBinaryToDecimal(new BigInteger(String.valueOf(sb)));
    }

    private static BigInteger convertDecimalToBinary(int decimalNum) {
        StringBuilder result = new StringBuilder();

        if (decimalNum == 0) {
            return BigInteger.valueOf(0);
        }

        while (decimalNum != 0) {
            result.append(decimalNum % 2);
            decimalNum /= 2;
        }
        return new BigInteger(result.reverse().toString());
    }

    private static int convertBinaryToDecimal(BigInteger binaryNum) {
        return new BigInteger(String.valueOf(binaryNum), 2).intValueExact();
    }
}
