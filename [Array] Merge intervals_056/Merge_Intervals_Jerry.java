package com.example.starlitya.onlineassement.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

 */
public class Merge_Intervals_Jerry {
    /**
      Definition for an interval. */
      public static class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
      }

//24 ms
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }

        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(final Interval lhs,Interval rhs) {
                return lhs.start - rhs.start;
            }
        });

        List<Interval> newList = new ArrayList<Interval>();
        int lastStart = intervals.get(0).start;
        int lastEnd = intervals.get(0).end;
        for(int i=1; i< intervals.size() ; i++) {
            if (intervals.get(i).start > lastEnd) {
                newList.add(new Interval(lastStart, lastEnd));

                lastStart = intervals.get(i).start;
                lastEnd = intervals.get(i).end;
                continue;
            }

            lastEnd = Math.max(lastEnd, intervals.get(i).end);
        }

        // add last
        newList.add(new Interval(lastStart, lastEnd));
        return newList;
    }

    // 54ms
    public List<Interval> merge_old(List<Interval> intervals) {
        System.out.println("test 1" + intervals.toString());
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(final Interval lhs,Interval rhs) {
                if (lhs.start < rhs.start) {
                    return -1;
                } else if (lhs.start > rhs.start) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println("test 2" + intervals.toString());

        List<Interval> newList = new ArrayList<Interval>();
        int forwardIndex;
        for(int i=0; i< intervals.size() ; ) {
            forwardIndex = i;
            for (int j=i+1; j < intervals.size(); j++) {
                if (intervals.get(i).end >= intervals.get(j).start) {
                    intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(j).end);
                    forwardIndex = j;
                }
            }
            newList.add(intervals.get(i));
            i = forwardIndex + 1;
        }

        return newList;
    }

}