//Multiply two integers, but take care of overflow. If the result cannot be stored exactly in an int,
//throw an ArithmeticException.

public class Multiplier {
    public static void main(String[] args) {
        System.out.println(multiply(-34, 56)); //-1904
        System.out.println(multiply(39650, 54161)); //ArithmeticException
        System.out.println(multiply(Integer.MAX_VALUE, Integer.MIN_VALUE)); //ArithmeticException
        System.out.println(multiply(-32768, 65536)); //-2147483648
    }

    public static int multiply(int a, int b) {
        if ((long) a * b > Integer.MAX_VALUE || (long) a * b < Integer.MIN_VALUE) {
            throw new ArithmeticException();
        }
        return a * b;
    }
}
