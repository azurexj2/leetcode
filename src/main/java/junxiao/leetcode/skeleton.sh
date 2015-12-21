#!/bin/bash

leetcode_name="$1"

if [ -z "$leetcode_name" ]; then
    echo $0 "leetcode_name"
    exit;
fi

l_name=`(sed 's/-/_/g') < <(echo $leetcode_name)`

if [ -d "$l_name" ]; then
    echo "$l_name exist"
    exit;
fi

info=`curl -s https://leetcode.com/problemset/algorithms/  | grep /$leetcode_name/ -B 2`
#echo $info
IFS=
leetcode_id=`(sed 's/<td>\\(.*\\)<\\/td>/\\1/' | sed 's/^ *//') < <(echo $info | head -n 1)`
#echo $leetcode_id
title=`(sed 's/<a.*>\\(.*\\)<\\/a>/\\1/' | sed 's/^ *//') < <(echo $info | tail -n 1)`

if [ -z "$leetcode_id" ]; then
    echo "cant fetch leetcode_id for $leetcode_name"
    exit
fi

now=`date`

mkdir -p $l_name

#true > $leetcode_name/index.md
#for line in $TEMPLE; do echo $line >> $leetcode_name/index.md; done
cat > $l_name/index.md <<EOL
---
layout: solution
title: $title
date: $now
leetcode_id: $leetcode_id
---
{% include_relative README.md %}
EOL


touch $l_name/README.md
touch $l_name/Solution.java

cat > $l_name/Solution.java <<EOL
package junxiao.leetcode.$l_name;

import java.util.*;

public class Solution {
}
EOL
