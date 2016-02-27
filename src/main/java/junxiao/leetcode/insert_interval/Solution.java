package junxiao.leetcode.insert_interval;

import java.util.*;
public class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}

public class Solution {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval){
		List<Interval> res = new ArrayList<>();
		if (intervals==null || intervals.size()==0){
			res.add(newInterval);
			return res;
		}
		int i = 0;
		for (; i < intervals.size();++i){
			Interval cur = intervals.get(i);
			if (newInterval.start>cur.end){
				res.add(cur);
			}
			else {
				newInterval.start = Math.min(cur.start, newInterval.start);
				while(i < intervals.size() && newInterval.end >= cur.start){
					newInterval.end = Math.max(newInterval.end, cur.end);
					++i;
					cur = intervals.get(i);
				}
				res.add(newInterval);
				for (int j = i; j < intervals.size(); ++j){
					res.add(intervals.get(j));
					}
				return res;
			}
		}
		res.add(newInterval);
		return res;
	}
}
