package junxiao.leetcode.number_of_digit_one;

import java.util.*;

public class Solution {
public int countDigitOne(int n) {
  int count = 0;

  for (long k = 1; k <= n; k *= 10) {
    long r = n / k, m = n % k;
    // sum up the count of ones on every place k
    // r/10 *k deal with 1,10,100,1000... digital 1
    // (r%10==1 ? m+1 :0) deal with e.g. 10,11,12,13
    // (r+8) deal with e.g. 20,21,22,23, when r>=2, we need count it as full
    count += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0);
  }

  return count;
}
}