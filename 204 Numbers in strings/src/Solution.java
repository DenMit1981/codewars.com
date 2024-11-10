//In this Kata, you will be given a string of lowercase letters and numbers. Your task is to compare
//the groups of numbers and return the largest number. The numbers will not have leading zeros.
//For example, solve("gh12cdy695m1") = 695, since this is the largest of all the groups of numbers.

public class Solution {
    public static void main(String[] args) {
        System.out.println(solve("2ti9iei7qhr5")); //9
        System.out.println(solve("gh12cdy695m1")); //695
        System.out.println(solve("lu1j8qbbb85")); //85
        System.out.println(solve("185lu1j8qbbb85")); //185
    }

    public static int solve(String s) {
        String[] stringArr = s.replaceAll("\\D", " ")
                .replaceAll("\\s{2,}", " ")
                .trim()
                .split(" ");

        int max = Integer.MIN_VALUE;

        for (String str : stringArr) {
            if (Integer.parseInt(str) > max) {
                max = Integer.parseInt(str);
            }
        }

        return max;
    }
}

