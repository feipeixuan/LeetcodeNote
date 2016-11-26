package com.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Mario on 2016/11/26.
 */
public class Subject435 {

    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null) {
            return 0;
        }
        int length = intervals.length;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if (o1.end > o2.end) {
                    return 1;
                } else if (o1.end < o2.end) {
                    return -1;
                } else {
                    return o2.start - o1.start;
                }
            }
        });
        int end = Integer.MIN_VALUE;
        int size=0;

        for (Interval interval : intervals) {
            if(interval.start>=end){
                size++;
                end=interval.end;
            }
        }

        return length-size;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}