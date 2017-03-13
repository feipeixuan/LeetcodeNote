package com.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by feipeixuan on 2017/3/13.
 */
public class Subject139 {

    public static void main(String[] args) {
        String s="acccbccb";
        List<String> list=new ArrayList<String>();
        list.add("cc");
        list.add("bc");
        list.add("ac");
        list.add("ca");
        System.out.println(new Subject139().wordBreak(s,list));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int[] array = new int[s.length() + 1];
        array[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            String substring = s.substring(0, i);

            for (int j = 0; j < wordDict.size(); j++) {
                String str = wordDict.get(j);

                if (str.length() <= substring.length()
                        && substring.substring(substring.length()-str.length(),substring.length()).equals(str)
                        && array[i - str.length()] == 1) {
                    array[i] = 1;
                    break;
                }
            }
        }

        return array[s.length()] > 0 ? true : false;
    }
}
