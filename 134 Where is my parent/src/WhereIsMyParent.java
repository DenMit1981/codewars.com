//The mothers are throwing a dance party for the kids at school. It's just the mothers and their children at the party.
//Everyone is having a great time on the dance floor, when suddenly all the lights go out. It's a pitch-black night
//and no one can see each other.
//But you were flying by, and you can see in the dark, and you have the ability to teleport people anywhere.
//Legend:
//- Capital letters represent mothers, lowercase letters represent their children, i.e. "A" mother's children are "aaaa".
//- Function input: string contains only letters, uppercase letters are unique.
//Task:
//Arrange all the people in alphabetical order, where Mothers are followed by their children, i.e. "aAbaBb" => "AaaBbb".

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WhereIsMyParent {
    public static void main(String[] args) {
        System.out.println(findChildren("xXfuUuuFxf")); //"FffUuuuXxx"
    }

    public static String findChildren(final String text) {
        return Stream.of(text.split(""))
                .sorted()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.joining());
    }
}
