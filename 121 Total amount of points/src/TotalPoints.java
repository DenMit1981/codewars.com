//Total points
//Our football team has finished the championship. The result of each match is "x:y". The results
//of all matches are recorded in a collection.
//For example: ["3:1", "2:2", "0:1", ...]
//Write a function that takes such a collection and calculates the points of our team in the championship.
//The rules for calculating points for each match:
//if x > y: 3 points
//if x < y: 0 points
//if x = y: 1 point
//Notes:
//there are 10 matches in the championship
//0 <= x <= 4
//0 <= y <= 4

public class TotalPoints {
    public static void main(String[] args) {
        System.out.println(points(new String[]{"1:0", "2:0", "3:0", "4:0", "2:1", "3:1", "4:1", "3:2", "4:2", "4:3"})); //30
        System.out.println(points(new String[]{"1:1", "2:2", "3:3", "4:4", "2:2", "3:3", "4:4", "3:3", "4:4", "4:4"})); //10
        System.out.println(points(new String[]{"0:1", "0:2", "0:3", "0:4", "1:2", "1:3", "1:4", "2:3", "2:4", "3:4"})); //0
        System.out.println(points(new String[]{"1:0", "2:0", "3:0", "4:4", "2:2", "3:3", "1:4", "2:3", "2:4", "3:4"})); //12
    }

    public static int points(String[] games) {
        int count = 0;

        for (String game : games) {
            if (getScoreFromString(game, 0) > getScoreFromString(game, 2)) {
                count += 3;
            } else if (getScoreFromString(game, 0) < getScoreFromString(game, 2)) {
                count += 0;
            } else {
                count++;
            }
        }
        return count;
    }

    private static int getScoreFromString(String game, int index) {
        return Integer.parseInt(String.valueOf(game.charAt(index)));
    }
}
