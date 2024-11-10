//Happy Holidays, fellow Code Warriors!
//Santa's Senior Gift Organizer Elf devised a way to present up to 26 gifts by assigning each gift a
//unique alphabetical character. After each gift was assigned a character, Gift Organizer Elf
//joined the characters to form a gift order code.
//
//Santa asked the organizer to arrange the characters in alphabetical order, but the elf fell asleep after eating too
//much hot chocolate and candy canes! Can you help him?
//
//Sort Gift Code
//Write a function named sortGiftCode/sort_gift_code/SortGiftCode that takes a string of up to 26 unique alphabetical
//characters and returns a string containing the same characters in alphabetical order.
//
//Examples (input -- => output):
//"abcdef" -- => "abcdef"
//"pqksuvy" -- => "kpqsuvy"
//"zyxwvutsrqponmlkjihgfedcba" -- => "abcdefghijklmnopqrstuvwxyz"

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GiftSorter {
    public static void main(String[] args) {
        System.out.println(sortGiftCode("fedcba"));
        System.out.println(sortGiftCode("zyxwvutsrqponmlkjihgfedcba"));
    }

    public static String sortGiftCode(String code) {
        return Stream.of(code.split(""))
                .sorted()
                .collect(Collectors.joining());
    }
}
