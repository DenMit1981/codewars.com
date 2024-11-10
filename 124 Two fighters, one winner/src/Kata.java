//Create a function that returns the name of the winner in a fight between two fighters.
//Each fighter takes turns attacking the other, and the winner is the one who kills the other first.
//Death is defined as having health <= 0.
//Each fighter will be a Fighter object/instance. See the fighter class below in your language of choice.
//Both health and damage per attack will be integers greater than 0. You can mutate Fighter objects.
//Example:
//declare_winner(Fighter("Lew", 10, 2), Fighter("Harry", 5, 4), "Lew") => "Lew"
//Lew attacks Harry; Harry now has 3 health.
//Harry attacks Lew; Lew now has 6 health.
//Lew attacks Harry; Harry now has 1 health.
//Harry attacks Lew; Lew now has 2 health.
//Lew attacks Harry: Harry now has -1 health and is dead. Lew wins.

public class Kata {
    public static void main(String[] args) {
        System.out.println(declareWinner(new Fighter("Lew", 10, 2),
                new Fighter("Harry", 5, 4), "Lew")); //Lew
        System.out.println(declareWinner(new Fighter("Lew", 10, 2),
                new Fighter("Harry", 5, 4), "Harry")); //Harry
        System.out.println(declareWinner(new Fighter("Harald", 20, 5),
                new Fighter("Harry", 5, 4), "Harry")); //Harald
        System.out.println(declareWinner(new Fighter("Harald", 20, 5),
                new Fighter("Harry", 5, 4), "Harald")); //Harald
        System.out.println(declareWinner(new Fighter("Jerry", 30, 3),
                new Fighter("Harald", 20, 5), "Jerry")); //Harald
        System.out.println(declareWinner(new Fighter("Jerry", 30, 3),
                new Fighter("Harald", 20, 5), "Harald")); //Harald
    }

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        int health1 = fighter1.getHealth();
        int health2 = fighter2.getHealth();

        if (!firstAttacker.equals(fighter1.getName())) {
            health1 -= fighter2.getDamagePerAttack();
        } else {
            health2 -= fighter1.getDamagePerAttack();
        }

        return countOfEnemyKicksBeforeDeath(health1, fighter2.getDamagePerAttack()) >
                countOfEnemyKicksBeforeDeath(health2, fighter1.getDamagePerAttack()) ?
                fighter1.getName() : fighter2.getName();

    }

    private static int countOfEnemyKicksBeforeDeath(int health, int enemyDamage) {
        int count = 0;

        while (health > 0) {
            health -= enemyDamage;
            count++;
        }
        return count;
    }
}


