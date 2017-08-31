package com.algorithm.backtrack;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @Author: feipeixuan
 * @Version:  字典字符串排列
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class StringPermutation {

    public static void main(String[] args) {
        ArrayList<String> list = new StringPermutation().Permutation("aab");
        for (String str : list)
            System.out.println(str);
    }

    ArrayList<String> list = new ArrayList();

    public ArrayList<String> Permutation(String str) {

        if (str == null || str.equals(""))
            return list;
        StringBuilder builder = new StringBuilder(str);
        backtrack(builder, 0);
        return list;
    }

    /* 冒泡排序 */
    public void sort(StringBuilder builder, int index) {
        for (int i = 0; i < builder.length() - index - 1; i++)
            for (int j = index; j < builder.length() - i - 1; j++)
                if (builder.charAt(j) > builder.charAt(j + 1))
                    swap(j, j + 1, builder);
    }

    /* 回溯法 【当前状态确定，向一个状态进发】
        需要注意的点：
        1.不能无线递归，到一定程度return
        2.排列问题，注意还原
     */
    public void backtrack(StringBuilder builder, int index) {
        if (index == builder.length() - 1) {
            list.add(builder.toString());
            return;
        }

        sort(builder, index);//有序

        for (int i = index; i < builder.length(); i++) {
            if (i == index || builder.charAt(i) != builder.charAt(index)) {
                swap(i, index, builder);         //交换好，确定一个位置
                backtrack(builder, index + 1);    //后面继续回溯
                sort(builder, index + 1); //还原
            }
        }
    }

    public void swap(int i, int j, StringBuilder builder) {
        char ch = builder.charAt(j);
        builder.setCharAt(j, builder.charAt(i));
        builder.setCharAt(i, ch);
    }


}
