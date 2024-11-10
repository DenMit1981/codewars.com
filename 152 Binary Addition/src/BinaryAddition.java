/*Implement a function that adds two numbers and returns their sum in binary.
The conversion can be done before or after the addition.
The returned binary number must be a string.
Examples: (Input1, Input2 --> Output (explained)))
1, 1 --> "10" (1 + 1 = 2 in decimal, or 10 in binary)
5, 9 --> "1110" (5 + 9 = 14 in decimal, or 1110 in binary)*/

public class BinaryAddition {

    public static void main(String[] args) {
        System.out.println(binaryAddition(1, 1)); //10
        System.out.println(binaryAddition(5, 9)); //1110
        System.out.println(binaryAddition(1, 0)); //1
        System.out.println(binaryAddition(0, 1)); //1
        System.out.println(binaryAddition(2, 2)); //100
        System.out.println(binaryAddition(51, 12)); //111111
    }

    public static String binaryAddition(int a, int b) {
        return convertDecimalToBinary((a + b));
        //return convertDecimalToBinaryByStreamApi((a + b));
    }

    private static String convertDecimalToBinary(int decimalNum) {
        StringBuilder result = new StringBuilder();

        if (decimalNum == 0) {
            return "0";
        }

        while (decimalNum != 0) {
            result.append(decimalNum % 2);

            decimalNum /= 2;
        }

        return result.reverse().toString();
    }

    private static String convertDecimalToBinaryByStreamApi(int decimalNum) {
        return Integer.toBinaryString(decimalNum);
    }
}

