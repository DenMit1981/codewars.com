//Given an integer as input, can you round it to the next (i.e. "higher") multiple of 5?
//Examples:
//Input, output:
//0 -> 0
//2 -> 5
//3 -> 5
//12 -> 15
//21 -> 25
//30 -> 30
//-2 -> 0
//-5 -> -5
//etc.
//The input can be any positive or negative integer (including 0).
//You can assume that all inputs are valid integers.

public class RoundToTheNextMultipleOf5 {
    public static void main(String[] args) {
        System.out.println(roundToNext5(0)); //0
        System.out.println(roundToNext5(2)); //5
        System.out.println(roundToNext5(3)); //5
        System.out.println(roundToNext5(12)); //15
        System.out.println(roundToNext5(21)); //25
        System.out.println(roundToNext5(30)); //30
        System.out.println(roundToNext5(-2)); //0
        System.out.println(roundToNext5(-5)); //-5
    }

    public static int roundToNext5(int number) {
        while (number % 5 != 0) {
            number++;
        }
        return number;
    }
}
