package org.songzxdev.leetcode.week01;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：771.宝石与石头
 * 标签：哈希表
 */
public class Solution771 {
    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        Map<Character, Integer> jMap = new HashMap<>(16);
        for (char j : J.toCharArray()) {
            jMap.put(j, 0);
        }
        for (char s : S.toCharArray()) {
            if (jMap.containsKey(s)) {
                ans +=1;
            }
        }
        return ans;
    }
}
