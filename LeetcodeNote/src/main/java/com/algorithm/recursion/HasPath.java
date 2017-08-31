package com.algorithm.recursion;

/**
 * @Author: feipeixuan
 * @Version: 寻找路径，回溯法解决
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class HasPath {

    public static void main(String[] args) {
        char[] mastrix = "ABCESFCSADEE".toCharArray();
        char[] str = "SEE".toCharArray();
        System.out.println(new HasPath().hasPath(mastrix, 3, 4, str));

    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || str == null)
            return false;
        else {
            char[][] array = new char[rows][];

            for (int i = 0; i < rows; i++)
                array[i] = new char[cols];

            for (int i = 0; i < matrix.length; i++) {
                int y = i / cols;
                int x = i % cols;
                array[y][x] = matrix[i];
            }

            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    if (visitPath(array, str, rows, cols, i, j, 0))
                        return true;

            return false;

        }
    }

    public boolean visitPath(char[][] matrix, char[] str, int rows, int cols, int x, int y, int index) {
        if (x < 0 || y < 0 || x >= cols || y >= rows || index >= str.length)
            return false;
        else {
            if (matrix[y][x] != str[index])
                return false;
            else if (index == str.length - 1 && matrix[y][x] == str[index])
                return true;
            else {
                char c = matrix[y][x];
                matrix[y][x] = 0;
                boolean b1 = visitPath(matrix, str, rows, cols, x + 1, y, index + 1) || visitPath(matrix, str, rows, cols, x - 1, y, index + 1);
                boolean b2 = visitPath(matrix, str, rows, cols, x, y + 1, index + 1) || visitPath(matrix, str, rows, cols, x, y - 1, index + 1);
                if (b1 || b2)
                    return true;
                else
                    matrix[y][x] = c;
                return false;
            }
        }
    }

}
