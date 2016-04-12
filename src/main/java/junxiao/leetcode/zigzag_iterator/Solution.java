package junxiao.leetcode.zigzag_iterator;

import java.util.*;

public class ZigzagIterator {
    private Iterator<Integer> it1;
    private Iterator<Integer> it2;
    private Iterator<Integer> ptr;
    private boolean flagv1 = true;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        it1 = v1.iterator();
        it2 = v2.iterator();
        movePtr();
    }

    public int next() {
        int res = ptr.next();
        movePtr();
        return res;
    }

    public boolean hasNext() {
        return ptr.hasNext();
    }
    private void movePtr(){
        if (flagv1){
            ptr = it1;
            if (!ptr.hasNext()){
                ptr = it2;
            }
        }
        else {
            ptr = it2;
            if (!ptr.hasNext()){
                ptr = it1;
            }
        }
        flagv1 = !flagv1;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */