package junxiao.leetcode.course_schedule;

import java.util.*;

public class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites){
		if (numCourses<=1) return true;
		if (prerequisites.length<=1) return true;
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
while(!queue.isEmpty()){
	int corseLable = queue.remove();
	if (!dependentCourse.containsKey(corseLable)) continue;
	for (Integer n : dependentCourse.get(corseLable)){
		inDegree[n]--;
		if (inDegree[n]==0){
			queue.add(n);
		}
	}
}
for (int i =0; i <numCourses;++i){
	if (inDegree[i]!=0)
		return false;
}
return true;
	}
}
