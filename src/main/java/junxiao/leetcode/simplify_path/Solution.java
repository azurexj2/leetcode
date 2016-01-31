package junxiao.leetcode.simplify_path;

import java.util.*;

public class Solution {
	public String simplifyPath(String path){
		if (path==null || path.isEmpty()) return path;
		Deque<String> queue = new ArrayDeque<>();
		StringBuilder str = new StringBuilder();
		// need parse ".", "..", "", "/"
		if (path.charAt(path.length()-1)!='/')
			path += '/';
		for (int i = 1;i<path.length();++i){
			if (path.charAt(i)!='/'){
			   str.append(path.charAt(i));	
			}
			else {
				// we enter another "/"
				if (str.length()==0){
					//case "//"
					continue;
				}
				else if (str.toString().equals(".")){
					// "/./"
					str.setLength(0);
				}
				else if (str.toString().equals("..")){
					//need pop out
					if (!queue.isEmpty()){
						queue.removeFirst();
					}
					str.setLength(0);
				}
				else {
					// normal name
					queue.addFirst(str.toString());
					str.setLength(0);
				}
			}
		}
		if (queue.isEmpty()){
			return new String("/");
		}
		StringBuilder res = new StringBuilder();
		while (!queue.isEmpty()){
			res.append("/");
			res.append(queue.removeLast());
		}
		return res.toString();
	}
}
