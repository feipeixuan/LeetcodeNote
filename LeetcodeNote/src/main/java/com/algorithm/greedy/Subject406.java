package com.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mario on 2016/11/21.
 */
public class Subject406 {

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] res = reconstructQueue(people);
        for(int [] tmp:res)
        {
            System.out.println(tmp[0]);
        }
    }

    public static int[][] reconstructQueue(int[][] people) {
        if (people == null) {
            return null;
        }
        int length = people.length;
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return -1;
                } else if (o1[0] < o2[0]) {
                    return 1;
                } else {
                    return o1[1] > o2[1] ? 1 : -1;
                }
                /*
                高度按照从大到小的方式排列
                高度相同根据k从小到大排列
                 */
            }
        });
        List<int[]> res = new LinkedList();

        for (int[] cur : people) {
            res.add(cur[1], cur);
        }

        return res.toArray(new int[people.length][]);
    }
}
