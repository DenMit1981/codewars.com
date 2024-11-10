//If you visit London and travel on the Underground, you may hear the announcer say, "Mind the gap!"
//This is usually due to a gap between the train and the platform. Recently, a different type of gap has begun to appear
//on overground trains. Train thieves steal entire carriages from trains, leaving gaps in the sequence of carriage numbers.
//You have been asked to write a program to detect the problem.
//Problem
//You are asked to implement a function that takes a carriage sequence as a string of carriage letters and returns
//the number of carriages that are missing. Train carriages are initially designated by the letters "A" with no gaps.
//Some carriages may be missing, but the remaining carriages are in the original order of the sequence.
//The carriage with the highest letter can never be missing (because that is where the engine is).
//The number of carriages in a train can vary from 1 to 26 (i.e. from "A" to "Z").
//Examples
//countMissingCarriages("ABC") should return 0 because all carriages are present.
//countMissingCarriages("ABD") should return 1 because carriage C is missing.
//countMissingCarriages("BCF") should return 3 because carriages A, D, and E are missing.

public class TrainInspector {
    public static void main(String[] args) {
        System.out.println(countMissingCarriages("ABC")); //0
        System.out.println(countMissingCarriages("ABD")); //1
        System.out.println(countMissingCarriages("BCF")); //3
    }

    public static int countMissingCarriages(String train) {
        String[] trainArr = train.split("");
        String[] rightTrainArr = getRightTrain(train);

        return rightTrainArr.length - trainArr.length;
    }

    private static String[] getRightTrain(String train) {
        StringBuilder sb = new StringBuilder();
        char[] trainArr = train.toCharArray();

        for (char c = 'A'; c <= trainArr[trainArr.length - 1]; c++) {
            sb.append(c);
        }

        return sb.toString().split("");
    }
}
