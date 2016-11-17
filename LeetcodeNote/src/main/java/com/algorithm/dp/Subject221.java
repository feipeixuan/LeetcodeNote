package com.algorithm.dp;

/**
 * Created by feipeixuan on 2016/11/16.
 */
public class Subject221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        } else {
            int max = 0;
            int rowLength = matrix.length;
            int columnLength = matrix[0].length;

            int[][] valueArray = new int[rowLength][];

            for (int i = 0; i < rowLength; i++) {
                valueArray[i] = new int[columnLength];
            }

            for (int i = 0; i < columnLength; i++) {
                if (matrix[0][i] == '1') {
                    valueArray[0][i] = 1;
                }
                max = Math.max(max, valueArray[0][i]);
            }

            for (int i = 0; i < rowLength; i++) {
                if (matrix[i][0] == '1') {
                    valueArray[i][0] = 1;
                }
                max = Math.max(max, valueArray[i][0]);
            }

            for (int i = 1; i < rowLength; i++) {
                for (int j = 1; j < columnLength; j++) {
                    if (matrix[i][j] == '1') {
                        valueArray[i][j] = Math.min(valueArray[i - 1][j - 1], Math.min(valueArray[i - 1][j], valueArray[i][j - 1])) + 1;
                        max = Math.max(max, valueArray[i][j]);
                    } else {
                        valueArray[i][j] = 0;
                    }
                }
            }
            return max * max;
        }
    }
}
