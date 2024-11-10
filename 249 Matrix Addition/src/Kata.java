//Write a function that accepts two square matrices (N x N two dimensional arrays), and return the sum of the two.
//Both matrices being passed into the function will be of size N x N (square), containing only integers.
//How to sum two matrices:
//Take each cell [n][m] from the first matrix, and add it with the same [n][m] cell from the second matrix.
//This will be cell [n][m] of the solution matrix. (Except for C where solution matrix will be a 1d
//pseudo-multidimensional array).
//Visualization:
//|1 2 3|     |2 2 1|     |1+2 2+2 3+1|     |3 4 4|
//|3 2 1|  +  |3 2 3|  =  |3+3 2+2 1+3|  =  |6 4 4|
//|1 1 1|     |1 1 3|     |1+1 1+1 1+3|     |2 2 4|
//Example
//matrixAddition(
//  [ [1, 2, 3],
//    [3, 2, 1],
//    [1, 1, 1] ],
////      +
//  [ [2, 2, 1],
//    [3, 2, 3],
//    [1, 1, 3] ] )
//
//// returns:
//  [ [3, 4, 4],
//    [6, 4, 4],
//    [2, 2, 4] ]

import java.util.Arrays;
import java.util.stream.IntStream;

public class Kata {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(matrixAddition(new int[][]{{1, 2, 3}, {3, 2, 1}, {1, 1, 1}},
                new int[][]{{2, 2, 1}, {3, 2, 3}, {1, 1, 3}}))); //[[3, 4, 4],[6, 4, 4],[2, 2, 4]]
        System.out.println(Arrays.deepToString(matrixAddition2(new int[][]{{1, 2, 3}, {3, 2, 1}, {1, 1, 1}},
                new int[][]{{2, 2, 1}, {3, 2, 3}, {1, 1, 3}}))); //[[3, 4, 4],[6, 4, 4],[2, 2, 4]]
    }

    public static int[][] matrixAddition(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }

    public static int[][] matrixAddition2(int[][] a, int[][] b) {
        int n = a.length;
        return IntStream.range(0, n)
                .mapToObj(i -> IntStream.range(0, n)
                        .map(j -> a[i][j] + b[i][j])
                        .toArray()
                )
                .toArray(int[][]::new);
    }
}
