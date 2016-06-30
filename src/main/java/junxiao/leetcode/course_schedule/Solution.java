package junxiao.leetcode.course_schedule;

import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> graph  = new HashMap<>();
        for (int[] edge : prerequisites){
            int course = edge[0];
            int preReq = edge[1];
            if (!graph.containsKey(preReq)){
                graph.put(preReq,new ArrayList<Integer>());
            }
            graph.get(preReq).add(course);
            inDegree[course]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        int count = numCourses;
        for (int n : inDegree){
            if (n==0){
                queue.offer(n);
                --count;
            }
        }
        while(!queue.isEmpty()){
            int course = queue.poll();
            if (!graph.containsKey(course)) continue;
            for (int m : graph.get(course)){
                --inDegree[m];
                if (inDegree[m] == 0){
                    queue.offer(m);
                    --count;
                }
            }
        }
        return count==0;
        
    }
}
public class Solution2 {
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
