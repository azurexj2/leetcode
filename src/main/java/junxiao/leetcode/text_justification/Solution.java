package junxiao.leetcode.text_justification;

import java.util.*;

public class Solution {
	public List<String> fullJustify(String[] words, int maxWidth){
		List<String> res = new ArrayList<>();
		int wordInd = 0;
		for (int i = 0; i<words.length;i=wordInd){
			//each iteration we build up one line
			int len = -1;
			//here wordInd is one position pass what we should push to
			// from i to wordInd-1 is what we are interested in
			for (; wordInd<words.length && len + 1 + words[wordInd].length() <= maxWidth; ++wordInd){
				// count extra space, therefore init len as -1;
				len += words[wordInd].length() + 1;
			}
			int totalExtraSpace = maxWidth - len;
			int wordPerLine = (wordInd - 1) - i + 1;
			int space = 1;
			int extraSpace = 0;
		if (wordInd != words.length || wordPerLine==1){	
			//note here we need add 1 as we already include in len calculation
			space = totalExtraSpace / (wordPerLine -1) + 1;
			extraSpace = totalExtraSpace % (wordPerLine - 1);
		}
			
			// put first words in. then we have pattern ""+words to add
			StringBuilder line = new StringBuilder(words[i]);
			for (int j = i+1; j < wordInd; ++j){
				int spaceCount = space;
				while(spaceCount>0){
					line.append(" ");
					--spaceCount;
				}
				if (extraSpace > 0){
					line.append(" ");
					--extraSpace;
				}
				line.append(words[j]);
			}
			while(line.length() < maxWidth){
				line.append(" ");
			}
			res.add(line.toString());
		}
		return res;
	}
}
