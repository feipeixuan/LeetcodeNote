package com.algorithm.dp;

/**
 * Created by feipeixuan on 2016/11/17.
 */
//TODO 尝试写第二种方法
public class Subject304 {

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

        Subject304 solution = new Subject304();
        solution.NumMatrix(matrix);
        System.out.println(solution.sumRegion(2, 1, 4, 3));
        System.out.println(solution.sumRegion(1, 1, 2, 2));
        System.out.println(solution.sumRegion(1, 2, 2, 4));

    }

    public void NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        valueArray = new int[rowLength][columnLength];

        for (int i = 0; i < rowLength; i++) {
            int tmp = 0;
            for (int j = 0; j < columnLength; j++) {
                valueArray[i][j] = matrix[i][j] + tmp;
                tmp = valueArray[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;

        for (int i = row1; i <= row2; i++) {
            sum = sum + valueArray[i][col2] - valueArray[i][col1] + matrix[i][col1];
        }

        return sum;
    }
}
