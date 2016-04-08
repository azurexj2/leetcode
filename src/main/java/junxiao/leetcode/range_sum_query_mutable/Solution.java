package junxiao.leetcode.range_sum_query_mutable;

import java.util.*;

public class NumArray {
    private Node root;
    public NumArray(int[] nums) {
        if (nums.length==0) return;
        root = buildTree(nums,0, nums.length-1);
    }

    void update(int i, int val) {
        updateTree(root, i, val);
    }

    public int sumRange(int i, int j) {
        return searchTree(root,i,j);
    }
    private int searchTree(Node root, int start, int end){
        if (root.start== start && root.end==end)
            return root.sum;
        else {
            int M = root.start+ (root.end-root.start)/2;
            if (end<=M){
                return searchTree(root.left,start,end);
            }
            else if (start > M){
                return searchTree(root.right,start,end);
            }
            else {
                return searchTree(root.left,start,M)
                        + searchTree(root.right,M+1,end);
            }
        }
    }
    private void updateTree(Node root, int i, int val){
        if (root.start==root.end)
            root.sum = val;
        else {
            int M  = root.start+(root.end-root.start)/2;
            if (i <= M){
                updateTree(root.left, i, val);
            }
            else {
                updateTree(root.right,i,val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }
    private Node buildTree(int[] nums, int start, int end){
        Node root = null;
        //if start > end, return null
        if (start==end){
            root = new Node(start,end);
            root.sum = nums[start];
        }
        else if (start<end){
            root = new Node(start,end);
            int M = start+ (end-start)/2;
            Node left = buildTree(nums,start,M);
            Node right = buildTree(nums,M+1,end);
            root.sum = left.sum + right.sum;
            root.left = left;
            root.right = right;
        }
        return root;
    }
    public class Node {
        public int start, end;
        public int sum;
        public Node left, right;
        public Node(int start, int end){
            this.start = start;
            this.end = end;
            sum = 0;
            left=null;
            right=null;
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);