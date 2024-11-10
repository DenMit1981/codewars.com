//Once upon a time, on a journey through the old wild mountain west,…
//…a man was given directions to go from one point to another. The directions were "NORTH", "SOUTH", "WEST", "EAST".
//It is clear that "NORTH" and "SOUTH" are opposites, "WEST" and "EAST" too.
//Going in one direction and immediately returning in the opposite direction is a useless effort.
//Since this is the wild west, with terrible weather and little water, it is important to conserve some energy,
//otherwise you may die of thirst!
//How I cleverly crossed the mountain desert.
//The directions given to the man, for example, are as follows (depending on the language):
//["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"].
//It is immediately obvious that going "NORTH" and immediately "SOUTH" is unwise, better to stay where you are! So the
//task is to give a person a simplified version of the plan. The best plan in this case is simply: ["WEST"]
//Other examples:
//In ["NORTH", "SOUTH", "EAST", "WEST"] the direction "NORTH" + "SOUTH" goes north and immediately returns.
//The path becomes ["EAST", "WEST"], now "EAST" and "WEST" annihilate each other, so the final
//result is [] (zero in Clojure).
//
//Problem
//Write a function dirReduc that takes an array of strings and returns an array of strings with unnecessary
//directions (W<->E or S<->N adjacent) removed.
//Not all paths can be made simpler. The path ["NORTH", "WEST", "SOUTH", "EAST"] is not reducible.
//"NORTH" and "WEST", "WEST" and "SOUTH", "SOUTH" and "EAST" are not directly opposite to each other and cannot become
//so.Therefore, the path of the result itself is: ["NORTH", "WEST", "SOUTH", "EAST"].

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DirReduction {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}))); //[WEST}
        System.out.println(Arrays.toString(dirReduc(new String[]{"NORTH", "NORTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}))); //[NORTH, NORTH, WEST]
    }

    public static String[] dirReduc(String[] arr) {
        List<String> list = new ArrayList<>();

        Collections.addAll(list, arr);

        while (true) {
            int len = list.size();
            for (int i = 0; i < list.size() - 1; i++) {
                if (isAnnihilates(list.get(i), list.get(i + 1))) {
                    list.remove(i);
                    list.remove(i);
                }
            }
            if (len == list.size()) {
                break;
            }
        }
        return list.toArray(String[]::new); //return list.toArray(new String[0])
    }

    private static boolean isAnnihilates(String s1, String s2) {
        return s1.equals("NORTH") && s2.equals("SOUTH") || s1.equals("SOUTH") && s2.equals("NORTH") ||
                s1.equals("WEST") && s2.equals("EAST") || s1.equals("EAST") && s2.equals("WEST");
    }
}
