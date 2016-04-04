package junxiao.leetcode.meeting_rooms_ii;

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
    public int minMeetingRooms(Interval[] intervals) {
        int len = intervals.length;
        if (len<=1) return len;
        int[] begin = new int[len];
        int[] end = new int[len];
        for (int i = 0; i < len; ++i){
            begin[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(begin);
        Arrays.sort(end);
        int leastEmptyRoomFinshedTime = 0;
        int room = 0;
        for (int i = 0; i<len;++i){
            if (begin[i] < end[leastEmptyRoomFinshedTime])
                // the start time is less than the least empty room, we need one more room
                ++room;
            else
                // meeting i can use the least empty room
                // the pointer point to next avaliable room ending time
                ++leastEmptyRoomFinshedTime;
        }
        return room;
    }
}
public class Solution1 {
    public int minMeetingRooms(Interval[] intervals) {
        int len = intervals.length;
        if (len<=1) return len;
        Arrays.sort(intervals, (o1,o2)->o1.start - o2.start);
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(intervals[0].end);
        for (int i = 1; i<intervals.length;++i){
            if (intervals[i].start >= queue.peek()){
                // we can use the least recent finished meeting room
                queue.remove();
            }
            queue.add(intervals[i].end);

        }
        return queue.size();
    }
}
public class Solution2 {
    public int minMeetingRooms(Interval[] intervals) {
        int len = intervals.length;
        if (len<=1) return len;
        Arrays.sort(intervals, (o1,o2)->o1.start - o2.start);
        int maxRoom = 1;
        Queue<Integer> queue = new PriorityQueue<>();
        for (Interval meeting : intervals){
            while(!queue.isEmpty() && meeting.start>= queue.peek()){
                queue.remove();
            }
            queue.add(meeting.end);
            maxRoom = Math.max(maxRoom,queue.size());
        }
        return maxRoom;
    }
}