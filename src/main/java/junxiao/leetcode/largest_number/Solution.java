package junxiao.leetcode.largest_number;

import java.util.*;

public class Solution {
	public String largestNumber(int[] nums){
		String[] str = new String[nums.length];
		for (int i =0;i<nums.length;++i){
			str[i] = String.valueOf(nums[i]);
		}
		//Arrays.sort(str,new MyComparator());
		quickSort(str, 0, str.length-1);
		int start = 0;
		while (start<str.length-1 && str[start].equals("0")){
			++start;
		}
		return String.join("", Arrays.copyOfRange(str, start, str.length));
		
	}
	private class MyComparator implements Comparator<String>{
		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			String str = o2+o1;
			return str.compareTo(o1+o2); 
		}
	}
	private void quickSort(String[] str, int start, int end){
		if (start>=end) return;
		int M = start + (end-start)/2;
		String pivotal = str[M];
		swap(str, M, end);
		int lt = start, ptr = start;
		while(ptr <= end-1){
			String s = str[ptr] + pivotal;
			if (s.compareTo(pivotal + str[ptr])>0){
				swap(str, ptr, lt);
				++lt;
			}
			++ptr;
		}
		swap(str, lt, end);
		quickSort(str, start, lt-1);
		quickSort(str, lt+1, end);
		
	}
	private void swap(String[] str, int i, int j){
		String tmp = str[i];
		str[i] = str[j];
		str[j] = tmp;
	}
}
