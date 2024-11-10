//The hero heads to a castle to complete his mission. However, he is told that the castle is surrounded by a couple of
//powerful dragons! Each dragon requires 2 bullets to be defeated, our hero has no idea how many bullets he should carry.
//Assuming he is going to grab a certain number of bullets and move
//on to fight another given number of dragons, will he survive?
//Return true if yes, otherwise false :)

public class Solution {
    public static void main(String[] args) {
        System.out.println(hero(10, 5));
        System.out.println(hero(100, 40));
        System.out.println(hero(4, 5));
        System.out.println(hero(1500, 751));
        System.out.println(hero(0, 1));
        System.out.println(hero(7, 4));
    }

    public static boolean hero(int bullets, int dragons) {
        return bullets / dragons >= 2;
    }
}
