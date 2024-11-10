//Two turtles named A and B are to participate in a race. A starts at an average speed of 720 feet per hour.
//Young B knows that she runs faster than A, and besides, she has not yet finished her cabbage.
//When she finally starts moving, she sees that A has a 70-foot lead, but B's speed is 850 feet per hour. How long will
//it take B to catch up with A?
//More generally, given two speeds v1 (A's speed, integer > 0) and v2 (B's speed, integer > 0)
//and a lead g (integer > 0), how long will it take B to catch up with A?
//The result is an array [hr, min, sec], which represents the required time in hours, minutes, and seconds
//(rounded to the nearest second), or a string in some languages.
//If v1 >= v2, then return nil, nothing, null, None, or {-1, -1, -1} for C++, C, Go, Nim, Pascal, COBOL, Erlang,
//[-1, -1, -1] for Perl, [] for Kotlin, or "-1 -1 -1".
//Examples:
//(result format depends on language)
//race(720, 850, 70) => [0, 32, 18] or "0 32 18"
//race(80, 91, 37) => [3, 21, 49] or "3 21 49"
//** Tips for those who don't know how to convert hours, minutes, seconds:
//Turtles don't care about fractions of seconds
//Consider doing the calculation manually, using only integers (use or simulate integer division in your code)
//or Google: "convert decimal time to hours minutes seconds"

import java.util.Arrays;

public class Tortoise {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(race(720, 850, 70))); //[0, 32, 18]
        System.out.println(Arrays.toString(race(80, 91, 37))); //[3, 21, 49]
        System.out.println(Arrays.toString(race(80, 100, 40))); //[2, 0, 0]
    }

    public static int[] race(int v1, int v2, int g) {

        if (v1 >= v2) {
            return null;
        }

        int time = g * 3600 / (v2 - v1); //in seconds

        return new int[]{time / 3600, (time % 3600) / 60, time % 60};
    }
}
