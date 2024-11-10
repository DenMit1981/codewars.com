//Introduction
//There is a war going on and no one knows - the war of the alphabets!
//There are two groups of hostile letters. The tension between the left and right letters was too great, and a war began.
//Problem
//Write a function that takes a fight string consisting of only lowercase letters and returns
//who won the fight. When the left side wins, return Left side wins!, when the right side wins,
//return Right side wins!, otherwise return Let's fight again!
//The left side letters and their power:
//w - 4
//p - 3
//b - 2
//s - 1
//The right side letters and their power:
//m - 4
//q - 3
//d - 2
//z - 1
//The rest of the letters have no power and are only victims.
//Example
//AlphabetWar("z"); //=> Right side wins!
//AlphabetWar("zdqmwpbs"); //=> Let's fight again!
//AlphabetWar("zzzzs"); //=> Right side wins!
//AlphabetWar("wwwwwwz"); //=> Left side wins!


public class AlphabetWar {
    public static void main(String[] args) {

        System.out.println(alphabetWar("z")); //Right side wins!
        System.out.println(alphabetWar("zdqmwpbs")); //Let's fight again!
        System.out.println(alphabetWar("zzzzs")); //Right side wins!
        System.out.println(alphabetWar("wwwwwwz")); //Left side wins!
        System.out.println(alphabetWar("gd")); //Right side wins!
        System.out.println(alphabetWar("cq")); //Right side wins!
        System.out.println(alphabetWar("pdg")); //Left side wins!
        System.out.println(alphabetWar("zw")); //Left side wins!
        System.out.println("__________________________");

        System.out.println(alphabetWar2("z")); //Right side wins!
        System.out.println(alphabetWar2("zdqmwpbs")); //Let's fight again!
        System.out.println(alphabetWar2("zzzzs")); //Right side wins!
        System.out.println(alphabetWar2("wwwwwwz")); //Left side wins!
        System.out.println(alphabetWar2("gd")); //Right side wins!
        System.out.println(alphabetWar2("cq")); //Right side wins!
        System.out.println(alphabetWar2("pdg")); //Left side wins!
        System.out.println(alphabetWar2("zw")); //Left side wins!
    }

    public static String alphabetWar(String fight) {
        int score = 0;
        char[] lettersArr = fight.toCharArray();
        for (char letter : lettersArr) {
            switch (letter) {
                case 'w':
                    score -= 4;
                    break;
                case 'p':
                    score -= 3;
                    break;
                case 'b':
                    score -= 2;
                    break;
                case 's':
                    score -= 1;
                    break;
                case 'm':
                    score += 4;
                    break;
                case 'q':
                    score += 3;
                    break;
                case 'd':
                    score += 2;
                    break;
                case 'z':
                    score += 1;
                    break;
            }
        }

        return score < 0 ? "Left side wins!" : score > 0 ? "Right side wins!" : "Let's fight again!";
    }

    public static String alphabetWar2(String fight) {
        int leftCount = 0;
        int rightCount = 0;

        char[] lettersArr = fight.toCharArray();

        for (char c : lettersArr) {
            if (getPowerLetter(c) > 0) {
                leftCount++;
            }

            if (getPowerLetter(c) < 0) {
                rightCount++;
            }
        }

        if (leftCount > rightCount) {
            return "Left side wins!";
        }

        if (rightCount > leftCount) {
            return "Right side wins!";
        }

        return "Let's fight again!";
    }

    private static int getPowerLetter(char letter) {
        int count = 0;

        switch (letter) {
            case 'w':
                count += 4;
                break;
            case 'p':
                count += 3;
                break;
            case 'b':
                count += 2;
                break;
            case 's':
                count += 1;
                break;
            case 'm':
                count -= 4;
                break;
            case 'q':
                count -= 3;
                break;
            case 'd':
                count -= 2;
                break;
            case 'z':
                count -= 1;
                break;
        }

        return count;
    }
}
