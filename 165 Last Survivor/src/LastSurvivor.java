//You are given a string of letters and an array of numbers.
//The numbers indicate the positions of the letters that need to be deleted in order, starting from the beginning of the array.
//After each deletion, the size of the string decreases (there is no empty space).
//Return the only remaining letter.
//
//Example:
//str = "zbk", arr = {0, 1}
//str = "bk", arr = {1}
//str = "b", arr = {}
//return "b"
//Notes:
//This string will never be empty.
//The length of the array is always one less than the length of the string.
//All numbers are valid.
//There may be duplicate letters and numbers.

public class LastSurvivor {

    public static void main(String[] args) {
        System.out.println(lastSurvivor("abc", new int[]{1, 1})); //a
        System.out.println(lastSurvivor("zbk", new int[]{2, 1})); //z
        System.out.println(lastSurvivor("foiflxtpicahhkqjswjuyhmypkrdbwnmwbrrvdycqespfvdviucjoyvskltqaqirtjqulprjjoaiagobpf" +
                        "tywabqjdmiofpsr",
                new int[]{8, 59, 52, 93, 21, 40, 88, 85, 59, 10, 82, 18, 74, 59, 51, 47, 75, 49, 23, 56, 1, 33, 39, 33,
                        34, 44, 25, 0, 51, 25, 36, 32, 57, 10, 57, 12, 51, 55, 24, 55, 31, 49, 6, 15, 10, 48, 27, 29,
                        38, 30, 35, 42, 23, 32, 9, 39, 39, 36, 8, 29, 2, 33, 14, 3, 13, 25, 9, 25, 18, 10, 1, 2, 20, 8,
                        2, 11, 5, 7, 0, 10, 10, 8, 12, 3, 5, 1, 7, 7, 5, 1, 4, 0, 4, 0, 0, 1})); //d
    }

    public static String lastSurvivor(String letters, int[] coords) {
        StringBuilder sb = new StringBuilder(letters);

        for (int i = 0; i < coords.length; i++) {
            if (coords[i] > letters.length()) {
                i++;
            }

            int index = coords[i];
            sb.deleteCharAt(index);
        }

        return sb.toString();
    }
}
