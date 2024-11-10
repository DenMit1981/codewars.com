//The basic idea is to count all the characters that appear in a string. If you have a string like aba,
//the result should be {'a': 2, 'b': 1}.
//What if the string is empty? Then the result should be an empty object literal {}.

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Kata {
    public static void main(String[] args) {
        System.out.println(count("aabbbac")); //{a=3, b=3, c=1}
    }

    public static Map<Character, Integer> count(String str) {
        List<Character> textInChar = str.chars().mapToObj(e -> (char) e).collect(Collectors.toList());

        return textInChar.stream().collect(TreeMap::new, (m, c) -> {
            m.put(c, m.containsKey(c) ? (m.get(c) + 1) : 1);
        }, TreeMap::putAll);
    }
}
