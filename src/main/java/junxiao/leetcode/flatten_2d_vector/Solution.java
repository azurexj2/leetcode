package junxiao.leetcode.flatten_2d_vector;

import java.util.*;

public class Vector2D implements Iterator<Integer> {
    private int counter;
    private int size;
    private List<Integer> vec1d;
    public Vector2D(List<List<Integer>> vec2d) {
        vec1d = new ArrayList<>();
        for (List<Integer> arr : vec2d){
                vec1d.addAll(arr);
        }
        size = vec1d.size();
    }

    @Override
    public Integer next() {
        int res = vec1d.get(counter);
        ++counter;
        return res;
    }

    @Override
    public boolean hasNext() {
        if (counter>=size)
            return false;
        return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */