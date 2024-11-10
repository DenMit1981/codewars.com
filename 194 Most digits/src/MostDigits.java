//Find the number with the most digits.
//If two numbers in the argument array have the same number of digits, return the first number in the array.

public class MostDigits {
    public static void main(String[] args) {
        System.out.println(findLongest(new int[]{9000, 8, 800})); //9000
        System.out.println(findLongest(new int[]{8, 900, 500})); //900
        System.out.println(findLongest(new int[]{3, 40000, 100})); //40000
        System.out.println(findLongest(new int[]{1, 200, 100000})); //100000
        System.out.println(findLongest(new int[]{-10, 1, 0, 1, 10})); //-10
        System.out.println("_________");

        System.out.println(findLongest2(new int[]{9000, 8, 800})); //9000
        System.out.println(findLongest2(new int[]{8, 900, 500})); //900
        System.out.println(findLongest2(new int[]{3, 40000, 100})); //40000
        System.out.println(findLongest2(new int[]{1, 200, 100000})); //100000
        System.out.println(findLongest2(new int[]{-10, 1, 0, 1, 10})); //-10

    }

    public static int findLongest(int[] numbers) {
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (String.valueOf(Math.abs(numbers[i])).length() > String.valueOf(Math.abs(numbers[index])).length()) {
                index = i;
            }
        }
        return numbers[index];
    }

    public static int findLongest2(int[] numbers) {
        int mostDigitsIndex = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (getDigitsCount(numbers[i]) > getDigitsCount(numbers[mostDigitsIndex])) {
                mostDigitsIndex = i;

            }
        }

        return numbers[mostDigitsIndex];
    }

    private static int getDigitsCount(int number) {
        return String.valueOf(Math.abs(number)).length();
    }
}
