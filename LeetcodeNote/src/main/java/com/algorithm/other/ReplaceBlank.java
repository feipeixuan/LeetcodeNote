package com.algorithm.other;

/**
 * @Author: feipeixuan
 * @Version:
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class ReplaceBlank {

    /* 先删除再添加 */
    public String replaceSpace(StringBuffer str) {
        for (int i = 0; i < str.length(); ) {
            char ch = str.charAt(i);
            if (ch != ' ')
                i++;
            else {
                str.delete(i, i + 1);
                str.insert(i, "%20");
                i = i + 2;
            }
        }

        return str.toString();
    }
}
