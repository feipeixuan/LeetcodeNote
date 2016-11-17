package com.algorithm.dp;

/**
 * Created by feipeixuan on 2016/11/17.
 */
public class Subject304_1 {

    private int[][] valueArray = null;

    private int[][] matrix = null;

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        Subject304_1 solution = new Subject304_1();
        solution.NumMatrix(matrix);
        System.out.println(solution.sumRegion(0, 0, 0, 0));
        System.out.println(solution.sumRegion(1, 1, 2, 2));
        System.out.println(solution.sumRegion(1, 2, 2, 4));

    }

    public void NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        this.matrix = matrix;
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        valueArray = new int[rowLength][columnLength];

        for (int i = 0; i < columnLength; i++) {
            if (i - 1 >= 0) {
                valueArray[0][i] = valueArray[0][i - 1] + matrix[0][i];
            } else {
                valueArray[0][i] = matrix[0][i];
            }
        }

        for (int i = 0; i < rowLength; i++) {
            if (i - 1 >= 0) {
                valueArray[i][0] = valueArray[i - 1][0] + matrix[i][0];
            } else {
                valueArray[i][0] = valueArray[i][0];
            }
        }

        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < columnLength; j++) {
                valueArray[i][j] = valueArray[i - 1][j] + valueArray[i][j - 1] - valueArray[i - 1][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (matrix == null) {
            return 0;
        } else {
            int sum = valueArray[row2][col2];
            if (row1 > 0) {
                sum = sum - valueArray[row1 - 1][col2];
            }
            if (col1 > 0) {
                sum = sum - valueArray[row2][col1 - 1];
            }
            if (col1 > 0 && row1 > 0) {
                sum = sum + valueArray[row1 - 1][col1 - 1];
            }
            return sum;
        }
    }
}
