package com.algorithm.tree;

/**
 * @Author: feipeixuan
 * @Version: 验证序列是否为二叉搜索树的后序遍历的结果
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class VerifySquenceOfBST {

    /* 利用后序的性质 进行区间判断 */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null)
            return false;
        else if (sequence.length == 0)
            return false;
        else
            return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    public boolean VerifySquenceOfBST(int[] array, int l, int r) {
        if (l >= r)
            return true;
        else {
            int root = array[r];
            int mid = l;

            while (array[mid] < root && mid < r) {
                mid++;
            }

            for (int i = l; i <= mid - 1; i++)
                if (array[i] > root)
                    return false;

            for (int i = mid; i < r; i++)
                if (array[i] < root)
                    return false;

            return VerifySquenceOfBST(array, l, mid - 1) && VerifySquenceOfBST(array, mid, r - 1);
        }
    }
}
