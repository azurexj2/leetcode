package junxiao.leetcode.read_n_characters_given_read4_ii_call_multiple_times;

import java.util.*;

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private char[] tmp = new char[4];
    private int offset = 0;
    private int len = -1;
    //offset store how many byte has already beed read
    /// bufLen store how many byte in the tmp buffer
    public int read(char[] buf, int n) {
        int count = 0;
            //first pick up left over
            int i;
            for (i = offset; i<len && count<n; ++i,++count){
                buf[count] = tmp[i];
            }
            offset = i;
            if (len>=0 && len<4)
                return count;
            
        while (count < n){
            len = read4(tmp);
                //we have read the end of file, stop
                for (i =0;i <len && count<n;++i,++count){
                    buf[count] = tmp[i];
                }
                offset = i;
                if (len < 4)
                    return count;
        }
        //now we have 4 or less to read according to maxium allowed
        return count;
    }
}