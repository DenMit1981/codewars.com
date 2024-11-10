//The bookseller has many books classified into 26 categories, labeled A, B, ... Z. Each book has a code
//of 3, 4, 5 or more characters. The first character of the code is a capital letter, which identifies the category
//of the book.
//In the bookseller's inventory, each code c is followed by a space and a positive integer n (int n >= 0),
//which indicates the number of books with this code in stock.
//For example, an extract from the inventory might be:
//L = {"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"}.
//or
//L = ["ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"] or ....
//You will be given a list of products (eg: L) and a list of categories in capital letters, eg:
//M = {"A", "B", "C", "W"}
//or
//M = ["A", "B", "C", "W"] or ...
//and your task is to find all the books L with codes belonging to each category M, and sum up their number for each
//category.
//For the lists L and M in the example, you would return a string (in Haskell/Clojure/Racket/Prolog, a list of pairs):
//(A : 20) - (B : 114) - (C : 50) - (W : 0)
//where A, B, C, W are categories, 20 is the sum of a unique book of category A, 114 is the sum corresponding to "BKWRK"
//and "BTSQZ",
//50 is the corresponding to "CDXEF" and 0 is the category "W". since there is no code starting with W.
//If L or M are empty, the returned string is "" (instead, Clojure/Racket/Prolog would return an empty
//array/list).
//Notes:
//As a result, the codes and their values are in the same order as in M.

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StockList {

    public static void main(String[] args) {
        System.out.println(stockSummary(new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"},
                new String[]{"A", "B"})); //"(A : 200) - (B : 1140)"

        System.out.println(stockSummary(new String[]{"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"},
                new String[]{"A", "C", "W", "B"})); //"(A : 20) - (B : 114) - (C : 50) - (W : 0)"

        System.out.println(stockSummary(new String[]{"B 0", "DRTYMKH 060", "R 0", "D 0", "BKWRKAA 125", "BTSQZFG 239", "X 0", "ROXANNE 102", "RHODODE 123"},
                new String[]{"B", "R", "D", "X"})); //"(A : 20) - (B : 114) - (C : 50) - (W : 0)"

        System.out.println("________________________");

        System.out.println(stockSummary2(new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"},
                new String[]{"A", "B"})); //"(A : 200) - (B : 1140)"

        System.out.println(stockSummary2(new String[]{"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"},
                new String[]{"A", "C", "W", "B"})); //"(A : 20) - (B : 114) - (C : 50) - (W : 0)"

        System.out.println(stockSummary2(new String[]{"B 0", "DRTYMKH 060", "R 0", "D 0", "BKWRKAA 125", "BTSQZFG 239", "X 0", "ROXANNE 102", "RHODODE 123"},
                new String[]{"B", "R", "D", "X"})); //"(A : 20) - (B : 114) - (C : 50) - (W : 0)"

    }

    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        String[] result = getMapOfSummaryStock(lstOfArt, lstOf1stLetter).toString()
                .replaceAll("=", " : ")
                .replaceAll("\\{", "")
                .replaceAll("}", "")
                .split(", ");

        for (int i = 0; i < result.length; i++) {
            if (!String.valueOf(result[i].charAt(0)).equals(lstOf1stLetter[i])) {
                swap(result, i, i + 1);
            }
        }

        for (String el : result) {
            sb.append("(")
                    .append(el)
                    .append(") - ");
        }

        return sb.substring(0, sb.toString().length() - 3);
    }

    private static Map<String, Integer> getMapOfSummaryStock(String[] lstOfArt, String[] lstOf1stLetter) {
        String[] result = getResultArrOfBooks(lstOfArt, lstOf1stLetter);

        return Stream.of(result)
                .filter(s -> isContainsLetter(s, lstOf1stLetter))
                .collect(Collectors.groupingBy(s -> String.valueOf(s.charAt(0)),
                        Collectors.summingInt(s -> Integer.parseInt(s.substring(s.indexOf(" ")).trim()))));

    }

    private static String[] getResultArrOfBooks(String[] lstOfArt, String[] lstOf1stLetter) {
        Set<String> set = new LinkedHashSet<>();

        for (String letter : lstOf1stLetter) {
            for (String el : lstOfArt) {
                if (!String.valueOf(el.charAt(0)).equals(letter)) {
                    set.add(letter + " 0");
                } else {
                    set.add(el);
                }
            }
        }

        return set.toArray(new String[0]);
    }

    private static boolean isContainsLetter(String book, String[] lstOf1stLetter) {
        return Arrays.stream(lstOf1stLetter)
                .anyMatch(s -> String.valueOf(book.charAt(0)).equals(s));
    }

    public static void swap(String[] arr, int ind1, int ind2) {
        String temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }

    public static String stockSummary2(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt == null || lstOfArt.length == 0) {
            return "";
        }
        Map<String, Integer> map = new HashMap<>();
        for (String x : lstOfArt) {
            String[] arr = x.split(" ");
            String c = x.substring(0, 1);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + Integer.parseInt(arr[1]));
            } else {
                map.put(c, Integer.valueOf(arr[1]));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lstOf1stLetter.length; i++) {
            Integer count = map.getOrDefault(lstOf1stLetter[i], 0);
            if (i != lstOf1stLetter.length - 1) {
                sb.append(String.format("(%s : %d) - ", lstOf1stLetter[i], count));
            } else {
                sb.append(String.format("(%s : %d)", lstOf1stLetter[i], count));
            }

        }
        return sb.toString();
    }
}
