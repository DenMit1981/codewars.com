//Create a function that takes a positive integer as a parameter and returns a string containing the Roman numeral
//representation of that integer.
//Modern Roman numerals are written by expressing each digit separately, starting with the leftmost digit and skipping
//any digit with a value of zero. The year 1990 is represented in Roman numerals: 1000=M, 900=CM, 90=XC; resulting in MCMXC.
//2008 is written as 2000=MM, 8=VIII; or MMVIII. 1666 uses each Roman symbol in descending order: MDCLXVI.
//Example:
//conversion.solution(1000); //should return "M"
//Symbol Value
//I 1
//V 5
//X 10
//L 50
//C 100
//D 500
//M 1,000
//Remember that there cannot be more than 3 identical symbols in a row.

import java.util.TreeMap;

public class Conversion {
    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public static void main(String[] args) {
        System.out.println(solution(1)); //I
        System.out.println(solution(6)); //VI
        System.out.println(solution(1000)); //M
        System.out.println(solution(1666)); //MDCLXVI
        System.out.println(solution(2008)); //MMVIII
        System.out.println("______________________");

        System.out.println(solution2(1)); //I
        System.out.println(solution2(6)); //VI
        System.out.println(solution2(1000)); //M
        System.out.println(solution2(1666)); //MDCLXVI
        System.out.println(solution2(2008)); //MMVIII
    }

    public static String solution(int num) {
        StringBuilder sb = new StringBuilder();
        int times = 0;

        String[] romans = new String[]{"I", "IV", "V", "IX", "X", "XL", "L",
                "XC", "C", "CD", "D", "CM", "M"};

        int[] ints = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500,
                900, 1000};

        for (int i = ints.length - 1; i >= 0; i--) {
            times = num / ints[i];
            num %= ints[i];

            while (times > 0) {
                sb.append(romans[i]);
                times--;
            }
        }
        return sb.toString();
    }

    public static String solution2(int number) {
        int l = map.floorKey(number);
        if (number == l) {
            return map.get(number);
        }
        return map.get(l) + solution2(number - l);
    }
}
