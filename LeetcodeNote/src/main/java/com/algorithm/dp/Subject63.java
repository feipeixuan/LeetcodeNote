package com.algorithm.dp;

/**
 * Created by feipeixuan on 2016/11/16.
 */
public class Subject63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        } else if (obstacleGrid[0][0] == 1) {
            return 0;
        } else {
            int rowLength = obstacleGrid.length;
            int columnLength = obstacleGrid[0].length;
            int[][] valueArray = new int[rowLength][];

            for (int i = 0; i < rowLength; i++) {
                valueArray[i] = new int[columnLength];
            }

            for (int i = 0; i < rowLength; i++) {
                if (obstacleGrid[i][0] != 0) {
                    break;
                }
                valueArray[i][0] = 1;
            }

            for (int i = 0; i < rowLength; i++) {
                for (int j = 1; j < columnLength; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        valueArray[i][j] = 0;
                    } else {
                        if (i - 1 >= 0) {
                            valueArray[i][j] = valueArray[i - 1][j] + valueArray[i][j - 1];
                        } else {
                            valueArray[i][j] = valueArray[i][j - 1];
                        }
                    }
                }
            }
            return valueArray[rowLength - 1][columnLength - 1];
        }
    }
}
