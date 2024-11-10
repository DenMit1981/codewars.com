//Winter is coming, time to get ready for a ski holiday. The goal of this kata is to determine the number of pairs
//of gloves you can make from the gloves in your drawer.
//Given an array describing the color of each glove, return the number of pairs you can make, assuming
//that only gloves of the same color can form pairs.
//Examples:
//input = ["red", "green", "red", "blue", "blue"]
//result = 2 (1 red pair + 1 blue pair)
//input = ["red", "red", "red", "red", "red", "red"]
//result = 3 (3 red pairs)

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Kata {
    public static void main(String[] args) {
        System.out.println(numberOfPairs(new String[]{})); //0
        System.out.println(numberOfPairs(new String[]{"red", "red"})); //1
        System.out.println(numberOfPairs(new String[]{"red", "green", "blue"})); //0
        System.out.println(numberOfPairs(new String[]{"gray", "black", "purple", "purple", "gray", "black"})); //3
        System.out.println(numberOfPairs(new String[]{"red", "green", "blue", "blue", "red", "green", "red", "red", "red"})); //4

        System.out.println(getMapFromGlovesArrAndNumberOfGloves(new String[]{})); //{}
        System.out.println(getMapFromGlovesArrAndNumberOfGloves(new String[]{"red", "red"})); //{red=2}
        System.out.println(getMapFromGlovesArrAndNumberOfGloves(new String[]{"red", "green", "blue"})); //{red=1, green=1, blue=1}
        System.out.println(getMapFromGlovesArrAndNumberOfGloves(new String[]{"gray", "black", "purple", "purple", "gray", "black"})); //{gray=2, black=2, purple=2}
        System.out.println(getMapFromGlovesArrAndNumberOfGloves(new String[]{"red", "green", "blue", "blue", "red", "green", "red", "red", "red"})); //{red=5, green=2, blue=2}
    }

    public static int numberOfPairs(String[] gloves) {
        return Math.toIntExact(getMapFromGlovesArrAndNumberOfGloves(gloves)
                .values()
                .stream()
                .filter(value -> value > 1)
                .map(value -> value / 2)
                .reduce(0L, Long::sum));
    }

    private static Map<String, Long> getMapFromGlovesArrAndNumberOfGloves(String[] gloves) {
        return Stream.of(gloves)
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
    }
}
