package junxiao.leetcode.read_n_characters_given_read4;

import java.util.*;

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        while (count < n){
            char[] tmp = new char[4];
            int len = read4(tmp);
                //we have read the end of file, stop
                for (int i =0;i <len && count<n;++i,++count){
                    buf[count] = tmp[i];
                }
                if (len < 4)
                    return count;
        }
        //now we have 4 or less to read according to maxium allowed
        return count;
        
    }
}