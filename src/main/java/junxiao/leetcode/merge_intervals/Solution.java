package junxiao.leetcode.merge_intervals;

import java.util.*;

import junxiao.leetcode.insert_interval.Interval;

public class Solution {
	public List<Interval> merge(List<Interval> intervals){
		List<Interval> res = new ArrayList<>();
		if (intervals==null || intervals.size()==0) return res;
		for (Interval sec : intervals){
			res = insert(res, sec);
		}
		return res;
		
	}
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
				while(i < intervals.size() && newInterval.end >= intervals.get(i).start){
					newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
					++i;
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
