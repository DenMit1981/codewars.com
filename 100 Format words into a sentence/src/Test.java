//Complete the method so that it formats the words into a single value separated by commas. The last word should be
//separated by "and" instead of a comma.
//The method takes an array of strings and returns a single formatted string. Empty string values should be ignored.
//Empty arrays or null / nil values passed to the method should result in an empty string being returned.
//Kata.formatWords (new String [] {"ninja", "samurai", "ronin"}) => "ninja, samurai, and ronin"
//Kata.formatWords (new String [] {"ninja", "", "ronin"}) => "ninja and ronin"
//Kata.formatWords (new String [] {}) => ""

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        System.out.println(formatWords(new String[]{"one", "two", "three", "four"})); //"one, two, three and four"
        System.out.println(formatWords(new String[]{"one"})); //"one"
        System.out.println(formatWords(new String[]{"one", "", "three"})); //"one and three"
        System.out.println(formatWords(new String[]{"", "", "three"})); //"three"
        System.out.println(formatWords(new String[]{"one", "two", ""})); //"one and two"
        System.out.println(formatWords(new String[]{})); //""
        System.out.println(formatWords(null)); //""
        System.out.println(formatWords(new String[]{""})); //""
        System.out.println("________________________");

        System.out.println(formatWords2(new String[]{"one", "two", "three", "four"})); //"one, two, three and four"
        System.out.println(formatWords2(new String[]{"one"})); //"one"
        System.out.println(formatWords2(new String[]{"one", "", "three"})); //"one and three"
        System.out.println(formatWords2(new String[]{"", "", "three"})); //"three"
        System.out.println(formatWords2(new String[]{"one", "two", ""})); //"one and two"
        System.out.println(formatWords2(new String[]{})); //""
        System.out.println(formatWords2(null)); //""
        System.out.println(formatWords2(new String[]{""})); //""
    }

    public static String formatWords(String[] words) {
        if (words == null || words.length == 0) return "";
        String res = Arrays.stream(words)
                .filter(word -> !(word == null))
                .filter(word -> !word.equals(""))
                .collect(Collectors.joining(", "));
        if (!res.contains(", "))
            return res;
        int indexOfLastComma = res.lastIndexOf(",");
        String resultUntilLastWord = res.substring(0, indexOfLastComma);
        String lastWord = res.substring(indexOfLastComma + 1);
        res = resultUntilLastWord + " and" + lastWord;
        return res;
    }


    public static String formatWords2(String[] words) {
        int n = 0;
        if (words != null) n = words.length;
        if (words == null || n == 0) return "";
        if (Objects.equals(words[n - 1], "") && n >= 3) {
            if (!Objects.equals(words[n - 3], "") && !Objects.equals(words[n - 2], ""))
                return words[n - 3] + " and " + words[n - 2];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            if (words[i].isEmpty()) continue;
            sb.append(words[i]).append(", ");
        }
        if (!(sb.toString().contains(", "))) return words[n - 1];
        return sb.toString().replaceFirst(",([^,]+)$", "") + " and " + words[words.length - 1];
    }
}


