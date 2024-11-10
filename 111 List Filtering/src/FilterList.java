//In this kata, you will create a function that takes a list of non-negative integers and strings and returns a new
//list with the strings filtered out.

import java.util.List;
import java.util.stream.Collectors;

public class FilterList {
    public static void main(String[] args) {
        System.out.println(filterList(List.of(1, 2, "a", "b"))); //[1, 2]
        System.out.println(filterList(List.of(1, 2, "a", "b", 0, 15))); //[1, 2, 0, 15]
        System.out.println(filterList(List.of(1, 2, "a", "b", "aasf", "1", "123", 231))); //[1, 2, 231]
    }

    public static List<Object> filterList(final List<Object> list) {
        return list.stream()
                .filter(n -> !(n instanceof String))
                .collect(Collectors.toList());
    }
}
