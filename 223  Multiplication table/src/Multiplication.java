//Your task is to create a N×N multiplication table of the size specified in the parameter.
//For example, if the size is 3:
//1 2 3
//2 4 6
//3 6 9
//For this example, the return value should be:
//[[1,2,3],[2,4,6],[3,6,9]]

import java.util.Arrays;

public class Multiplication {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(multiplicationTable(3))); //[[1, 2, 3], [2, 4, 6], [3, 6, 9]]
        System.out.println(Arrays.deepToString(multiplicationTable(4))); //[[1, 2, 3, 4], [2, 4, 6, 8], [3, 6, 9, 12], [4, 8, 12, 16]]
        System.out.println(Arrays.deepToString(multiplicationTable(1))); //[[1]]
    }

    public static int[][] multiplicationTable(int n) {
        int[][] multiArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                multiArr[i][j] = (i + 1) * (j + 1);
            }
        }
        return multiArr;
    }
}
