//Build a pyramid-shaped tower, as an array/list of strings, given a positive integer number of floors.
//A tower block is represented with "*" character.
//For example, a tower with 3 floors looks like this:
//
//[
//  "  *  ",
//  " *** ",
//  "*****"
//]
//And a tower with 6 floors looks like this:
//
//[
//  "     *     ",
//  "    ***    ",
//  "   *****   ",
//  "  *******  ",
//  " ********* ",
//  "***********"
//]

import java.util.Arrays;
import java.util.stream.IntStream;

public class BuildTower {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(towerBuilder(6)));
        System.out.println(Arrays.toString(towerBuilder2(6)));
    }

    public static String[] towerBuilder(int nFloors) {
        String[] tower = new String[nFloors];
        for (int i = 0; i < nFloors; i++) {
            int numStars = Math.max(0, i * 2 + 1);
            int numSpaces = nFloors - i - 1;
            char[] stars = new char[numStars];
            char[] spaces = new char[numSpaces];
            Arrays.fill(stars, '*');
            Arrays.fill(spaces, ' ');
            tower[i] = "\n" + new String(spaces) + new String(stars) + new String(spaces);
        }
        return tower;
    }

    public static String[] towerBuilder2(int nFloors) {
        return IntStream.range(0, nFloors)
                .mapToObj(i -> {
                    int numStars = Math.max(0, i * 2 + 1);
                    int numSpaces = nFloors - i - 1;
                    char[] stars = new char[numStars];
                    char[] spaces = new char[numSpaces];
                    Arrays.fill(stars, '*');
                    Arrays.fill(spaces, ' ');
                    return "\n" + new String(spaces) + new String(stars) + new String(spaces);
                })
                .toArray(String[]::new);
    }
}
