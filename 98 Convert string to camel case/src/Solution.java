//Complete the method/function so that it converts words separated by dashes/underscores to camel case.
//The first word in the output should be capitalized only if the original word was capitalized (known as upper camel
//case, also often called Pascal case).
//Examples
//"the-stealth-warrior" becomes "theStealthWarrior"
//"The_Stealth_Warrior" becomes "TheStealthWarrior"

public class Solution {
    public static void main(String[] args) {
        String s1 = "the_Stealth_Warrior";
        String s2 = "The-Stealth-Warrior";
        String s3 = "Ninja_Square_Wall_river_Yellow_Red_Samurai_Wall_Black_side";
        System.out.println(toCamelCase(s1));
        System.out.println(toCamelCase(s2));
        System.out.println(toCamelCase(s3));
    }

    public static String toCamelCase(String s) {
        String[] str = s.split("[^A-Za-z]");
        StringBuilder sb = new StringBuilder(str[0]);
        for (int i = 1; i < str.length; i++) {
            sb.append(str[i].replaceFirst(String.valueOf(str[i].charAt(0)),
                    String.valueOf(str[i].charAt(0)).toUpperCase()));
        }
        return sb.toString();
    }
}

