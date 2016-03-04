package junxiao.leetcode.course_schedule_ii;

import java.util.*;

import org.w3c.dom.css.ElementCSSInlineStyle;

public class Solution {
	public int[] findOrder(int numCourses, int[][] prerequisites){
		int[] order = new int[numCourses];
		if (numCourses==0 || prerequisites.length==0) return order;
//need construct inDegree
//need construct map<course, list of course dependes on it>
int[] inDegree = new int[numCourses];
Map<Integer, List<Integer>> dependentCourse = new HashMap<>();
for (int[] course : prerequisites){
	int curCourse = course[0];
	int preRequest = course[1];
	inDegree[curCourse]++;
	if (!dependentCourse.containsKey(preRequest)){
		List<Integer> courseList = new ArrayList<Integer>();
		courseList.add(curCourse);
		dependentCourse.put(preRequest, courseList);
	}
	else {
	    dependentCourse.get(preRequest).add(curCourse);
	}
}
Deque<Integer> queue = new ArrayDeque<>();
for (int i = 0; i <numCourses;++i){
	if (inDegree[i]==0){
		queue.add(i);
	}
}
int count = 0;
while(!queue.isEmpty()){
	int corseLable = queue.remove();
	order[count++] = corseLable;
	if (!dependentCourse.containsKey(corseLable)) continue;
	for (Integer n : dependentCourse.get(corseLable)){
		inDegree[n]--;
		if (inDegree[n]==0){
			queue.add(n);
		}
	}
}
if (count == numCourses){
	return order;
}
else {
	return new int[0];
}
	}
}
