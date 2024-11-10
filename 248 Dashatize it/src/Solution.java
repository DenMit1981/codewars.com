//Given an integer, return a string with dash '-' marks before and after each odd digit, but do not begin or end
//the string with a dash mark.
//Ex:
//274 -> '2-7-4'
//6815 -> '68-1-5'

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(dashatize(274)); //2-7-4
        System.out.println(dashatize(6815)); //68-1-5
        System.out.println(dashatize(5311)); //5-3-1-1
        System.out.println(dashatize(86320)); //86-3-20
        System.out.println(dashatize(974302)); //9-7-4-3-02
        System.out.println(dashatize(0)); //0
        System.out.println(dashatize(-1)); //1
        System.out.println(dashatize(-28369)); //28-3-6-9
        System.out.println(dashatize(Integer.MAX_VALUE)); //2-1-4-7-48-3-64-7
        System.out.println(dashatize(Integer.MIN_VALUE)); //2-1-4-7-48-3-648
        System.out.println(dashatize(-1111111111)); //1-1-1-1-1-1-1-1-1-1
        System.out.println(dashatize(922303320)); //9-22-3-0-3-3-20
        System.out.println("___________________");

        System.out.println(dashatize2(274)); //2-7-4
        System.out.println(dashatize2(6815)); //68-1-5
        System.out.println(dashatize2(5311)); //5-3-1-1
        System.out.println(dashatize2(86320)); //86-3-20
        System.out.println(dashatize2(974302)); //9-7-4-3-02
        System.out.println(dashatize2(0)); //0
        System.out.println(dashatize2(-1)); //1
        System.out.println(dashatize2(-28369)); //28-3-6-9
        System.out.println(dashatize2(Integer.MAX_VALUE)); //2-1-4-7-48-3-64-7
        System.out.println(dashatize2(Integer.MIN_VALUE)); //2-1-4-7-48-3-648
        System.out.println(dashatize2(-1111111111)); //1-1-1-1-1-1-1-1-1-1
        System.out.println(dashatize2(922303320)); //9-22-3-0-3-3-20
    }

    public static String dashatize(int num) {
        if (num < 10 && num > -10) {
            return String.valueOf(Math.abs(num));
        }

        String[] arr = String.valueOf(num).replaceAll("-", "").split("");
        StringBuilder sb = new StringBuilder().append(Integer.parseInt(arr[0]) % 2 == 0 ? arr[0] : arr[0] + "-");

        for (int i = 1; i < arr.length - 1; i++) {
            if (Integer.parseInt(arr[i]) % 2 == 0) {
                sb.append(arr[i]);
            } else {
                sb.append("-").append(arr[i]).append("-");
            }
        }
        sb.append(Integer.parseInt(arr[arr.length - 1]) % 2 == 0 ? arr[arr.length - 1] : "-" + arr[arr.length - 1]);

        return sb.toString().replaceAll("--", "-");
    }

    public static String dashatize2(int num) {
        return Arrays.stream(String.valueOf(Math.abs(num))
                        .replaceAll("-", "")
                        .split(""))
                .map(n -> Integer.parseInt(n) % 2 != 0 ? "-" + n + "-" : n)
                .collect(Collectors.joining())
                .replaceAll("--", "-")
                .replaceAll("^-", "")
                .replaceAll("-$", "");
    }
}
