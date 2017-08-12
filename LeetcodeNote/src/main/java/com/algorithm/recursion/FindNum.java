package com.algorithm.recursion;

/**
 * @Author:   feipeixuan
 * @Version:  二维矩阵找数
 * @Link:     牛客网
 * @From:     剑指offer
 */
public class FindNum {

    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0)
            return false;
        else
            return findNum(target, array, 0, 0, array.length - 1, array[0].length - 1);
    }

    /*
         递归思想解决问题，考虑以下三种情况
         1.==
         2.>  可以去掉右下
         3.<  可以去掉左上
     */
    public boolean findNum(int target, int[][] array, int x1, int y1, int x2, int y2) {
        if (x1 > x2 || y1 > y2)
            return false;
        int midX = x1 + (x2 - x1) / 2;
        int midY = y1 + (y2 - y1) / 2;
        if (array[midY][midX] == target)
            return true;
        else if (array[midY][midX] > target)
            return findNum(target, array, x1, y1, x2, midY - 1) || findNum(target, array, x1, midY, midX - 1, y2);
        else {
            return findNum(target, array, midX + 1, y1, x2, y2) || findNum(target, array, x1, midY + 1, midX, y2);
        }
    }
}
