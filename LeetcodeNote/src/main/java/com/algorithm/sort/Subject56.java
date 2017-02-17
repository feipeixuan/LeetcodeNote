package com.algorithm.sort;

import java.util.*;

/**
 * Created by feipeixuan on 2017/2/16.
 */

public class Subject56 {

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start)
                    return -1;
                else if (o1.start > o2.start)
                    return 1;
                else
                    return o1.end == o2.end ? 0 : o1.end < o2.end?-1:1;
            }
        });
        List<Interval> list = new LinkedList<Interval>();
        Interval pre = null;
        for (Interval interval : intervals) {
            if (pre == null) {
                list.add(interval);
                pre = interval;
                continue;
            }
            if (interval.start > pre.end) {
                list.add(interval);
                pre = interval;
            } else {
                pre.end = Math.max(pre.end,interval.end);
            }
        }
        return list;
    }


    public static void main(String args[]) {

    }
}

class Interval {
    public int start;
    public int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}