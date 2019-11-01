package org.songzxdev.leetcode.week01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 题号：1207.独一无二的出现次数
 * 标签：哈希表
 */
public class Solution1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numMap = new HashMap<>(16);

        for (Integer a : arr) {
            if (numMap.containsKey(a)) {
                numMap.put(a, numMap.get(a) + 1);
            } else {
                numMap.put(a, 1);
            }
        }
        Set<Integer> set = new HashSet<>(numMap.values());
        return set.size() == numMap.values().size();
    }
}
