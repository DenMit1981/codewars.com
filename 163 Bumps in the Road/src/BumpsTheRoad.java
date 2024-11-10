//Your car is old and breaks down easily. The shock absorbers are gone, and you think it can take about 15 more hits
//before it dies completely.
//Unfortunately for you, your drive is very bumpy! Given a row showing either a smooth road (_) or bumps (n).
//If you can get home safely after hitting 15 bumps or less, return Woohoo!,
//otherwise return Car Dead.

import java.util.Objects;
import java.util.stream.Stream;

public class BumpsTheRoad {

    public static void main(String[] args) {
        System.out.println(bumps("__nn_nnnn__n_n___n____nn__nnn")); //Woohoo!
        System.out.println(bumps("__nn_nnnn_____n____nn__n")); //Woohoo!
        System.out.println(bumps("__nn_nnnn__n_nnnn___n____nn__nnn")); //Car Dead

        System.out.println(bumpsByStream("__nn_nnnn__n_n___n____nn__nnn")); //Woohoo!
        System.out.println(bumpsByStream("__nn_nnnn_____n____nn__n")); //Woohoo!
        System.out.println(bumpsByStream("__nn_nnnn__n_nnnn___n____nn__nnn")); //Car Dead
    }

    public static String bumps(String road) {
        String[] bumpsArr = road.split("");
        int count = 0;

        for (String bump : bumpsArr) {
            if (bump.equals("n")) {
                count++;
            }
        }

        if (count <= 15) {
            return "Woohoo!";
        }

        return "Car Dead";
    }

    public static String bumpsByStream(final String road) {
        if (bumpsCount(road) <= 15) {
            return "Woohoo!";
        }

        return "Car Dead";
    }

    private static long bumpsCount(String road) {
        return Stream.of(road.split(""))
                .filter(s -> Objects.equals(s, "n"))
                .count();
    }
}
