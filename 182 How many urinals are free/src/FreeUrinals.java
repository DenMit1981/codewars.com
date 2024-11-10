//How many urinals are free?
//In men's public restrooms with urinals, there is an unwritten rule: you must leave at least
//one urinal free between you and the next person to pee. For example, if there are 3 urinals and one person is already
//peeing in the left one, you will choose the urinal on the right, not the one in the middle. This means that a maximum
//of 3 people can
//pee at the same time in public restrooms with 5 urinals if you follow this rule
//(only 2 if the first person pees in urinal 2 or 4).
//Your task:
//You need to write a function that returns the maximum number of free urinals as an integer, according to
//the unwritten rule.
//Input
//A string containing 1s and 0s (example: 10001) (1 <= length <= 20)
//A 1 represents a taken urinal, and a 0 represents a free urinal.
//Examples
//10001 returns 1 (10101)
//1001 returns 0 (1001)
//00000 returns 3 (10101)
//0000 returns 2 (1001)
//01000 returns 1 (01010 or 01001)
//Note
//When there is already an error in the input string (e.g. 011), then return -1
//Have fun and don't pee in the wrong urinal ;)

public class FreeUrinals {
    public static void main(String[] args) {

        System.out.println(getFreeUrinals("10001"));
        System.out.println(getFreeUrinals("1001"));
        System.out.println(getFreeUrinals("00000"));
        System.out.println(getFreeUrinals("0000"));
        System.out.println(getFreeUrinals("01000"));
        System.out.println(getFreeUrinals("00010"));
        System.out.println(getFreeUrinals("10000"));
        System.out.println(getFreeUrinals("1"));
        System.out.println(getFreeUrinals("0"));
        System.out.println(getFreeUrinals("10"));
        System.out.println(getFreeUrinals("110"));
        System.out.println(getFreeUrinals("101100001"));
        System.out.println("_____________________");

        System.out.println(getFreeUrinals2("10001"));
        System.out.println(getFreeUrinals2("1001"));
        System.out.println(getFreeUrinals2("00000"));
        System.out.println(getFreeUrinals2("0000"));
        System.out.println(getFreeUrinals2("01000"));
        System.out.println(getFreeUrinals2("00010"));
        System.out.println(getFreeUrinals2("10000"));
        System.out.println(getFreeUrinals2("1"));
        System.out.println(getFreeUrinals2("0"));
        System.out.println(getFreeUrinals2("10"));
        System.out.println(getFreeUrinals2("110"));
        System.out.println(getFreeUrinals2("101100001"));
    }

    public static int getFreeUrinals(String urinals) {
        return urinals.contains("11") ? -1 :
                urinals.replaceAll("010|10|01", "1")
                        .replace("00", "0")
                        .replace("1", "")
                        .length();
    }

    public static int getFreeUrinals2(String urinals) {
        if (urinals.equals("0")) {
            return 1;
        }
        String[] urinArr = urinals.split("");
        int count = 0;

        for (int i = 0; i < urinArr.length - 2; i++) {
            if (urinArr[i].equals("0") && urinArr[i + 1].equals("0") && urinArr[i + 2].equals("0")) {
                count++;
            }
            if (urinArr[i].equals("1") && urinArr[i + 1].equals("1")) {
                return -1;
            }
        }

        return count;
    }
}
