package junxiao.leetcode.encode_and_decode_strings;

import java.util.*;

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        // we add '/' here to indentify string len
        // anther way is we use fixed lengh of digital to repensent len
        // for example, string.format('%4d',n)
        StringBuilder s = new StringBuilder();
        for (String str : strs){
            //s.append(str.length() + '/' + str);
            s.append(str.length()).append('/').append(str);
        }
        return s.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0;
        List<String> res = new ArrayList<>();
        while(i<s.length()){
            int slash = s.indexOf("/",i);
            int len = Integer.valueOf(s.substring(i,slash));
            res.add(s.substring(slash+1, slash+1+len));
            i = slash+1+len;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));