package junxiao.leetcode.find_the_celebrity;

import java.util.*;

/* The knows API is defined in the parent class Relation.
boolean knows(int a, int b); */

public class Solution extends Relation {
public int findCelebrity(int n) {
  if (n==0) return -1;
  if (n==1) return 0;
  Set<Integer> set = new HashSet<>();
  for (int i =0; i <n; ++i){
      set.add(i);
  }
  int a =0, b = 0;
  while (set.size() >=2 ){
      Iterator<Integer> ptr = set.iterator();
      a = ptr.next();
      b = ptr.next();
      if (knows(a,b)){
          // a knows b
          set.remove(a);
      }
      else {
          // a didn't b
          set.remove(b);
      }
  }
  int last = set.iterator().next();
  //check last is c or not
  for (int i =0; i <n; ++i){
      if (i!=last){
          if (!knows(i,last) || knows(last,i))
              return -1;
      }
  }
  return last;

}
}
public class Solution2 extends Relation {
    public int findCelebrity(int n) {
        if (n==0) return -1;
        if (n==1) return 0;
        int candidate = 0;
        for (int i = 0; i < n; ++i){
            if (knows(candidate,i)){
                candidate = i;
            }
        }
        //from 0 to candidate-1, at least one peopele didn't know it
        //from candidate+1 to n, candidate didn't know it
        //check candidate is c or not
        for (int i =0; i <n; ++i){
                if (i!=candidate){
                    if (!knows(i,candidate) || knows(candidate,i))
                        return -1;
                }
        }
        return candidate;

    }
}