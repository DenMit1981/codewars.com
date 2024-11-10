//Middle-earth is preparing for war. The forces of good will have many battles to fight against the forces of evil.
//Of course,there will be different races involved. Each race has a certain value when fighting against others.
//On the good side, we have the following races with their values:
//Hobbits: 1
//Male: 2
//Elves: 3
//Dwarves: 3
//Eagles: 4
//Wizards: 10
//On the evil side, we have:
//Orcs: 1
//Male: 2
//Wargs: 2
//Goblins: 2
//Uruk Hai: 3
//Trolls: 5
//Wizards: 10
//While weather, location, supplies, and valor all play a role in any battle, if you add up the value of the good side
//and compare it to the value of the evil side, the side with the higher value will usually win.
//So given the score of each race on the good side, and then the score of each race on the evil side, determine which side wins.
//Input:
//The function will receive two parameters. Each parameter will be a string of integers separated by a single space.
//Each string will contain the count of each race on the good and evil sides.
//The first parameter will contain the count of each race on the good side in the following order:
//Hobbits, Humans, Elves, Dwarves, Eagles, Wizards.
//The second parameter will contain the count of each race on the evil side in the following order:
//Orcs, Humans, Wargs, Goblins, Uruk Hai, Trolls, Wizards.
//All values are non-negative integers. The resulting sum of the value for each side
//will not exceed the limit of a 32-bit integer.
//Output: Return "Battle Result: Good triumphs over Evil" if good wins, "Battle Result: Evil eradicates all trace of
//Good" if evil wins, or "Battle Result: No victor on this battle field" if it ends in a tie.

import java.util.Arrays;
import java.util.stream.IntStream;

public class GoodVsEvil {

    private static final int[] GOOD_VALUES_ARR = {1, 2, 3, 3, 4, 10};
    private static final int[] EVIL_VALUES_ARR = {1, 2, 2, 2, 3, 5, 10};

    public static void main(String[] args) {

        System.out.println(battle("1 1 1 1 1 1", "1 1 1 1 1 1 1")); //Battle Result: Evil eradicates all trace of Good
        System.out.println(battle("0 0 0 0 0 10", "0 1 1 1 1 0 0")); //Battle Result: Good triumphs over Evil
        System.out.println(battle("1 0 0 0 0 0", "1 0 0 0 0 0 0")); //Battle Result: No victor on this battle field
        System.out.println(battle("4504 5035 7380 601 9097 9648", "7848 2340 8677 9394 9311 3894 591")); //Battle Result: Good triumphs over Evil
    }

    public static String battle(String goodAmounts, String evilAmounts) {
        if (sumOfWorth(goodAmounts, GOOD_VALUES_ARR) > sumOfWorth(evilAmounts, EVIL_VALUES_ARR)) {
            return "Battle Result: Good triumphs over Evil";
        } else if (sumOfWorth(goodAmounts, GOOD_VALUES_ARR) < sumOfWorth(evilAmounts, EVIL_VALUES_ARR)) {
            return "Battle Result: Evil eradicates all trace of Good";
        } else {
            return "Battle Result: No victor on this battle field";
        }
    }

    private static int sumOfWorth(String amounts, int[] valuesArr) {
        int[] resultArr = getResultValuesAmountArr(amounts, valuesArr);

        return Arrays.stream(resultArr).sum();
    }

    private static int[] getResultValuesAmountArr(String amounts, int[] valuesArr) {
        String[] amountsArr = amounts.split(" ");

        return IntStream.range(0, amountsArr.length)
                .map(i -> valuesArr[i] * Integer.parseInt(amountsArr[i]))
                .toArray();
    }
}
