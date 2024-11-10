//For this BINGO game, you will receive one array of 10 numbers from 1 to 26 as input. It is possible for numbers
//to be repeated in the array.
//Each number corresponds to its letter in alphabetical order (e.g. 1 = A, 2 = B, etc.).
//Write a function where you win the game if your numbers can spell "BINGO".
//They must not be in the correct order in the input array. Otherwise, you lose.
//Your outputs should be "WIN" or "LOSE" accordingly.

public class BingoOrNot {
    public static void main(String[] args) {
        System.out.println(bingo(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})); //"LOSE"
        System.out.println(bingo(new int[]{21, 13, 2, 7, 5, 14, 7, 15, 9, 10})); //"WIN"
    }

    public static String bingo(int[] numberArray) {
        StringBuilder sb = new StringBuilder();

        for (int j : numberArray) {
            String s = Character.toString((char) j + 64);
            sb.append(s);
        }

        if (isBingo(sb.toString())) {
            return "WIN";
        }

        return "LOSE";
    }

    private static boolean isBingo(String str) {
        return str.contains("B") && str.contains("I") && str.contains("N")
                && str.contains("G") && str.contains("O");
    }
}
