package junxiao.leetcode.meeting_rooms;

import java.util.*;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        try {
            Arrays.sort(intervals, new intervalsComparator());
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
    private class intervalsComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2){
            if (o1.start < o2.start && o1.end <= o2.start)
                return -1;
            else if (o1.start > o2.start && o1.start>=o2.end)
                return 1;
            else 
                throw new RuntimeException();
        }
    }
}
public class Solution2 {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (o1,o2)->(o1.start - o2.start));
        for (int i = 1; i < intervals.length;++i){
            if (intervals[i].start < intervals[i-1].end){
                return false;
            }
        }
        return true;
    }
}