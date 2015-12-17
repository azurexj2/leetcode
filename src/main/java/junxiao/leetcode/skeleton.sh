#!/bin/bash

leetcode_name="$1"

if [ -z "$leetcode_name" ]; then
    echo $0 "leetcode_name"
    exit;
fi

if [ -d "$leetcode_name" ]; then
    echo "$leetcode_name exist"
    exit;
fi

info=`curl -s https://leetcode.com/problemset/algorithms/  | grep /$leetcode_name/ -B 2`
IFS=
leetcode_id=`(sed 's/<td>\\(.*\\)<\\/td>/\\1/' | sed 's/^ *//') < <(echo $info | head -n 1)`
title=`(sed 's/<a.*>\\(.*\\)<\\/a>/\\1/' | sed 's/^ *//') < <(echo $info | tail -n 1)`

if [ -z "$leetcode_id" ]; then
    echo "cant fetch leetcode_id for $leetcode_name"
    exit
fi

now=`date --rfc-3339=seconds`

#l_name=`(sed 's/-/_/g') < <(echo $leetcode_name)`
#mkdir -p $l_name
mkdir -p $leetcode_name

#true > $leetcode_name/index.md
#for line in $TEMPLE; do echo $line >> $leetcode_name/index.md; done
cat > $leetcode_name/index.md <<EOL
---
layout: solution
title: $title
date: $now
leetcode_id: $leetcode_id
---
{% include_relative README.md %}
EOL


touch $leetcode_name/README.md
touch $leetcode_name/Solution.java

cat > $leetcode_name/Solution.java <<EOL
package junxiao.leetcode.$leetcode_name;

import java.util.*;

public class Solution {
}
EOL
