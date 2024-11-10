//A pangram is a sentence in which every letter of the alphabet occurs at least once.
//For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram,
//because it uses the letters A through Z at least once (case does not matter).
//Given a string, determine whether it is a pangram. Returns True if it is, False if it is not.
//Ignore numbers and punctuation.

public class PangramChecker {
    public static void main(String[] args) {
        System.out.println(check("The quick brown fox jumps over the lazy dog.")); //true
        System.out.println(check("You shall not pass!")); //false

        System.out.println(check2("The quick brown fox jumps over the lazy dog.")); //true
        System.out.println(check2("You shall not pass!")); //false
    }

    public static boolean check(String sentence) {
        for (char c = 'a'; c <= 'z'; c++) {
            if (!(sentence.toLowerCase().contains("" + c))) {
                return false;
            }
        }
        return true;
    }

    public static boolean check2(String sentence) {
        return sentence.chars()
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .distinct()
                .count() == 26;
    }
}
