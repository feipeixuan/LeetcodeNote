package com.algorithm.other;/**
 * Created by feipeixuan on 2017/8/10.
 */

/**
 * @Author: feipeixuan
 * @Version:
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class ConvertStringToInt {

    /* 注意考虑各种情况，空字符串，包含非法字符，正负数  */
    public int StrToInt(String str) {
        if (str == null || str.equals(""))
            return 0;
        boolean flag = true;
        int index = 0;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            index++;
            flag = str.charAt(0) == '+';
        }
        int n = 1;
        int sum = 0;

        for (; index < str.length(); index++) {
            char ch = str.charAt(index);
            if (ch >= 48 && ch <= 57)
                sum = sum * 10 + ch - 48;
            else
                return 0;
        }
        if (!flag)
            return 0 - sum;
        else
            return sum;
    }
}
